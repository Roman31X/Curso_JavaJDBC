package Pool_DeConexiones.datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tienda?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    //MÉTODO PARA INICIALIZAR POOL DE CONEXIONES
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        //DEFINIMOS EL TAMAÑO INICIAL DEL POOL DE CONEXIONES
        ds.setInitialSize(5);
        return ds;
    }

    //MÉTODO PARA REALIZAR LA CONEXION BD - REPORTAMOS LA EXCEPCION GENERADA [throws SQLException]
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    //MÉTODO PARA CERRA CONEXION RESULTADO - REPORTAMOS LA ESCEPCION
    public static void closeRESULT(ResultSet rs) throws SQLException {
        rs.close();
    }

    //MÉTODO PARA CERRA INSTANCIAS - REPORTAMOS LAS EXCEPCION
    public static void closeSTATE(Statement smtm) throws SQLException {
        smtm.close();
    }

    //MÉTODO PARA CIERRE PERO DE MAYOR PERFORMANT
    public static void closePREPA(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    //método para cerra coneccion a MYSQL - REPORTAMOS LA EXCEPCION
    public static void closeMYSQL(Connection conexion) throws SQLException{
        conexion.close();
    }
}
