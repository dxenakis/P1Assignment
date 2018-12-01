package io;

import dao.Insurance;
import dao.Owner;
import dao.Vehicle;

import java.sql.*;
import java.time.LocalDate;
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
        return conn;
    }




    public ArrayList<Insurance> GetInsurances() throws SQLException {
        ArrayList<Insurance> insurances = new ArrayList<>();
        Connection connection = GetConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "SELECT insuranceID,b.firstName,b.lastName, a.ownerAMKA, a.plateNumber, expirationDate\n" +
                    "FROM db.insurances A left join Owners B on A.ownerAMKA=B.AMKA \n" +
                    "left join vehicles c on a.ownerAMKA = C.ownerAMKA";


            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Owner owner = new Owner(rs.getString("ownerAMKA"),
                        rs.getString("firstName"),rs.getString("lastName"));
                Vehicle vehicle = new Vehicle(rs.getString("ownerAMKA"),rs.getString("plateNumber"));
                String Date = rs.getString("expirationDate");
                LocalDate date = LocalDate.parse(Date);
                Insurance insurance = new Insurance(rs.getInt("insuranceID"),owner,vehicle, date);
                insurances.add(insurance);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stmt.close();
        }

        return insurances;
    }

    public ArrayList<Owner> GetOnwers() throws SQLException {
        ArrayList<Owner> owners = new ArrayList<>();
        Connection connection = GetConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "SELECT AMKA, firstName, lastName\n" +
                    "FROM db.owners;";


            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Owner owner = new Owner(rs.getString("AMKA"),
                        rs.getString("firstName"),
                        rs.getString("lastName"));
                owners.add(owner);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stmt.close();
        }

        return owners;
    }

    public ArrayList<Vehicle> GetVehicles() throws SQLException {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
     //   Vehicle vehicle = null;
        Connection connection = GetConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "SELECT plateNumber, ownerAMKA\n" +
                    "FROM db.vehicles";


            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Vehicle vehicle = new Vehicle(rs.getString("plateNumber"),
                        rs.getString("ownerAMKA"));
                vehicles.add(vehicle);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            stmt.close();
        }

        return vehicles;
    }


}