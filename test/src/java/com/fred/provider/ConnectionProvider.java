/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.provider;

import static com.fred.provider.Provider.CONNECTION_URL;
import static com.fred.provider.Provider.DRIVER;
import static com.fred.provider.Provider.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author fred
 */


public class ConnectionProvider {

    private static Connection con = null;

    static {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
        }
    }

    public static Connection getCon() {
        return con;
    }

}
