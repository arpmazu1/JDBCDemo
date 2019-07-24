package com.stackroute.jdbc;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //print the details
        SimpleJdbcDemo simpleJdbcDemo = new SimpleJdbcDemo();
        System.out.println("Print ResultSet : ");

        //print details in reverse order
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println("Print ResultSet in reverse order");
        simpleJdbcDemo.getEmployeeDetailsInReverse();

        //print details fron second row in reverse order
        System.out.println("ResultSet to second row and print in reverse order : ");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();

        //displaying details by name and gender
        System.out.println("Displaying details by name and gender : ");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Arpita","Female");

        //using resultmetadata
        System.out.println("ResultMetaData");
        ResultSetMetadataDemo resultSetMetadataDemo = new ResultSetMetadataDemo();
        resultSetMetadataDemo.getDetails();

        //using databasemetadata
        System.out.println("DatabaseMetadata : ");
        DatabaseMetadataDemo databaseMetadataDemo = new DatabaseMetadataDemo();
        databaseMetadataDemo.getDetails();

        //using jdbcbatch
        System.out.println("Batch Processing : ");
        JdbcBatchDemo jdbcBatchDemo = new JdbcBatchDemo();
        jdbcBatchDemo.getDetails();
        SimpleJdbcDemo simpleJdbcDemo2 = new SimpleJdbcDemo();
        simpleJdbcDemo2.getEmployeeDetails();

        //using jdbctransaction
        System.out.println("JDBC Transaction : ");
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        jdbcTransactionDemo.getDetails();
        SimpleJdbcDemo simpleJdbcDemo1 = new SimpleJdbcDemo();
        simpleJdbcDemo1.getEmployeeDetails();

        //using rowset
        System.out.println("RowSet : ");
        RowSetDemo rowSetDemo = new RowSetDemo();
        rowSetDemo.getDetails();

    }
}
