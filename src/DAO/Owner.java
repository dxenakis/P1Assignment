package DAO;

public class Owner {

    private int Id;
    private String FirstName;
    private String LastName;
    private String AFM;
    private String Phone;
    private Vehicle OwnerVehicle;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAFM() {
        return AFM;
    }

    public void setAFM(String AFM) {
        this.AFM = AFM;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Vehicle getOwnerVehicle() {
        return OwnerVehicle;
    }

    public void setOwnerVehicle(Vehicle ownerVehicle) {
        OwnerVehicle = ownerVehicle;
    }
}

