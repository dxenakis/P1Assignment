package io;

import dao.Insurance;
import dao.Owner;
import dao.Vehicle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Container {

    private List<Vehicle> vehicleList;
    private List<Owner> ownerList;
    private List<Insurance> insuranceList;
    private List<Vehicle> uninsuredVehicleList;
    private static Container instance;

    private Container() {
        vehicleList = new ArrayList<>();
        ownerList = new ArrayList<>();
        insuranceList = new ArrayList<>();
        uninsuredVehicleList = new ArrayList<>();
    }

    public static Container getInstance() {
        if(instance == null)
        {
            instance = new Container();
        }
        return instance;
    }

    public List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public List<Owner> getOwnerList() {
        return ownerList;
    }

    public List<Vehicle> getUninsuredVehicleList() {
        return uninsuredVehicleList;
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

    public Insurance getInsuranceByPlate(String plateNumber) {
        for(Insurance insurance : insuranceList) {
            if(insurance.getInsuranceVehicle().getPlateNumber().toUpperCase().equals(plateNumber.toUpperCase())) {
                return insurance;
            }
        }
        return null;
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

    public void createUninsuredVehicleList() {
        for(Insurance insurance : insuranceList) {
            if(insurance.remainingDaysOfInsurance() <= 0) {
                uninsuredVehicleList.add(insurance.getInsuranceVehicle());
            }
        }
        Collections.sort(uninsuredVehicleList);
    }

    public void printExpiringInsuranceVehicles(long days) {
        System.out.println("Vehicles that their insurance is going to expire within " + days + " days:");
        System.out.println("---------------------------------------------------------------------------");
        long remainingDays;
        for(Insurance insurance : insuranceList) {
            if(insurance.isExpiring(days)) {
                remainingDays = insurance.remainingDaysOfInsurance();
                System.out.println(insurance.getInsuranceVehicle() + "(EXPIRES IN : " + remainingDays + " DAYS)");
            }
        }
    }

    public void printUninsuredVehicleList() {
        System.out.println("Vehicles that their insurance has EXPIRED");
        System.out.println("---------------------------------------------------------------------------");
        for(Vehicle vehicle : uninsuredVehicleList) {
            System.out.println(vehicle);
        }
    }



}
