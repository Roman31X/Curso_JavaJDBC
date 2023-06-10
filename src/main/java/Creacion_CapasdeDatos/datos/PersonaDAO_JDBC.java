package Creacion_CapasdeDatos.datos;

import Creacion_CapasdeDatos.domain.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Creacion_CapasdeDatos.datos.Conexion.*;


/**
 * ESTRUCTURA DAO DATA - ACCESS - OBJECT MANIPULACION DE COMANDOS SOBRE LA BASE
 * DE DATOS
 */
public class PersonaDAO_JDBC implements PersonaDAO{

    private Connection conexionTrasaccional;

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?,apellido = ?,email = ?,telefono = ? WHERE id_persona  = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public PersonaDAO_JDBC() {
    }

    public PersonaDAO_JDBC(Connection conexionTrasaccional) {
        this.conexionTrasaccional = conexionTrasaccional;
    }

    public List<PersonaDTO> seleccionar() throws SQLException {
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        PersonaDTO persona = null;
        List<PersonaDTO> listaPersona = new ArrayList<>();
        try {
            conector = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conector.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            //ESTRUCTURA WHILE PARA MOSTAR LOS DATOS OBTENIDOS DE LA BASE DE DATOS
            while (result.next()) {
                //ATRIBUTOS DONDE RECUPERRAR DATOS DE LA BD
                int idPersona = result.getInt("id_persona");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                String telefono = result.getString("telefono");
                //enviamos loa datos al objeto medinate el contructor
                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);
                //sentencia para agregar los datos recuperados de la BD en la listaPersona
                listaPersona.add(persona);
            }
        }finally {
            try {
                //metodos para cierre de objetos
                closeRESULT(result);
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conector);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return listaPersona;
    }
    public int insertar(PersonaDTO persona) throws SQLException {
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt  = conectar.prepareStatement(SQL_INSERT);
            //sentencia de inserción d los nuevos datos agregar
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            //sentencia para actualizacion de la abase de datos
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
    public int actualizar(PersonaDTO persona) throws SQLException {
        //variable de conexión
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            stmt.setInt(5,persona.getIdPersona());
            //sentencia para actualizacion de la abase de datos
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
    public int eliminar(PersonaDTO persona) throws SQLException {
        //variable de conexión
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = (this.conexionTrasaccional != null) ? this.conexionTrasaccional : getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getIdPersona());
            //sentencia para actualizacion de la abase de datos
            registro  = stmt.executeUpdate();
        }finally {
            try {
                closePREPA(stmt);
                if(this.conexionTrasaccional == null){
                    closeMYSQL(conectar);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
}
