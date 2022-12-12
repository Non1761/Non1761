package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class VehicleDAO {
    private final List<Vehicle> vehicles = new ArrayList<>();
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    private static String toQuotedString(String s) {
        return '"' + s + '"';
    }

    private int toQuotedInt(int s) {
        return '"' + s + '"';
    }

    public static void insertVehicleRow(Vehicle vehicle) {

        try {
            statement = ConnectionDB.connect().createStatement();
            String row = "INSERT INTO vehicle VALUES (NULL, " + toQuotedString(vehicle.getType()) + ',' + toQuotedString(vehicle.getManufacturer()) +
                    ',' + toQuotedString(vehicle.getSeries()) + ',' + toQuotedString(vehicle.getCar_number()) + ',' + toQuotedString(vehicle.getVin()) + ',' +
                    toQuotedString(vehicle.getOwner_name()) + ',' + toQuotedString(vehicle.getOwner_surname()) + ");";
            System.out.println("Vehicle insertRow: " + row);
            statement.executeUpdate(row);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int getRowCount() {
        int rowCount = -1;
        try {
            statement = ConnectionDB.connect().createStatement();
            String countQuery = "select count(car_number) from vehicle";
            ResultSet rowCountResSet = statement.executeQuery(countQuery);
            rowCountResSet.next();
            rowCount = rowCountResSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public String getAllVehicle() {

        StringBuilder result = new StringBuilder();
        for (Vehicle vehicle : vehicles) {
            result.append(vehicle.toString());
        }
        return result.toString();
    }

    public Object[][] getAllData() {
        Object[][] data = null;
        try {
            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from vehicle");
            int columnCount;
            columnCount = resultSet.getMetaData().getColumnCount();
            out.println("columnCount = " + columnCount);
            int rowCount = getRowCount();
            out.println("row count = " + rowCount);
            data = new Object[rowCount][columnCount];
            int i = 0;
            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = resultSet.getObject(j + 1);
                    out.print(data[i][j] + " ");
                }
                out.println();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Object[][] search(String ValToSearch) {
        Object[][] data = null;
        try {
            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("select * from vehicle where concat (`vehicle_id`, `type`, `manufacturer`, `series`, `car_number`, `owner_name`, `owner_surname`) like '%"+ValToSearch+"%'");
            int columnCount = resultSet.getMetaData().getColumnCount();
            System.out.println("columnCount = " + columnCount);
            int rowCount = getRowCount();

            System.out.println("row count = " + rowCount);
            data = new Object[rowCount][columnCount];
            int i = 0;
            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = resultSet.getObject(j + 1);
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void fillVehicle() {
        try {

            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from vehicle ");
            while (resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicle_id(resultSet.getInt(1));
                vehicle.setType(resultSet.getString(2));
                vehicle.setManufacturer(resultSet.getString(3));
                vehicle.setSeries(resultSet.getString(4));
                vehicle.setCar_number(resultSet.getString(5));
                vehicle.setOwner_name(resultSet.getString(6));
                vehicle.setOwner_surname(resultSet.getString(7));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
