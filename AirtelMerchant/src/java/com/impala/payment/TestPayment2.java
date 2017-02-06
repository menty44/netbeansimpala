/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impala.payment;

import java.util.UUID;

/**
 *
 * @author mulikevs
 */
public class TestPayment2 {
    
    public static void main(String[] args) throws  Exception{
        
        //String referenceid,String customermsisdn,String nickname,
          //  String amount,String batchref,String username,String password,String narrative
          UUID referencenumber = UUID.randomUUID();
        String reference_id=referencenumber.toString();
        
		String customermsisdn="254733190378";
		
		String amount="5000";
                String batchref="100";
                
                
                String narrative="Remitance";
		String nickname="KENDYIPL";
		
                String username="KENDYIPLUserName";
                String password="KENDYIPL123#Password";
        
		
		Payment2 booktrans = new Payment2();
		String processtransaction = booktrans.Airtelpayout( reference_id, customermsisdn, nickname,
             amount, batchref, username, password, narrative);
		
		System.out.println("Test Result   "+processtransaction);
		
	}
    
}
