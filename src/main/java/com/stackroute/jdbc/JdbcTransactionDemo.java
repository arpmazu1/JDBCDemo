package com.stackroute.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransactionDemo {
    private ResultSet resultSet;

    public void getDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //driver manager connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");
             PreparedStatement preparedStatement = connection.prepareStatement("insert into EmployeeDetails values(?,?,?,?) ");) {

            connection.setAutoCommit(false);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                //user input
                System.out.println("Enter id");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter name");
                String name = scanner.nextLine();
                System.out.println("name: " + name);

                System.out.println("Enter age");
                int age = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter gender");
                String gender = scanner.nextLine();
                //using preparedstatement for entering user input
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, age);
                preparedStatement.setString(4, gender);

                preparedStatement.executeUpdate();
                //commit or rollback input from user
                System.out.println("commit/rollback");
                String answer=scanner.nextLine();
                if(answer.equals("commit")){
                    connection.commit();
                }
                if(answer.equals("rollback")){
                    connection.rollback();
                }

                //checking if user wants to enter more values or not
                System.out.println("Want to add more records y/n");
                String ans = scanner.nextLine();
                if (ans.equals("n")) {
                    break;
                }

            }
            //committing the connection
            connection.commit();

            System.out.println("record successfully saved");


        }
        //handling the exception
        catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
