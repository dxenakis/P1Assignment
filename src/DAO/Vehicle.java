package DAO;

public class Vehicle implements Comparable {

    //private int id; Is the ID really needed? Plate Number is a unique String by itself.
    private String manufacturer;
    private String model;
    private String plateNumber;
    private int type;           // Should be the Type of the Vehicle. For Example 1 for Car , 2 for Motorbike etc.

   /* public int getId() {
        return id;
    }*/

    /*public void setId(int id) {
        this.id = id;
    }*/

    public Vehicle(String manufacturer, String model, String plateNumber, int type) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {
        return getPlateNumber().toUpperCase().compareTo(((Vehicle)o).getPlateNumber().toUpperCase());
    }
}
