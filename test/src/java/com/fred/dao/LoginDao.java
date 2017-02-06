/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.dao;

import com.fred.bean.LoginBean;
import com.fred.provider.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author fred
 */


public class LoginDao {

    public static boolean validate(LoginBean bean) {
        boolean status = false;
        
        try {
            Connection con = ConnectionProvider.getCon();

            PreparedStatement ps = con.prepareStatement(
                    "select * from user432 where email=? and pass=?");

            ps.setString(1, bean.getEmail());
            ps.setString(2, bean.getPass());

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }
}
