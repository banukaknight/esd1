
package com;

import java.sql.Date;

/**
 *
 * @author Jake
 */
public class Claim {
    public int id;
    public String mem_id;
    public Date date;
    public String rationale;
    public String status;
    public double amount;
    public Claim(int _id, String _mem_id, Date _date, String _rationale, String _status, double _amount)
    {
        id = _id;
        mem_id = _mem_id;
        date = _date;
        rationale = _rationale;
        status = _status;
        amount = _amount;
    }
    @Override
    public String toString()
    {
        return String.format("ID: %s Memid: %s Date: %s Rationale: %s Status: %s Amount: %f",id, mem_id, date.toString(), rationale, status, amount);
    }
}
