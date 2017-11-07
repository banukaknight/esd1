
package com;

import java.sql.Date;

/**
 *
 * @author Jake
 */
public class Member {
    public String id;
    public String name;
    public String address;
    public Date dob;
    public Date dor;
    public String status;
    public double balance;
    public Member(String _id, String _name, String _address, Date _dob, Date _dor, String _status, double _balance)
    {
        id = _id;
        name = _name;
        address = _address;
        dob = _dob;
        dor = _dor;
        status = _status;
        balance = _balance;
    }
    @Override
    public String toString()
    {
        return String.format("ID: %s Name: %s Address: %s DOB: %s DOR: %s Status: %s Balance: %f", id, name, address, dob.toString(), dor.toString(), status, balance);
    }
}
