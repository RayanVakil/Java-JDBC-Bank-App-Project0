package BankApp.view;

import BankApp.controller.AuthenticationController;
import BankApp.controller.UserController;
import BankApp.dao.user.impl.DefaultUserDao;

/*
    Abstract class to invoke controllers and create launch method
 */
public abstract class BankAppView {


    protected AuthenticationController authenticationController = new AuthenticationController(new DefaultUserDao());
    protected UserController userController = new UserController(new DefaultUserDao());


    public abstract void lunch ();
}
