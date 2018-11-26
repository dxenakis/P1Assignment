package DAO; //That is the way to import classes from other Packages

import java.time.LocalDate;

public class Insurance {

    private int id;
    private Owner insuranceOwner;
    private Vehicle insuranceVehicle;
    private LocalDate expireDate;

    public Insurance(int id, Owner insuranceOwner, Vehicle insuranceVehicle, LocalDate expireDate) {
        this.id = id;
        this.insuranceOwner = insuranceOwner;
        this.insuranceVehicle = insuranceVehicle;
        this.expireDate = expireDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Owner getInsuranceOwner() {
        return insuranceOwner;
    }

    public void setInsuranceOwner(Owner insuranceOwner) {
        this.insuranceOwner = insuranceOwner;
    }

    public Vehicle getInsuranceVehicle() {
        return insuranceVehicle;
    }

    public void setInsuranceVehicle(Vehicle insuranceVehicle) {
        this.insuranceVehicle = insuranceVehicle;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
}
