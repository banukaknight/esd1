/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Jake
 */
public class TotalIncomeCalculator {
    public double getClaimsTotal(DBBean b) throws SQLException
    {
        ArrayList<Claim> claims = b.getClaims();
        
        double claimamount = 0;
        double chargeamount = 0;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -1);
        java.util.Date d = cal.getTime();
        for(Claim c : claims)
            if(d.before(c.date) && c.status.startsWith("APPROVED"))
                claimamount +=  c.amount;
        return claimamount;
    }
    public double getChargeTotal(DBBean b) throws SQLException
    {
        ArrayList<Member> members = b.getMembers();
        return getClaimsTotal(b) / members.size();
    }
    public void updateMembers(DBBean b) throws SQLException
    {
        ArrayList<Member> members = b.getMembers();
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        Double chargeamount = Double.parseDouble(df.format(getChargeTotal(b)));
        for(Member m : members)
        {
            m.balance += chargeamount;
            b.updateMember(m);
        }
    }
}
