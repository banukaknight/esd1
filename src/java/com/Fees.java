/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leoed
 */
public class Fees {
    public static boolean initialFeePaid(Member m, DBBean bean) throws SQLException{
        ArrayList<Payment> payments = bean.getPayments();
        for(Payment p : payments)
            if(p.mem_id.equals(m.id) && p.type_of_payment.startsWith("FEE"))
                return true;
        return false;
    }
}
