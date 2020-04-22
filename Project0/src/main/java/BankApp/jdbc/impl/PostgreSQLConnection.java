package BankApp.jdbc.impl;


import BankApp.jdbc.BankAppConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    Class contains methods and variables needed to establish
    connection with the PostgreSQL database I will be using
 */

public class PostgreSQLConnection implements BankAppConnection {

    // define database credentials and variables
    private static String url =  System.getenv("jdbcUrl") ;;

    private static String user =  System.getenv("dbUser");

    private static String passwd =  System.getenv("dbPassword");

    private static Connection connect;


    // get instance of connection
    public static Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }


    /*
        connection to database
        anytime you want to connect to the database, you can using this method
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
