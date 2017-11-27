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
public class Claims {
    public static ArrayList<Claim> getClaimsByMemberId(String memberId, DBBean bean) throws SQLException{
        ArrayList<Claim> allClaims = bean.getClaims();
        ArrayList<Claim> membersClaims = new ArrayList<>();
        
        for(Claim c : allClaims)
            if(c.mem_id.equals(memberId))
                membersClaims.add(c);
        
        return membersClaims;
    }
}
