/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fred 0720106420
 */
public class LoginDao {
    
    public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "trdr";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = (PreparedStatement) conn
                    .prepareStatement("select * from users where fname=? and password=?" );
            pst.setString(1, name);
            pst.setString(2, pass);
            

            rs = pst.executeQuery();
            status = rs.next();
            
            

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
    
}
