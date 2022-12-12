package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class ServiceDAO {

    private final List<Service> services = new ArrayList<>();
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    private static String toQuotedString(String s) {
        return '"' + s + '"';
    }

    private int toQuotedInt(int s) {
        return '"' + s + '"';
    }

    public static void insertServiceRow(Service service) {

        try {
            statement = ConnectionDB.connect().createStatement();
            String row = "INSERT INTO service VALUES (NULL, " + toQuotedString(service.getVin()) + ',' +  toQuotedString(service.getService_type())  +
                    ',' + toQuotedString(service.getServiceDateStringImpl())  + ");";
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
            String countQuery = "select count(vin) from service";
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

    public String getAllService() {

        StringBuilder result = new StringBuilder();
        for (Service service : services) {
            result.append(service.toString());
        }
        return result.toString();
    }

    public Object[][] getAllData() {
        Object[][] data = null;
        try {
            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from service");
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

    public void fillService() {
        try {

            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from service ");
            while (resultSet.next()) {
                Service service = new Service();
                service.setService_id(resultSet.getInt(1));
                service.setVin(resultSet.getString(2));
                service.setService_type(resultSet.getString(3));
                service.setService_date(resultSet.getDate(4));

                services.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object[][] search(String ValToSearch) {
        Object[][] data = null;
        try {
            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("select * from service where concat (`service_id`, `service_type`, `service_date`, `vin`) like '%"+ValToSearch+"%'");
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
}
