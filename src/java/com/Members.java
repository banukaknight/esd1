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
public class Members {
    public static ArrayList<Member> getAppliedMembers(DBBean bean) throws SQLException{
        ArrayList<Member> appliedMembers = new ArrayList<>();
        ArrayList<Member> allMembers = bean.getMembers();
        
        for(Member m : allMembers){
            if(m.status.equalsIgnoreCase("APPLIED"))
                appliedMembers.add(m);
        }
        
        return appliedMembers;
    }
    
    public static ArrayList<Member> getAppliedEligibleMembers(DBBean bean) throws SQLException{
        ArrayList<Member> appliedMembers = getAppliedMembers(bean);
        ArrayList<Member> eligibleMembers = new ArrayList<>();
        
        for(Member m : appliedMembers)
            if(Fees.initialFeePaid(m, bean))
                eligibleMembers.add(m);
        
        return eligibleMembers;
    }
    
    public static void approveMember(Member m, DBBean bean){
        m.status = "APPROVED";
        bean.updateMember(m);
    }
    
    public static ArrayList<Member> getMembersWithOutstandingBalances(DBBean bean) throws SQLException{
        ArrayList<Member> outstandingMembers = new ArrayList<>();
        ArrayList<Member> allMembers = bean.getMembers();
        
        for(Member m : allMembers){
            if(m.balance != 0)
                outstandingMembers.add(m);
        }
        
        return outstandingMembers;
    }
    
    public static Member getMemberById(String Id, DBBean bean) throws SQLException{
        ArrayList<Member> allMembers = bean.getMembers();
        
        for(Member m : allMembers)
            if(m.id.equals(Id))
                return m;
        return null;
    }
}
