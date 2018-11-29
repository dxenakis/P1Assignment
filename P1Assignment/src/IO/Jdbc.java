package IO;

import DAO.Insurance;
import DAO.Owner;

import java.sql.*;
import java.util.ArrayList;

public class Jdbc {
    private static Jdbc instance;
    private Connection conn;

    private Connection GetConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "qwerty!2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;  // comments
    }




    public ArrayList<Insurance> GetInsurances() throws SQLException {
        Connection connection = GetConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "SELECT insuranceID, ownerAMKA, plateNumber, expirationDate" +
                    " FROM db.insurances";


            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer insuranceID = rs.getInt("insuranceID");
                String OnwerAMKA = rs.getString("ownerAMKA");
                String PlateNumber = rs.getString("plateNumber");
                Date expirationDate = rs.getDate("expirationDate");

                System.out.println("\t" + insuranceID +
                        "\t" + PlateNumber + "\t" + OnwerAMKA +
                        "\t" + expirationDate);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stmt.close();
        }

        return null;
    }

    public ArrayList<Owner> GetOnwers() throws SQLException {
        Connection connection = GetConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "SELECT AMKA, firstName, lastName\n" +
                    "FROM db.owners;";


            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String AMKA = rs.getString("AMKA");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");

                System.out.println("\t" + AMKA +
                        "\t" + firstName + "\t" + lastName);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stmt.close();
        }

        return null;
    }

    public ArrayList<Owner> GetVehicles() throws SQLException {
        Connection connection = GetConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "SELECT plateNumber, ownerAMKA\n" +
                    "FROM db.vehicles";


            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String plateNumber = rs.getString("plateNumber");
                String ownerAMKA = rs.getString("ownerAMKA");

                System.out.println("\t" + plateNumber +
                        "\t" + ownerAMKA);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stmt.close();
        }

        return null;
    }


}