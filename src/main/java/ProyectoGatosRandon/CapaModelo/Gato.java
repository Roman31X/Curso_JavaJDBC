package ProyectoGatosRandon.CapaModelo;

public class Gato {

    String id;
    String url;
    String apiKey = "live_vmEy0KXJwkfhMX8fRRGzqqfTrcqAHcf7IgN4D2OAtzC9FsA7D11wgTtJEbKLyyTk";
    String imagen;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
