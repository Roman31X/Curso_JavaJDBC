package PersistenciaDatos_JAVASE.test;

import PersistenciaDatos_JAVASE.CapaSERVICIO.MensajeServicio;
import PersistenciaDatos_JAVASE.ConexionWEBMYSQL.ConexionDos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class BaseDatosMensaje {
    public static void main(String[] args) {
        ConexionDos conectorUno = new ConexionDos();

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do{
            System.out.println("||-----------------------||");
            System.out.println("||APLICACIÓN DE MENSAJE  ||");
            System.out.println("|| [1] - CREAR MENSAJE   ||");
            System.out.println("|| [2] - LISTAR MENSAJE  ||");
            System.out.println("|| [3] - EDITAR MENSAJE  ||");
            System.out.println("|| [4] - ELIMINAR MENSAJE||");
            System.out.println("|| [5] - SALIR           ||");
            System.out.println("||-----------------------||");
            System.out.print("INGRESE OPCION => ");
            opcion = sc.nextInt();

            switch(opcion){
                case 1:
                    MensajeServicio.CrearMensaje();
                    break;
                case 2:
                    MensajeServicio.ListarMensaje();
                    break;
                case 3:
                    MensajeServicio.ActualizarMensaje();
                    break;
                case 4:
                    MensajeServicio.BorrarMensaje();
                    break;
                default:
                    break;
            }


        }while(opcion != 5);

    }
}
