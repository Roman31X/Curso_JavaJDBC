package PersistenciaDatos_JAVASE.CapaSERVICIO;

import PersistenciaDatos_JAVASE.CapaDAO.MensajeDAO;
import PersistenciaDatos_JAVASE.CapaMODELO.Mensaje;

import java.util.Scanner;

public class MensajeServicio {
    public static void CrearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese mensaje para almacenar:");
        System.out.print("=> ");
        String mensaje = sc.nextLine();

        System.out.println("Ingrese nombre del autor: ");
        System.out.print("=> ");
        String nombre = sc.nextLine();

        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajeDAO.CrearMensajeBD(registro);
    }

    public static void ListarMensaje(){

    }

    public static void BorrarMensaje(){

    }

    public static void ActualizarMensaje(){

    }
}
