
package parkingAPI;


public class Parking {
     int id;
     String name;
     String address;
     int camioneta;
     int camion;
     int carro;
     int moto;
     String status;

    public Parking(int id, String name, String address, int camioneta, int camion, int carro, int moto, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.camioneta = camioneta;
        this.camion = camion;
        this.carro = carro;
        this.moto = moto;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public int getCamioneta() {
        return camioneta;
    }

    public int getCamion() {
        return camion;
    }

    public int getCarro() {
        return carro;
    }

    public int getMoto() {
        return moto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCamioneta(int camioneta) {
        this.camioneta = camioneta;
    }

    public void setCamion(int camion) {
        this.camion = camion;
    }

    public void setCarro(int carro) {
        this.carro = carro;
    }

    public void setMoto(int moto) {
        this.moto = moto;
    }
     
     
}
