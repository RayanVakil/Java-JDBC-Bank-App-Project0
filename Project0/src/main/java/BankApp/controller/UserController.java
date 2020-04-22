package BankApp.controller;

import BankApp.dao.user.AbstractUserDao;
import BankApp.model.User;
import org.codehaus.plexus.util.StringUtils;


/*
    UserController class will control all user functions
    available for the user in the app
    This class contains all the logic for the bank
    functionality

 */

public class UserController {

    // variable declarations
    private AbstractUserDao userDao;

    // UserController constructor
    public UserController(AbstractUserDao userDao) {
        this.userDao = userDao;
    }

    // method to handle depositing money into the users account
    public boolean deposit(int userId, float amount) {
        //if amount is less than or equal to 0 return to menu otherwise add money
        if (amount <= 0)
            return false;
        else {
            userDao.updateAmount(userId, amount, true);
            return true;
        }
    }

    // method to handle withdrawing money from user account
    public boolean withdraw(int userId, float amount , float balance){
        // if amount is negative or 0 no money will be deposited else money will be deposited
        if (amount <= 0 || amount > balance)
           return false;
        else {
            userDao.updateAmount(userId, amount, false);
            return true;
        }
    }

    // method to retrieve user bank balance
    public float  getBalance(int userId) {
        User user = userDao.getUser(userId);
        if(user ==  null){
            return 0f;
        }
       return  user.getBalance();
    }


    //This method will control the user sign up logic
    public User signUp(String username, String password, Float balance){


        User user = new User();
        /*
            if user already exits or input is empty quit
            else create new user
         */
        if(userDao.validUser(username, password)){
            System.out.println("User already exists");
        }else if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            System.out.println("Invalid username or password");
        }
        else {
            userDao.userSignup(username, password, balance);
        }
            return user;
    }


    //userDao setter
    public void setUserDao(AbstractUserDao userDao) {
        this.userDao = userDao;
    }
}
