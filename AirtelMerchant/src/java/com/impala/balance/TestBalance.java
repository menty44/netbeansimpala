/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impala.balance;

import com.impala.payment.*;
import java.util.UUID;

/**
 *
 * @author mulikevs
 */
public class TestBalance {
    
    public static void main(String[] args) throws  Exception{
        
      
        
		
		String nickname="KENDYIPL";
		
                String username="KENDYIPLUserName";
                String password="KENDYIPL123#Password";
                
		
        
		
		AMBalance booktrans = new AMBalance();
		String processtransaction = booktrans.AirtelBalance( nickname,
             username, password);
		
		System.out.println("Test Result   "+processtransaction);
		
	}
    
}
