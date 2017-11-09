
package com;

import java.sql.*;
import java.util.ArrayList;

public class DBBean 
{
    Connection connection = null;
    
    public DBBean(String db, String username, String password) throws SQLException 
    {
        try 
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/"+db.trim(), username, password);
        }
        catch(Exception e){ System.out.println("Could not connect to database. " + e); }
    } 
    
    ResultSet selectAll(String table)
    {
        Statement statement;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(String.format("SELECT * FROM %s", table));

            //statement.close();
        } catch(Exception e){ System.out.println("Failed " + e); }
        return rs;
    }
    
    public ArrayList<User> getUsers() throws SQLException
    {
        ArrayList<User> users = new ArrayList<>();
        ResultSet rs = selectAll("USERS");
        while(rs.next())
            users.add(new User(rs.getString("id"), rs.getString("password"), rs.getString("status")));
        return users;
    }
    
    public ArrayList<Payment> getPayments() throws SQLException
    {
        ArrayList<Payment> payments = new ArrayList<>();
        ResultSet rs = selectAll("PAYMENTS");
        while(rs.next())
            payments.add(new Payment(rs.getInt("id"), rs.getString("mem_id"), rs.getString("type_of_payment"), rs.getDouble("amount"), rs.getDate("date"), rs.getTime("time")));
        return payments;
    }
    
    public ArrayList<Claim> getClaims() throws SQLException
    {
        ArrayList<Claim> claims = new ArrayList<>();
        ResultSet rs = selectAll("CLAIMS");
        while(rs.next())
            claims.add(new Claim(rs.getInt("id"), rs.getString("mem_id"), rs.getDate("date"), rs.getString("rationale"), rs.getString("status"), rs.getDouble("amount")));
        return claims;
    }
    
    public ArrayList<Member> getMembers() throws SQLException
    {
        ArrayList<Member> members = new ArrayList<>();
        ResultSet rs = selectAll("MEMBERS");
        while(rs.next())
            members.add(new Member(rs.getString("id"), rs.getString("name"), rs.getString("address"), rs.getDate("dob"), rs.getDate("dor"), rs.getString("status"), rs.getDouble("balance")));
        return members;
    }
    
    public boolean addClaim(Claim c)
    {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO CLAIMS VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, c.id);
            ps.setString(2, c.mem_id);
            ps.setDate(3, c.date);
            ps.setString(4, c.rationale);
            ps.setString(5, c.status);
            ps.setDouble(6, c.amount);
            ps.executeUpdate();      
            ps.close();
            return true;
        } catch (Exception e) {System.out.println("User record already extists");}
        return false;
    }
    
    public boolean addMember(Member m)
    {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO MEMBERS VALUES (?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.id);
            ps.setString(2, m.name);
            ps.setString(3, m.address);
            ps.setDate(4, m.dob);
            ps.setDate(5, m.dor);
            ps.setString(6, m.status);
            ps.setDouble(7, m.balance);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {System.out.println("User record already extists");}
        return false;
    }
    
    public boolean addPayment(Payment p)
    {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO PAYMENTS VALUES (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.id);
            ps.setString(2, p.mem_id);
            ps.setString(3, p.type_of_payment);
            ps.setDouble(4, p.amount);
            ps.setDate(5, p.date);
            ps.setTime(6, p.time);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {System.out.println("User record already extists");}
        return false;
    }
    
    public boolean addUser(User u)
    {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO USERS VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.id);
            ps.setString(2, u.password);
            ps.setString(3, u.status);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {System.out.println("User record already exists");}
        return false;
    }
    
    public boolean updateClaim(Claim c)
    {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE claims SET \"mem_id\" = ?, \"date\" = ?, \"rationale\" = ?, \"status\" = ?, \"amount\" = ? WHERE \"id\" = ?");
            ps.setString(1, c.mem_id);
            ps.setDate(2, c.date);
            ps.setString(3, c.rationale);
            ps.setString(4, c.status);
            ps.setDouble(5, c.amount);
            ps.setInt(6, c.id);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){}
        return false;
    }
    
    public boolean updateMember(Member m)
    {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE members SET \"name\" = ?, \"address\" = ?, \"dob\" = ?, \"dor\" = ?, \"status\" = ?, \"balance\" = ? WHERE \"id\" = ?");
            ps.setString(1, m.name);
            ps.setString(2, m.address);
            ps.setDate(3, m.dob);
            ps.setDate(4, m.dor);
            ps.setString(5, m.status);
            ps.setDouble(6, m.balance);
            ps.setString(7, m.id);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){}
        return false;
    }
    
    public boolean updatePayment(Payment p)
    {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE members SET \"mem_id\" = ?, \"type_of_payment\" = ?, \"amount\" = ?, \"date\" = ?, \"time\" = ? WHERE \"id\" = ?");
            ps.setString(1, p.mem_id);
            ps.setString(2, p.type_of_payment);
            ps.setDouble(3, p.amount);
            ps.setDate(4, p.date);
            ps.setTime(5, p.time);
            ps.setInt(6, p.id);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){}
        return false;
    }
    
    public boolean updateUser(User u)
    {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE users SET \"password\" = ?, \"status\" = ? WHERE \"id\" = ?");
            ps.setString(1, u.password);
            ps.setString(2, u.status);
            ps.setString(3, u.id);
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){}
        return false;
    }
}