package PersistenciaDatos_JAVASE.CapaDAO;

import PersistenciaDatos_JAVASE.CapaMODELO.Mensaje;
import PersistenciaDatos_JAVASE.ConexionWEBMYSQL.ConexionDos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        ConexionDos bd_conector = new ConexionDos();
        PreparedStatement pst = null;
        //esta clase nos permite traes la lista de la base de datos
        ResultSet rst = null;
        try(Connection conexion = bd_conector.get_connection()){
            String QUERY = "SELECT * FROM mensajes";
            pst = conexion.prepareStatement(QUERY);
            rst = pst.executeQuery();
            while(rst.next()){
                System.out.println("[ID] : "+rst.getInt("id_mensaje"));
                System.out.println("[MENSAJE] : "+rst.getString("mensaje"));
                System.out.println("[AUTOR] : "+rst.getString("autor_mensaje"));
                System.out.println("[FECHA] : "+rst.getString("fecha_mensaje"));
                System.out.println("[------------------------------------]");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void BorrarMensajeBD(int id_mensaje){
        ConexionDos bd_conector = new ConexionDos();
        try(Connection conexion = bd_conector.get_connection()){
            PreparedStatement pst = null;
            try{
                String QUERY = "DELETE FROM mensajes WHERE id_mensaje = ?";
                pst = conexion.prepareStatement(QUERY);
                pst.setInt(1,id_mensaje);
                pst.executeUpdate();
                System.out.println("El mensaje ha sido eliminado como tu de su vida");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("F no se pudo borrar el mensaje asi como ella no te puede olvidar");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarMensajeBD(Mensaje mensaje){
        ConexionDos bd_conector = new ConexionDos();
        PreparedStatement pst = null;
        try(Connection conexion = bd_conector.get_connection()){
            try{
                String QUERY = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                pst = conexion.prepareStatement(QUERY);
                pst.setString(1,mensaje.getMensaje());
                pst.setInt(2,mensaje.getId_mensaje());
                pst.executeUpdate();
                System.out.println("Mensaje fue actualizado con exito");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("Asi como ella no te busco para arreglar sus problemas la base no se modifico XD");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

}
