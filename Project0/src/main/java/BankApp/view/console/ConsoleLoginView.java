package BankApp.view.console;

import BankApp.model.User;
import BankApp.view.BankAppView;

import java.util.Scanner;

/*
    When you first start the app and have to login
    this class sets up the view you will have
 */
public class ConsoleLoginView extends BankAppView {

    public static User user;

    /*
        This is the first screen that will show up
        when the app is launched
     */
    @Override
    public void lunch() {

        //variable declarations
        String password;
        String username;
        int choice;
        boolean quit = false;


        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Welcome to Simp Bank!");
            System.out.println("-------------------\n"+"1. Sign up for a new account!");
            System.out.println("2. Existing user login");
            System.out.print("Your choice, 0 to quit: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    //Sign user up for an account
                    userSignup();
                    break;

                case 2:
                    // existing user login in view
                    userLogIn();
                    break;

                case 0:
                    //quit program
                    quit = true;
                    break;

                default:
                    System.out.println("\n" + "Wrong choice.");
                    break;
            }
            System.out.println();
        } while (!quit);
        System.out.println("\n" + "Thanks for using our bank! \n \n");
    }


    /*
        if user exists he will login in through this prompt
     */
    private void userLogIn(){

        //variable declarations
        String password;
        String username;
        int userChoice;
        boolean login = true;
        Scanner sc = new Scanner(System.in);


       // while loop which will run the login menu
        while (login) {
            //user input

            System.out.println(" ------------------ \n" + "Username: \n");
            username = sc.nextLine();

            System.out.println("Password: \n");
            password = sc.nextLine();

            user = authenticationController.login(username,password);
           // if user and pass is valid then login else go back to menu
            if (user != null) {
                login = false;
                System.out.println("\n" +"You have logged in. \n");
                new MainMenuView(user).lunch();
            }
            else {
                System.out.println("\n" +"Incorrect username or password \n");
                login = false;

            }
       }

    }

    /*
        If user chooses to sign up, this prompt will be displayed
     */
    private void userSignup(){

        //variables
        String username;
        String password;
        float balance;
        boolean signUp = true;
        Scanner sc = new Scanner(System.in);


        /*
            while inputs are good sign up user
            else refer to signup controller logic
         */
        while(signUp) {
            System.out.println(" ------------------ \n" + "Create username \n");
            username = sc.nextLine();

            System.out.println("Create password \n");
            password = sc.nextLine();

            System.out.println("Add balance \n");
            balance = sc.nextFloat();

            user = userController.signUp(username,password,balance);


            if (user == null) {
                System.out.println("\n" +"Please try again \n");
            } else {
                signUp = false;

            }

        }

    }
}
