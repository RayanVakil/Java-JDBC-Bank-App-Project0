package BankApp.dao;

import BankApp.jdbc.BankAppConnection;
import BankApp.jdbc.impl.PostgreSQLConnection;
import BankApp.utils.BankAppStrings;
import BankApp.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Abstract class will make it easy to connect to database
    and also close all connections, release resources, and
    close result set
 */

public abstract class AbstractDao {

    // variable declarations
    BankAppConnection connection = ConnectionFactory.getConnection(BankAppStrings.POSTGREE_SQL);

    // connect to database
    public Connection connect(){
        return  connection.connect();
    }



    // These next methods will close connection, release resources, close result set
    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement s) {
        try {
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement st, Connection con) {
        close(st);
        close(con);
    }

    public static void close(ResultSet rs, Statement st, Connection con) {
        close(rs);
        close(st);
        close(con);
    }
}
