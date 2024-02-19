
package parkingAPI;


public class User {
    private int id;
    private String nombre;
    private String correo;
    private String rol;
    private String status;
    private String parking;
    private String password;

    public User(int id, String nombre, String correo, String rol, String status, String parking, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.status = status;
        this.parking = parking;
        this.password = password;
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
        return status;
    }

    public String getParking() {
        return parking;
    }

    public String getPassword() {
        return password;
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

    public void setEstado(String status) {
        this.status = status;
    }
    
    public void setParking(String parking) {
        this.parking = parking;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


