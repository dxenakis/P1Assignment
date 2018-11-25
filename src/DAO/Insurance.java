package DAO; //That is the way to import classes from other Packages

import java.util.Date;

public class Insurance {

    private int Id;
    private Date ExpireDate;
    private Owner InsuranceOwner;
    private Vehicle InsuranceVehicle;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date expireDate) {
        ExpireDate = expireDate;
    }

    public Owner getInsuranceOwner() {
        return InsuranceOwner;
    }

    public void setInsuranceOwner(Owner insuranceOwner) {
        InsuranceOwner = insuranceOwner;
    }

    public Vehicle getInsuranceVehicle() {
        return InsuranceVehicle;
    }

    public void setInsuranceVehicle(Vehicle insuranceVehicle) {
        InsuranceVehicle = insuranceVehicle;
    }
}
