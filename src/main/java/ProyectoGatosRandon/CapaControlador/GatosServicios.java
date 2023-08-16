package ProyectoGatosRandon.CapaControlador;

import ProyectoGatosRandon.CapaModelo.Gato;
import com.google.gson.Gson;
import com.squareup.okhttp.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class GatosServicios {

    public static void VerGatos() throws IOException{
        //1.- Primer paso traemos los gatos de las API
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search?limit=1")
                .get()
                .build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();

        //2.- Cortar las primeras llaves de la identación
        //Para cortar la primera llave de la cadena
        json = json.substring(1,json.length());
        //Para cortar la ultima llave de la cadena
        json = json.substring(0,json.length()-1);

        //3.- Creamos un objeto de la clase GATO
        Gson gson = new Gson();
        Gato fotoGato = gson.fromJson(json,Gato.class);

        //4.- Redimencionar la imagen obtenida por el API
        Image imgen = null;
        try{
            URL url = new URL(fotoGato.getUrl());
            imgen = ImageIO.read(url);

            ImageIcon fondoGato = new ImageIcon(imgen);
            if(fondoGato.getIconWidth() > 800){
                //REDIMENCIONAR
                Image fondo = fondoGato.getImage();
                Image modificado = fondo.getScaledInstance(800,600, Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificado);
            }

            String menu = "Opciones : \n"+
                          " [1] - Ver otra imagen\n"+
                          " [2] - Favoritos\n"+
                          " [3] - Volver\n";
            String[] botones = {"Ver otra imagen","Favoritos","Volver"};
            String id_gato = fotoGato.getId();
            String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato,JOptionPane.INFORMATION_MESSAGE,fondoGato,botones,botones[0]);
            
            int seleccion = -1;

            for (int i = 0; i < botones.length; i++) {
                if(opcion.equals(botones[i])){
                    seleccion = i;
                }
            }

            switch(seleccion){
                case 0:
                    VerGatos();
                    break;
                case 1:
                    FavoritoGato(fotoGato);
                    break;
                default:
                    break;
            }
            
        }catch(IOException e){
            System.out.println(e);
        }

    }
    public static void FavoritoGato(Gato gato){

    }
}
