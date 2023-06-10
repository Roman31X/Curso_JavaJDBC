package Manejo_JDBC.domin;

public class Persona {
    //atributos para sentencia en MYSQL
    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    //CONTRUCTOR BACIO
    public Persona() {
    }
    //CONTRUCTOR CONPARAMETROS
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }
    //CONTRUCTOR PARA REGISTRAR
    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    //CONTRUCTOR PARA MODIFICACION DE DATOS
    public Persona(int idPersona, String nombre, String apellido, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    //METODO GETTER Y SETTER
    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //METODO TOSTRING
    @Override
    public String toString() {
        return "Persona : " + "ID PERSONA [" + idPersona + "] NOMBRE [" + nombre + "] APELLIDO [" + apellido + "] EMAIL [" + email + "] TELEFONO [" + telefono + "]";
    }
    
    

    
    
    
    
}
