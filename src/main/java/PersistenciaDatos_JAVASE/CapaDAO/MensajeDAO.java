package PersistenciaDatos_JAVASE.CapaDAO;

import PersistenciaDatos_JAVASE.CapaMODELO.Mensaje;
import PersistenciaDatos_JAVASE.ConexionWEBMYSQL.ConexionDos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajeDAO {

    public static void CrearMensajeBD(Mensaje mensaje){
        ConexionDos bd_conector = new ConexionDos();
        try(Connection conexion = bd_conector.get_connection()){
            PreparedStatement pst = null;
            try{
                String QUERY = "INSERT INTO mensajes (mensaje,autor_mensaje) VALUES (?,?)";
                pst = conexion.prepareStatement(QUERY);
                pst.setString(1,mensaje.getMensaje());
                pst.setString(2,mensaje.getAutor_mensaje());
                pst.executeUpdate();
                System.out.println("Mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajeBD(){

    }

    public static void BorrarMensajeBD(int idmensaje){

    }

    public static void actualizarMensajeBD(Mensaje mensaje){

    }

}
