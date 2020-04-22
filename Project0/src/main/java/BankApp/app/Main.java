package BankApp.app;

import BankApp.utils.AppLauncher;
import BankApp.utils.BankAppStrings;

/*
    PROJECT 0 (BANK APP) BY RAYAN VAKIL

    WELCOME TO THIS SIMPLE BANK APP CONSOLE PROGRAM
    WHICH SHOWCASES JAVA JDBC, OOP DESIGN, AS WELL
    AS UNIT TESTING USING MOCKITO
 */

/*
    This is the Main class which runs the whole program
 */
public class Main {

    //main method
    public static void main(String[] args) {

        //launch app starting with the first view
        AppLauncher.lunch(BankAppStrings.CONSOLE_VIEW);
    }
}