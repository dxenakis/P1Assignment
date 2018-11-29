package DAO;

public class Vehicle implements Comparable {

    private String ownerAmka;
    private String plateNumber;

    public Vehicle(String ownerAmka, String plateNumber) {
        this.ownerAmka = ownerAmka;
        this.plateNumber = plateNumber;
    }

    public String getOwnerAmka() {
        return ownerAmka;
    }

    public void setOwnerAmka(String ownerAmka) {
        this.ownerAmka = ownerAmka;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Plate Number: " + plateNumber + " Owner Amka: " + ownerAmka;
    }

    @Override
    public int compareTo(Object o) {
        return getPlateNumber().toUpperCase().compareTo(((Vehicle) o).getPlateNumber().toUpperCase());
    }
}
