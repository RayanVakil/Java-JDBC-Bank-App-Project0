package BankApp.utils;

import BankApp.jdbc.BankAppConnection;
import BankApp.jdbc.impl.PostgreSQLConnection;

import java.sql.Connection;

/*
    We want to make creation of jdbc connection
    independent from the logic of our app
    That's why we use a factory to create the db connection

    just takes the name of the db we want to use
    and handles creation of connection
 */
public class ConnectionFactory {

    public static BankAppConnection getConnection(String type){
        switch (type){
            case  BankAppStrings.POSTGREE_SQL:
               return new PostgreSQLConnection();
        }
        return null;
    }
}
