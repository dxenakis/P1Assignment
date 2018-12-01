package main;

import dao.Insurance;
import dao.Owner;
import dao.Vehicle;
import io.Container;
import io.CsvFileManager;
import io.Jdbc;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        CsvFileManager fileManager = new CsvFileManager();
        Container container = Container.getInstance();
        fileManager.importDataFromFile();
        //container.printExpiringInsuranceVehicles(3000);
        container.createUninsuredVehicleList();
        container.printUninsuredVehicleList();
        fileManager.writeExpiringInsuranceVehiclesToFile(3000, container.getInsuranceList());
        fileManager.writeUninsuredVehiclesToFile(container.getUninsuredVehicleList());
        ArrayList<Vehicle> vehicles = new Jdbc().GetVehicles();
        ArrayList<Owner> owners = new Jdbc().GetOnwers();
        ArrayList<Insurance> insurances = new Jdbc().GetInsurances();
        for (Vehicle vehicle : vehicles) {
            System.out.println("Plate Number:" + vehicle.getPlateNumber());
            System.out.println("Owner AMKA:" + vehicle.getOwnerAmka());

        }
        for (Owner owner : owners) {
            System.out.println("Owner AMKA:" + owner.getAmka());
            System.out.println("Owner firstname:" + owner.getFirstName());
            System.out.println("Owner LastName:" + owner.getLastName());

        }
        for (Insurance insurance : insurances) {
            System.out.println("Insurance Owner  AMKA:" + insurance.getInsuranceOwner().getAmka());
            System.out.println("Owner firstname:" + insurance.getInsuranceOwner().getFirstName());
            System.out.println("Insurance Expiration Date:" + insurance.getExpireDate());
        }
    }
}




