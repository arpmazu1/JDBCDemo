package com.stackroute.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcBatchDemo {
    private ResultSet resultSet;
    public void getDetails()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //driver manager connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             PreparedStatement preparedStatement= connection.prepareStatement("insert into EmployeeDetails values(?,?,?,?) ");)

        {
            Scanner scanner = new Scanner(System.in);
            while(true){
                //taking input from the user
                System.out.println("Enter id");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter name");
                String name=scanner.nextLine();
                System.out.println("name: "+name);

                System.out.println("Enter age");
                int age= scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter gender");
                String gender=scanner.nextLine();
                //using preparedstatement for entering details
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setInt(3,age);
                preparedStatement.setString(4,gender);

                preparedStatement.addBatch();
                //checking if user wants to put details
                System.out.println("Want to add more records y/n");
                String answer=scanner.nextLine();
                if(answer.equals("n")){
                    break;
                }

            }
            //executing the query
            preparedStatement.executeBatch();

            System.out.println("record successfully saved");


        //handling exception
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();}
    }
}
