package PersistenciaDatos_JAVASE.test;

import PersistenciaDatos_JAVASE.ConexionWEBMYSQL.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) {
        //CREAMOS UN OBJETO DE LA CLASE DE CONEXION
        Conexion conector = new Conexion();

        try(Connection conecta = conector.get_connection()){

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
