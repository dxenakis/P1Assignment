package main;

import io.Container;
import io.CsvFileManager;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, SQLException {
        CsvFileManager fileManager = new CsvFileManager();
        Container container = new Container();
        fileManager.importDataFromFile();
        //container.printExpiringInsuranceVehicles(3000);
        container.createUninsuredVehicleList();
        container.printUninsuredVehicleList();
        fileManager.writeExpiringInsuranceVehiclesToFile(3000, Container.getInsuranceList());
        fileManager.writeUninsuredVehiclesToFile(Container.getUninsuredVehicleList());

    }

}




