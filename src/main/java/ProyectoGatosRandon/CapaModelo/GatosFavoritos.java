package ProyectoGatosRandon.CapaModelo;

import ProyectoGatosRandon.CapaVista.Imagex;

public class GatosFavoritos {

    String id;
    String image_id;
    String apikey = "live_vmEy0KXJwkfhMX8fRRGzqqfTrcqAHcf7IgN4D2OAtzC9FsA7D11wgTtJEbKLyyTk";
    Imagex image;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getImage_id() {
        return image_id;
    }
    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }
    public String getApikey() {
        return apikey;
    }
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
    public Imagex getImage() {
        return image;
    }
    public void setImage(Imagex image) {
        this.image = image;
    }
}
