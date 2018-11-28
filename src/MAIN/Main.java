package MAIN;
import java.io.FileNotFoundException;

import IO.CsvFileManager;

public class Main {
<<<<<<< HEAD
    public static void main(String[] args) throws FileNotFoundException {



        }

=======
    public static void main(String[] args) {
        CsvFileManager fileManager = new CsvFileManager();
        fileManager.importDataFromFile();
        fileManager.addTimeStampToExportFile();
        fileManager.exportDataToFile("Exporting random String to File for testing.");
        fileManager.exportDataToFile("Appending new String");
>>>>>>> 6fc44df2715bad0290cf038d31e74a3e30ab619e
    }

