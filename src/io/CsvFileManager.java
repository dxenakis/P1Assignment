package io;

import dao.Insurance;
import dao.Owner;
import dao.Vehicle;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class CsvFileManager {
    private File inputFilePath;
    private File outputFilePath;
    private Container container;

    public CsvFileManager() {
        container = new Container();
        inputFilePath = new File("Files/input.csv");
        outputFilePath = new File("Files/output.csv");
    }

    public void importDataFromFile() {
        try (Scanner scanner = new Scanner(inputFilePath)) {
            container = new Container();
            while (scanner.hasNextLine()) {
                String[] splitLine = scanner.nextLine().split(",");
                switch (splitLine[0].toUpperCase()) {
                    case "VEHICLE":
                        Container.getVehicleList().add(new Vehicle(splitLine[1], splitLine[2]));
                        break;
                    case "OWNER":
                        Container.getOwnerList().add(new Owner(splitLine[1], splitLine[2], splitLine[3]));
                        break;
                    case "INSURANCE":
                        Owner owner = container.getOwnerByAmka(splitLine[2]);
                        Vehicle vehicle = container.getVehicleByPlateNumber(splitLine[3]);
                        System.out.println(vehicle);
                        if (owner != null && vehicle != null) {
                            Container.getInsuranceList().add(new Insurance(Integer.parseInt(splitLine[1]), owner, vehicle, LocalDate.parse(splitLine[4])));
                        }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Can't write to file " + e);
        }
    }

    public void exportDataToFile(String data) {
        try (FileWriter fileWriter = new FileWriter((outputFilePath), true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(data);
        } catch (IOException e) {
            System.err.println("Can't write to file " + e);
        }
    }
}