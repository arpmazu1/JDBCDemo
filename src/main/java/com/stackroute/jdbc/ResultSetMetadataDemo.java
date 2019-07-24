package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    //resultset object
    private ResultSet resultSet;
    public void getDetails()
    {
        //driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //drivermanager connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from EmployeeDetails ");)

        {
            //resultsetmetadata object
            ResultSetMetaData rsmd=resultSet.getMetaData();
            //orinting details
            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
        }
        //handling exception
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();}
    }


}
