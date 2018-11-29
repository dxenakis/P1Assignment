package DAO;

public class Owner {

    private String amka;
    private String firstName;
    private String lastName;

    public Owner(String amka, String firstName, String lastName) {
        this.amka = amka;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Owner First Name: " + firstName + " Owner Last Name: " + lastName + " AMKA: " + amka;
    }
}

