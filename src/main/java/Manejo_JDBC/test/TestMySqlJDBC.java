package Manejo_JDBC.test;

import java.sql.*;

public class TestMySqlJDBC {

    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/tienda?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            Statement intruccion = conexion.createStatement();
            var sql = "SELECT id_persona,nombre,apellido,email,telefono FROM persona";
            ResultSet resultado = intruccion.executeQuery(sql);
            System.out.println("||=ID PERSONA=||=NOMBRE=||=APELLIDO=||====EMAIL===||==TELEFONO==||");
            while(resultado.next()){
                System.out.print("|| \t[" + resultado.getInt("id_persona")+"]\t");
                System.out.print("  ["+resultado.getString("nombre")+"]");
                System.out.print("  ["+resultado.getString("apellido")+"]\t");
                System.out.print(""+resultado.getString("email")+"]\t");
                System.out.print("["+resultado.getString("telefono")+"] ");
                System.out.println("");
            }
            resultado.close();
            intruccion.close();
            conexion.close();
        } /*catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } */
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
