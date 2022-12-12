package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class UserDAO {
    private final List<User> users = new ArrayList<>();
    private static Statement statement = null;
    private ResultSet resultSet = null;

    private static String toQuotedString(String s) {
        return '"' + s + '"';
    }
    private int toQuotedInt(int s) {
        return '"' + s + '"';
    }

    public static void insertUserRow(User user) {

        try {
            statement = ConnectionDB.connect().createStatement();
            String row1 = "INSERT INTO userRegistration VALUES (NULL, " + toQuotedString(user.getFirst_name()) + ',' + toQuotedString(user.getLast_name()) +
                    ',' + toQuotedString(user.getBirthdateStringImpl()) + ',' + toQuotedString(user.getMail()) +
                    ',' + toQuotedString(user.getPassword()) +");";
            String row2 = "INSERT INTO userLogin VALUES (NULL, " + toQuotedString(user.getMail()) +',' + toQuotedString(user.getPassword()) +");";
            System.out.println("User insertRow: " + row1);
            System.out.println("User insertRow: " + row2);
            statement.executeUpdate(row1);
            statement.executeUpdate(row2);
//            statement.executeUpdate(courses);
//            statement.executeUpdate(grades);

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
            String countQuery = "select count(first_name) from userRegistration";
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

    public String getAllUser(){

        StringBuilder result = new StringBuilder();
        for (User user : users) {
            result.append(user.toString());
        }
        return result.toString();
    }

    public Object[][] getAllData() {
        Object[][] data = null;
        try {
            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from userRegistration");
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

    public void fillUser() {
        try {

            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from userRegistration ");
            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getInt(1));
                user.setFirst_name(resultSet.getString(2));
                user.setLast_name(resultSet.getString(3));
                user.setBirthdate(resultSet.getDate(4));
                user.setMail(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object[][] searchVin(String vin) {
        Object[][] data = null;
        try {
            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("select * from vehicle_service where vin = '" + vin +"'");
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
    public Object[][] getAllSameVin() {
        Object[][] data = null;
        try {
            statement = ConnectionDB.connect().createStatement();
            resultSet = statement.executeQuery("Select * from vehicle_service");
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
            resultSet = statement.executeQuery("select * from userregistration where concat (`user_id`, `first_name`, `last_name`, `birthdate`, `e_mail`) like '%"+ValToSearch+"%'");
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

    public void deleteById(int id) {
        try {
            statement = ConnectionDB.connect().createStatement();
            statement.executeUpdate("delete from userregistration where user_id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
