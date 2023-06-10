package Transacciones_JDBC.test;


import Transacciones_JDBC.datos.Conexion;
import Transacciones_JDBC.datos.UsuarioJDBC;
import Transacciones_JDBC.domain.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class TestUsuario {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            UsuarioJDBC usuariojdbc = new UsuarioJDBC();
            Usuario cambioUsuario = new Usuario();
            cambioUsuario.setId_usuario(2);
            cambioUsuario.setUsername("Maria");
            cambioUsuario.setPassword("5309");
            usuariojdbc.update(cambioUsuario);

            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsername("Yoselyn");
            nuevoUsuario.setPassword("2321");
            usuariojdbc.insert(nuevoUsuario);

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
