package PersistenciaDatos_JAVASE.ConexionWEBMYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDos {
    private Connection conection = null;
    private final String BD_NAME = "mensajes_app";
    private final String BD_URL = "jdbc:mysql://localhost:3308/";
    private final String BD_USER = "root";
    private final String BD_PASSWORD = "";

    public Connection get_connection() {
        try {
            conection = DriverManager.getConnection(BD_URL+BD_NAME,BD_USER,BD_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return conection;
    }
}
