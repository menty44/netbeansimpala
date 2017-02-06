package com.fred.utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;

public class DBUtility {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                //Properties prop = new Properties();
                //InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
                //InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream(“config.properties”);
                //prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
                String url = "mysql://localhost:3306/trdr";
                System.out.println("The url is : " + url);
                String user = "root";
                System.out.println("The user is : " + user);
                String password = "";
                System.out.println("The Password is : " + password);
                //String driver = "com.mysql.jdbc.driver";
                //System.out.println("The driver is : " + driver);
                        
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trdr","root","");

                /*// Store the database URL in a string
                String serverName = “127.0.0.1”;
                String portNumber = “1521”;
                String sid = “XE”;
                String dbUrl = “jdbc:oracle:thin:@” + serverName + “:” + portNumber
                + “:” + sid;

                Class.forName(“oracle.jdbc.driver.OracleDriver”);
                // set the url, username and password for the database
                connection = DriverManager.getConnection(dbUrl, “”, “”); */
                System.out.println("The Connection : " + connection);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            //} catch (IOException e) {
                //e.printStackTrace();
            }
            return connection;
        }

    }

}
