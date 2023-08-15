package PersistenciaDatos_JAVASE.ConexionWEBMYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class Conexion {

    //CREAMOS UNA VARIABLE DE CONEXIóN A INTERNET
    private Connection conection = null;
    //CREAMOS UNA VARIABLE PARA EL NOMBRE DE L ABASE DE DATOS
    private final String BD_NAME = "mensajes_app";
    //CREAMOS UNA VARIABLE QUE CONTENGA LA RUTA DE L ABASE DE DATOS
    private final String BD_URL = "jdbc:mysql://localhost:3308/"; //TAMBIEN PUEDE SER EL PUESTO IP ["jdbc:mysql://127.0.0.1:3308/"]
    //CREAMOS UNA VARIABLE QUE CONTENGA EL NOMBRE DEL USUARIO DE LA BASE DE DATOS
    private final String BD_USER = "root";
    //CREAMOS UNA VARIABLE QUE CONTENGA LA CONTRASEÑA DE LA BASE DE DATOS
    private final String BD_PASSWORD = "";

    //CLASE PUBLICA PARA REALIZAR PRUEBA DE CONEXIÓN
    public Connection get_connection() {
        try {
            /**REALIZAMOS LA CONEXIÓN MEDIANTE LA VARIABLE Y LA CLASE DRIVERMANAGER
            PARA MEJORAR LA DINAMICA CON LA RUTA DE LA CONEXIÓN ASIGNAMOS ARRIBA LOS
            DATOS NECESARIOS PARA QUE CONECTE*/
            conection = DriverManager.getConnection(BD_URL+BD_NAME,BD_USER,BD_PASSWORD);
            //CONDICION PARA EVALUAR SI LA CONEXION FUE EXITOSA
            if (conection != null) {
                System.out.println("Se conecto exitosamente a la base de datos");
            }
            //BLOQUE CATCH PARA MOSTRAR LA CAPTURA DE LA EXEPCIÓN EN CASO LA CONEXIÓN FALLE
        } catch (SQLException e) {
            //LINA PARA MOSTRAR LA MENSAJE EN CONSOLA MAS EL FALLO CAPTURADO
            System.out.println(e);
        }
        return conection;
    }

}
