package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {
    //object of resultset
    private ResultSet resultSet;
    public void getDetails()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //drivermanager connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");)


        {
            //DatabaseMetaData object
            DatabaseMetaData dbmd=connection.getMetaData();
            //displaying the details
            System.out.println("Driver Name: "+dbmd.getDriverName());
            System.out.println("Driver Version: "+dbmd.getDriverVersion());
            System.out.println("UserName: "+dbmd.getUserName());
            System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();}
    }

}
