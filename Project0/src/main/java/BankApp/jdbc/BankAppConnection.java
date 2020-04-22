package BankApp.jdbc;

import java.sql.Connection;

/*
    Create interface for app connection to database
    This interface can easily be used by classes to connect
    to the database
    It makes it easier to switch to any database
 */
public interface BankAppConnection {

    Connection connect();
}
