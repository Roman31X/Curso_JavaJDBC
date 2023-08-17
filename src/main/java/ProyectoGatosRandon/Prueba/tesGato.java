package ProyectoGatosRandon.Prueba;

import ProyectoGatosRandon.CapaControlador.GatosServicios;
import ProyectoGatosRandon.CapaModelo.Gato;

import javax.swing.*;
import java.io.IOException;

public class tesGato {
    public static void main(String[] args) throws IOException {
        int opcion = -1;
        //Variable de tipo arreglo para almacenar las opciones del menú
        String[] botones = {
          " [1] - Ver gatos",
          " [2] - Ver Favoritos",
          " [3] - Salir"
        };

        //Bucle para iterar el menu y capturar la opción ingresada por consola
        do{
            //Capturar la opcion del Menú principal
            String accion = (String) JOptionPane.showInputDialog(null,"Esta listo para ver Gatitos",
                    "Este es el menu de la Interfaz",JOptionPane.INFORMATION_MESSAGE,null,botones,botones[0]);

            for (int i=0;i<botones.length;i++){
                if(accion.equals(botones[i])){
                    opcion = i;
                }
            }

            switch (opcion){
                case 0:
                    GatosServicios.VerGatos();
                    break;
                case 1:
                    Gato gato = new Gato();
                    GatosServicios.VerFavoritos(gato.getApiKey());
                default:
                    break;
            }

        }while(opcion != 1);

    }
}
