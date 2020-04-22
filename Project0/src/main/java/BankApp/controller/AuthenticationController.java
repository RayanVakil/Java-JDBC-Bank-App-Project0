package BankApp.controller;

import BankApp.dao.user.AbstractUserDao;
import BankApp.model.User;

/*
    Contains the logic for the user authentication
    used when user tries logging in

 */
public class AuthenticationController {

    // variable declarations
    AbstractUserDao userDao;

    // AuthenticationController constructor
    public AuthenticationController(AbstractUserDao userDao) {
        this.userDao = userDao;
    }

    //contains logic of user login
    public User login (String username, String password){

        User user;

        // if user is a valid user then log in else return login view
        if (userDao.validUser(username, password)) {
            user = userDao.getUser(username, password);
        } else {
            user = null;
        }
        return user;
    }



    // setUserDao constructor
    public void setUserDao(AbstractUserDao userDao) {
        this.userDao = userDao;
    }
}
