package BankApp.view.console;

import BankApp.model.User;
import BankApp.view.BankAppView;

import java.text.DecimalFormat;
import java.util.Scanner;

/*

  Class for main menu functionality after user
  logs in successfully

 */

public class MainMenuView extends BankAppView {

    private User currentUser;

    //declare variables
    Scanner in = new Scanner(System.in);
    int userChoice;
    boolean quit = false;
    DecimalFormat df = new DecimalFormat("###.##");
    float balance = 0f;
    float amount = 0f;

    //constructor
    public MainMenuView(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public void lunch() {
        //do while will run as long as user does not press 0 to quit
        do {

            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.print("Your choice, 0 to quit: ");
            userChoice = in.nextInt();

            switch (userChoice) {
                case 1:
                    // deposit money
                    depositMoney();
                    break;
                case 2:
                    // withdraw money
                    withdrawMoney();
                    break;
                case 3:
                    // check balance
                    checkBalance();
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

    //get balance of account
    private void checkBalance() {
        balance = userController.getBalance(currentUser.getId());
        System.out.println("\n" + "Your balance: $" + df.format(balance));
    }

    //withdraw money from account
    private void withdrawMoney() {
        System.out.print("\n" + "Amount to withdraw: ");
        amount = in.nextFloat();

        if (userController.withdraw(currentUser.getId(), amount, balance)) {
            balance -= amount;
            System.out.println("\n" + "$" + amount + " has been withdrawn.");
        } else {
            System.out.println("\n" + "Withdrawal can't be completed.");
        }
    }

    //deposit money into the account
    private void depositMoney() {
        System.out.print("\n" + "Amount to deposit: ");
        amount = in.nextFloat();

        if (userController.deposit(currentUser.getId(), amount)) {
            balance += amount;
            System.out.println("\n" + "$" + amount + " has been deposited.");
        } else {
            System.out.println("\n" + "Can't deposit non positive amount.");
        }
    }


}