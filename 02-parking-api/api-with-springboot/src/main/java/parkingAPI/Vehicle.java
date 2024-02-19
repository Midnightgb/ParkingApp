package parkingAPI;


public class Vehicle {
    String plate;
    String name_owner;
    String category;

    public Vehicle(String plate, String name_owner, String category) {
        this.plate = plate;
        this.name_owner = name_owner;
        this.category = category;
    }

    public String getPlate() {
        return plate;
    }

    public String getName_owner() {
        return name_owner;
    }

    public String getCategory() {
        return category;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setName_owner(String name_owner) {
        this.name_owner = name_owner;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
}
