package io;

import dao.Insurance;
import dao.Owner;
import dao.Vehicle;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CsvFileManager {

    private File filePath;
    private Scanner scanner;
    private Container container;

    public CsvFileManager() {
        container = new Container();
    }

    public void importDataFromFile() {
        filePath = new File("Files/input.csv");
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
        scanner.close();

        container.printInsuranceList();
        container.printVehicleOwnerMap();
    }

    public void exportDataToFile(String data) {
        filePath = new File("Files/output.csv");

        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(data);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("Can't write to file: " + e);
        } catch (IOException e) {
            System.err.println("Can't write to file: " + e);
        }
    }

    public void addTimeStampToExportFile() {
        filePath = new File("Files/output.csv");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(LocalDateTime.now().withSecond(0).withNano(0));
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            System.err.println("Can't write to file: " + e);
        }
    }
}