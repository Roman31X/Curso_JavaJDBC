package ProyectoGatosRandon.CapaControlador;

import ProyectoGatosRandon.CapaModelo.Gato;
import ProyectoGatosRandon.CapaModelo.GatosFavoritos;
import com.google.gson.Gson;
import com.squareup.okhttp.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GatosServicios {

    public static void VerGatos() throws IOException{
        //1.- Primer paso traemos los gatos de las API
        OkHttpClient client = new OkHttpClient();
        //MediaType mediaType = MediaType.parse("application/json");
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
                Image modificado = fondo.getScaledInstance(900,600, Image.SCALE_SMOOTH);
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
        try{

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"image_id\":\""+gato.getId()+"\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.getApiKey())
                    .build();
            Response response = client.newCall(request).execute();

        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void VerFavoritos(String apikey) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
              .url("https://api.thecatapi.com/v1/favourites")
              .get()
              .addHeader("Content-Type", "application/json")
              .addHeader("x-api-key", apikey)
              .build();
        Response response = client.newCall(request).execute();

        //Creamos un estrig para almacenar la respuesta
        String eljson = response.body().string();

        //Creamos un objeto de tipo Gson
        Gson gson = new Gson();

        //Creamos una estructura de json de favoritos
        GatosFavoritos[] gatosFavoritos = gson.fromJson(eljson, GatosFavoritos[].class);

        //Condición para evaluar si tenemos gatos validados como favoritos
        if(gatosFavoritos.length > 0){
            int minimo = 1;
            int maximo = gatosFavoritos.length;
            int aleatorio = (int) (Math.random() * ((maximo-minimo)+1)) + minimo;
            int indice = aleatorio - 1;

            GatosFavoritos favoritos = gatosFavoritos[indice];

            //Redimencionar la imagen obtenida por el API
            Image image = null;
            try{
                URL url = new URL(favoritos.getImage().getUrl());
                image = ImageIO.read(url);

                ImageIcon fondoGato = new ImageIcon(image);
                if(fondoGato.getIconWidth() > 800){
                    //REDIMENCIONAR
                    Image fondo = fondoGato.getImage();
                    Image modificado = fondo.getScaledInstance(900,600, Image.SCALE_SMOOTH);
                    fondoGato = new ImageIcon(modificado);
                }

                String menu = "Opciones : \n"+
                        " [1] - Ver otra imagen\n"+
                        " [2] - Eliminar Favoritos\n"+
                        " [3] - Volver\n";
                String[] botones = {"Ver otra imagen","Eliminar Favoritos","Volver"};
                String id_gato = favoritos.getId();
                String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato,JOptionPane.INFORMATION_MESSAGE,fondoGato,botones,botones[0]);

                int seleccion = -1;

                for (int i = 0; i < botones.length; i++) {
                    if(opcion.equals(botones[i])){
                        seleccion = i;
                    }
                }

                switch(seleccion){
                    case 0:
                        VerFavoritos(apikey);
                        break;
                    case 1:
                        BorrarFavorito(favoritos);
                        break;
                    default:
                        break;
                }

            }catch(IOException e){
                System.out.println(e);
            }

        }

    }

    public static void BorrarFavorito(GatosFavoritos gatoFavorito){
        try{
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/"+gatoFavorito.getId()+"")
                    .delete(null)
                    .addHeader("x-api-key", gatoFavorito.getApikey())
                    .build();
            Response response = client.newCall(request).execute();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
