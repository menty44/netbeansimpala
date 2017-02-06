/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.utility;

/**
 *
 * @author fred
 */
import com.mysql.jdbc.Driver;

import com.fred.utility.DBUtility;

public class testdb {
    
    public static void main(String[] args) {
        DBUtility db = new DBUtility();
        
        db.getConnection();
        
        System.out.println("system end ...");
        
    }
    
}
