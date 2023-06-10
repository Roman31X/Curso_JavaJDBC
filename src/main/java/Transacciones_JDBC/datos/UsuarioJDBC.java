package Transacciones_JDBC.datos;


import Transacciones_JDBC.domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Transacciones_JDBC.datos.Conexion.*;


public class UsuarioJDBC {

    private Conexion coneccionTransaccion;

    private static final String SQL_SELECT = "SELECT id_usuario, username, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(username,password) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET username = ?,password = ? WHERE id_usuario  = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public UsuarioJDBC() {
    }

    public UsuarioJDBC(Conexion coneccionTransaccion) {
        this.coneccionTransaccion = coneccionTransaccion;
    }

    public List<Usuario> select() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        Usuario usuario = null;
        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        try {
            conector = (this.coneccionTransaccion != null) ? (Connection) this.coneccionTransaccion : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while (result.next()) {
                int idUsuario = result.getInt("id_usuario");
                String username = result.getString("username");
                String password = result.getString("password");
                usuario = new Usuario(idUsuario,username,password);
                listaUsuario.add(usuario);
            }
        }finally {
            try {
                //metodos para cierre de objetos
                closeRESULT(result);
                closePREPA(stmt);
                if(this.coneccionTransaccion == null){
                    closeMYSQL(conector);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return listaUsuario;
    }

    public int insert(Usuario usuario) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.coneccionTransaccion != null) ? (Connection) this.coneccionTransaccion : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            stmt.setString(1,usuario.getUsername());
            stmt.setString(2,usuario.getPassword());
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.coneccionTransaccion == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    public int update(Usuario usuario) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.coneccionTransaccion != null) ? (Connection) this.coneccionTransaccion : getConnection();
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3,usuario.getId_usuario());
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.coneccionTransaccion == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    public int eliminar(Usuario usuario) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.coneccionTransaccion != null) ? (Connection) this.coneccionTransaccion : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,usuario.getId_usuario());
            registro  = stmt.executeUpdate();
        }finally {
            try {
                //metodos para cierre de objetos
                closePREPA(stmt);
                if(this.coneccionTransaccion == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

}
