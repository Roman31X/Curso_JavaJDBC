package Manejo_JDBC.Coneccion_Mysql;

import Manejo_JDBC.domin.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Manejo_JDBC.Coneccion_Mysql.Conexion_Mysql.*;

/**
 * ESTRUCTURA DAO DATA - ACCESS - OBJECT MANIPULACION DE COMANDOS SOBRE LA BASE
 * DE DATOS
 */
public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?,apellido = ?,email = ?,telefono = ? WHERE id_persona  = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public List<Persona> seleccionar() {
        //atributos de manejo de DB
        Connection conector = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        //OBJETOS DE CLASE PERSONA
        Persona persona = null;
        //CREAMOS UNA LISTA PARA OBTENER INFORMACION DE TIPO PERSONA
        List<Persona> listaPersona = new ArrayList<>();
        //contenemos la instruccion Conexion_Mysql en estructura [try - catch]
        try {
            conector = getConnection();
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
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                //sentencia para agregar los datos recuperados de la BD en la listaPersona
                listaPersona.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                //metodos para cierre de objetos
                closeRESULT(result);
                closePREPA(stmt);
                closeMYSQL(conector);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return listaPersona;
    }
    public int insertar(Persona persona){
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            //conexion a l base de datos
            conectar = getConnection();
            //sentencia para tener acceso al comando con los nuevos dats registrados
            stmt  = conectar.prepareStatement(SQL_INSERT);
            //sentencia de inserción d los nuevos datos agregar
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            //sentencia para actualizacion de la abase de datos
            registro  = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                //metodos para cierre de objetos
                closePREPA(stmt);
                closeMYSQL(conectar);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
    public int actualizar(Persona persona){
        //variable de conexión
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = getConnection();
            stmt = conectar.prepareStatement(SQL_UPDATE);
            stmt.setString(1,persona.getNombre());
            stmt.setString(2,persona.getApellido());
            stmt.setString(3,persona.getEmail());
            stmt.setString(4,persona.getTelefono());
            stmt.setInt(5,persona.getIdPersona());
            //sentencia para actualizacion de la abase de datos
            registro  = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                //metodos para cierre de objetos
                closePREPA(stmt);
                closeMYSQL(conectar);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
    public int eliminar(Persona persona){
        //variable de conexión
        Connection conectar = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conectar = getConnection();
            stmt = conectar.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getIdPersona());
            //sentencia para actualizacion de la abase de datos
            registro  = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                //metodos para cierre de objetos
                closePREPA(stmt);
                closeMYSQL(conectar);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
}
