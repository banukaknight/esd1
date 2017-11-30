package com;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Jake
 */
public class Payment {
    //Payment Attributes
    public int id;
    public String mem_id;
    public String type_of_payment;
    public double amount;
    public Date date;
    public Time time;
    public Payment(int _id, String _mem_id, String _type_of_payment, double _amount, Date _date, Time _time)
    {
        id = _id;
        mem_id = _mem_id;
        type_of_payment = _type_of_payment;
        amount = _amount;
        date = _date;
        time = _time;
    }
    
    @Override
    public String toString()
    {
        return String.format("id: %s memid: %s type of payment: %s amount: %f date: %s time: %s", id, mem_id, type_of_payment, amount, date, time);
    }
}
