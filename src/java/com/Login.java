package com;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leoed
 */
public class Login {
    public static User attemptLogin(String userName, String password, DBBean bean){
        ArrayList<User> users = new ArrayList<>();
        try {
            users = bean.getUsers();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(User u : users){
            if(u.id.equalsIgnoreCase(userName))
                if(u.password.equals(password))
                    return u;
        }
        return null;
    }
}
