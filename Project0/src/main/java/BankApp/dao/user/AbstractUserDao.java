package BankApp.dao.user;

import BankApp.model.User;

/*
    Interface for DAO
    OOP design which makes it easy to reuse code
    and achieve abstraction
 */

public interface AbstractUserDao {

    /*
        define methods in interface

     */

    //get user by username and password
    User getUser(String username, String password);

    //get user by userId
    User getUser(int userId);

    //validate user by username and password
    boolean validUser(String username, String password);

    //update user bank balance
    boolean updateAmount(int userId, float amount, boolean deposit);

    User userSignup(String username, String password, Float balance);
}
