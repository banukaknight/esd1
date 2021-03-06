package com;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leoed
 */
public class Payments {
    public static ArrayList<Payment> getPaymentsByMemberId(String memberId, DBBean bean) throws SQLException{
        ArrayList<Payment> allPayments = bean.getPayments();
        ArrayList<Payment> membersPayments = new ArrayList<>();
        
        for(Payment p : allPayments)
            if(p.mem_id.equals(memberId))
                membersPayments.add(p);
        
        return membersPayments;
    }
}
