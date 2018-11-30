package io;

import dao.Insurance;
import dao.Owner;
import dao.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private static List<Vehicle> vehicleList;
    private static List<Owner> ownerList;
    private static List<Insurance> insuranceList;

    public Container() {
        vehicleList = new ArrayList<>();
        ownerList = new ArrayList<>();
        insuranceList = new ArrayList<>();
    }

    public static List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public static List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public static List<Owner> getOwnerList() {
        return ownerList;
    }

    public void printVehicleList() {
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }

    public void printOwnerList() {
        for (Owner owner : ownerList) {
            System.out.println(owner);
        }
    }

    public void printInsuranceList() {
        for (Insurance insurance : insuranceList) {
            System.out.println(insurance);
        }
    }

    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getPlateNumber().toUpperCase().equals(plateNumber.toUpperCase())) {
                return vehicle;
            }
        }
        return null;
    }

    public Owner getOwnerByAmka(String amka) {
        for (Owner owner : ownerList) {
            if (owner.getAmka().toUpperCase().equals(amka.toUpperCase())) {
                return owner;
            }
        }
        return null;
    }
}
