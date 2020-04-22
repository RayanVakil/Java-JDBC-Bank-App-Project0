package BankApp.model;

/****************************************
 *
 * User class to create the user who
 * will be retrieved from the database
 * This class will allow me to interact
 * and manipulate the user in my program
 *
 * contains all getters and setters
 ****************************************/

public class User {

    //variable declarations
    private int id;
    private float balance;
    private String username;

    //constructor

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
