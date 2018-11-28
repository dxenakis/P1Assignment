package MAIN;

import IO.CsvFileManager;

public class Main {
    public static void main(String[] args) {
        CsvFileManager fileManager = new CsvFileManager();
        fileManager.importDataFromFile();
        fileManager.addTimeStampToExportFile();
        fileManager.exportDataToFile("Exporting random String to File for testing.");
        fileManager.exportDataToFile("Appending new String");
    }
}
