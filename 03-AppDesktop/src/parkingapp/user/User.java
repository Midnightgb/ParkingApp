
package parkingapp.user;


public class User {
    private int id;
    private String nombre;
    private String correo;
    private String rol;
    private String estado;
    private String parking;

    public User(int id, String nombre, String correo, String rol, String estado, String parking) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.estado = estado;
        this.parking = parking;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public String getEstado() {
        return estado;
    }

    public String getParking() {
        return parking;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setParking(String parking) {
        this.parking = parking;
    }
}


