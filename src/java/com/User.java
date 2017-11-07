
package com;

/**
 *
 * @author Jake
 */
public class User {
    public String id;
    public String password;
    public String status; 
    public User(String _id, String _password, String _status)
    {
        id = _id;
        password = _password;
        status = _status;
    }
    
    @Override
    public String toString()
    {
        return String.format("id: %s password: %s status: %s", id, password, status);
    }
}
