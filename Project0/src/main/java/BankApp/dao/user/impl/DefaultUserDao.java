package BankApp.dao.user.impl;

import BankApp.dao.AbstractDao;
import BankApp.dao.user.AbstractUserDao;
import BankApp.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
    DefaultUserDao is a sub class of AbstractDao and implements AbstractUserDao
    it adds its own behavior to all the methods stated in the interface
    These methods will be used to communicate with the database
 */

public class DefaultUserDao extends AbstractDao implements AbstractUserDao {

    /* implement getUser method to get user info from database
       it will get users username and password
     */
    @Override
    public User getUser(String username, String password) {
        User user = null;
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con == null) {
            return user;
        }
        try {
            ps = con.prepareStatement("SELECT * FROM users WHERE username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setId(rs.getInt("id"));
                user.setBalance(rs.getFloat("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, con);
        }

        return user;
    }

    //get users id from the database
    @Override
    public User getUser(int userId) {
        User user = null;
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con == null) {
            return user;
        }
        try {
            ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setId(rs.getInt("id"));
                user.setBalance(rs.getFloat("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, ps, con);
        }

        return user;
    }


    //validate user credentials
    @Override
    public boolean validUser(String username, String password) {
        User user = this.getUser(username,password);
        return user != null;
    }

    //update user balance in the database
    @Override
    public boolean updateAmount(int userId, float amount, boolean deposit) {
        boolean updated = false;
        Connection con = connect();
        PreparedStatement ps = null;
        if (con == null) {
            return updated;
        }
        try {
            ps = con.prepareStatement("update users set balance = balance " + (deposit ? "+" : "-") + " ? WHERE id = ?");
            ps.setFloat(1, amount);
            ps.setInt(2, userId);
            int updatedCnt = ps.executeUpdate();
            if (updatedCnt > 0) {
                updated = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps, con);
        }
        return updated;
    }

    /*
        sql statements to insert new user into the database
        once the user signs up
     */
    @Override
    public User userSignup(String username, String password, Float balance){

        User user = null;
        Connection con = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (con == null) {
            return user;
        }
        try {
            ps = con.prepareStatement("INSERT INTO users (username, password, balance) VALUES (?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setFloat(3,balance);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps, con);
        }

        return user;

    }
}
