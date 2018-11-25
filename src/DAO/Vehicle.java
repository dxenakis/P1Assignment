package DAO;

public class Vehicle {

    private int Id;
    private String Manufacturer;
    private String Model;
    private String PlateNumber;
    private int Type;           // Should be the Type of the Vehicle. For Example 1 for Car , 2 for Motorbike etc.

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }
}
