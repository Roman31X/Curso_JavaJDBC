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
        MensajeDAO.leerMensajeBD();
    }

    public static void BorrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("INgrese el mensaje a Borrar: ");
        System.out.print("=> ");
        int id_mensaje = sc.nextInt();
        MensajeDAO.BorrarMensajeBD(id_mensaje);
    }

    public static void ActualizarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Debe de ingrese sar el nuevo mensaje :");
        System.out.print("=> ");
        String nuevoMensaje = sc.nextLine();

        System.out.println("Ingrese ID del mensaje a cambiar:");
        System.out.print("=> ");
        int id_mensaje = sc.nextInt();

        Mensaje actualizado = new Mensaje();
        actualizado.setId_mensaje(id_mensaje);
        actualizado.setMensaje(nuevoMensaje);
        MensajeDAO.actualizarMensajeBD(actualizado);
    }
}
