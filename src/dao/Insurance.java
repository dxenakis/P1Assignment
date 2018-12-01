package dao; //That is the way to import classes from other Packages

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    @Override
    public String toString() {
        return "Owner of the specific Insurance: " + insuranceOwner.getFirstName() + " " + insuranceOwner.getLastName()
                + " AMKA: " + insuranceOwner.getAmka() + ". Vehicles' Plate Number: " + insuranceVehicle.getPlateNumber()
                + ". Insurance Expiration Date: " + expireDate;
    }

    public long remainingDaysOfInsurance() {
        LocalDate dateNow = LocalDate.now();
        long remainingDays = ChronoUnit.DAYS.between(dateNow, expireDate);
        return remainingDays;
    }

    public boolean isExpiring(long days) {
        long remainingDays = remainingDaysOfInsurance();
        if(remainingDays > 0 && remainingDays <= days) {
            return true;
        }
        return false;
    }
}
