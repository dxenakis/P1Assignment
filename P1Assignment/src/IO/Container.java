package io;

import dao.Insurance;
import dao.Owner;
import dao.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {

    private static Map<Vehicle, Owner> vehicleOwnerMap;
    private static List<Insurance> insuranceList;

    public Container() {
        vehicleOwnerMap = new HashMap<>();
        insuranceList = new ArrayList<>();
    }

    public static Map<Vehicle, Owner> getVehicleOwnerMap() {
        return vehicleOwnerMap;
    }

    public static List<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public Owner getOwnerByAmka(String amka) {
        for (Map.Entry<Vehicle, Owner> entry : vehicleOwnerMap.entrySet()) {
            Owner value = entry.getValue();
            if (value.getAmka().equals(amka.toUpperCase())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        for (Map.Entry<Vehicle, Owner> entry : vehicleOwnerMap.entrySet()) {
            Vehicle key = entry.getKey();
            if (key.getPlateNumber().equals(plateNumber.toUpperCase())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Vehicle getVehicleByOwnerAmka(String amka) {
        for (Map.Entry<Vehicle, Owner> entry : vehicleOwnerMap.entrySet()) {
            Vehicle key = entry.getKey();
            if (key.getOwnerAmka().equals(amka.toUpperCase())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void printInsuranceList() {
        for (Insurance insurance : insuranceList) {
            System.out.println(insurance);
        }
    }

    public void printVehicleOwnerMap() {
        for (Map.Entry<Vehicle, Owner> entry : vehicleOwnerMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

}
