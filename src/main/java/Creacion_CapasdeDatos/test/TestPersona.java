package Creacion_CapasdeDatos.test;


import Creacion_CapasdeDatos.datos.Conexion;
import Creacion_CapasdeDatos.datos.PersonaDAO_JDBC;
import Creacion_CapasdeDatos.domain.PersonaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestPersona {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            PersonaDAO_JDBC persona = new PersonaDAO_JDBC();
            List<PersonaDTO> listaPersonas  = persona.seleccionar();
            for(PersonaDTO lista : listaPersonas){
                System.out.println(lista);
            }
            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Sucedio un error al realback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
