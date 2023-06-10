package LaboratorioJDBC.datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tienda?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    //METODO PARA REALIZAR LA CONEXION BD - REPORTAMOS LA EXCEPCION GENERADA [throws SQLException]
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    //METODO PARA CERRA CONEXION RESULTADO - REPORTAMOS LA ESCEPCION
    public static void closeRESULT(ResultSet rs) throws SQLException {
        rs.close();
    }

    //METODO PARA CERRA INSTANCIAS - REPORTAMOS LAS EXCEPCION
    public static void closeSTATE(Statement smtm) throws SQLException {
        smtm.close();
    }

    //METODO PARA CIERRE PERO DE MAYOR PERFORMANT
    public static void closePREPA(PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    //metodo para cerra coneccion a MYSQL - REPORTAMOS LA EXCEPCION
    public static void closeMYSQL(Connection conexion) throws SQLException{
        conexion.close();
    }
}
