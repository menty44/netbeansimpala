/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.login;

/**
 *
 * @author fred
 */

import com.fred.login.*;

public class db {
    
    public static void main(String[] args) {
        
        ConnectionManager conn = new ConnectionManager();
        
        String fred = conn.getConnection().toString();
        
        System.out.println("display : " + fred);
        
    }
    
}
