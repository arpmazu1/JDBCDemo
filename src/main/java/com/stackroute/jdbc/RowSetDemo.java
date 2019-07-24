package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;


public class RowSetDemo{


    public void getDetails() {
        //driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //jdbc rowser
        try (JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();) {

            rowSet.setUrl("jdbc:mysql://localhost:3306/employee");

            rowSet.setUsername("root");
            rowSet.setPassword("Root@123");

            rowSet.setCommand("select * from EmployeeDetails");
            rowSet.execute();
            //displaying details
            while (rowSet.next()) {
                System.out.println("Id: " + rowSet.getInt(1) + " Name: " + rowSet.getString(2)+
                        " Age: " + rowSet.getString(3)+" Gender: " + rowSet.getString(4));
            }


        }
        //handling exception
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
