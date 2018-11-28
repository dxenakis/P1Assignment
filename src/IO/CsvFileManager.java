package IO;

import DAO.Insurance;
import DAO.Owner;
import DAO.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class CsvFileManager {

    private File filePath;
    private Scanner scanner;
    private Container container;

    public CsvFileManager() {
        container = new Container();
        filePath = new File("Files/input.csv");
    }

    public void importDataFromFile() {
        try {
            scanner = new Scanner(filePath);
            container = new Container();
            int insuranceID = 0;
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(",");
                switch (splitLine[0].toUpperCase()) {
                    case "VEHICLE":
                        Container.getVehicleOwnerMap().put(new Vehicle(splitLine[1], splitLine[2]), null);
                        break;
                    case "OWNER":
                        Owner owner = new Owner(splitLine[1], splitLine[2], splitLine[3]);
                        Container.getVehicleOwnerMap().put((container.getVehicleByOwnerAmka(owner.getAmka())), owner);
                        break;
                    case "INSURANCE":
                        insuranceID++;
                        owner = container.getOwnerByAmka(splitLine[1]);
                        Vehicle vehicle = container.getVehicleByPlateNumber(splitLine[2]);
                        if (owner != null && vehicle != null) {
                            Container.getInsuranceList().add(new Insurance(insuranceID, owner, vehicle, LocalDate.parse(splitLine[3])));
                        }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can't parse file: " + e);
        }

        container.printInsuranceList();
        container.printVehicleOwnerMap();

    }
}
