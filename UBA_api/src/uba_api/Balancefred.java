package uba_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Balancefred {

    public static void main (String [] args) {

        String apiUrl = "https://ke.ubillsafrica.com/api/bill/payment?";
        String email = "email=john33@yahou.com";
        String urlparameters = "&firstname=John&lastname=Obi&phone=0834569876&merchantID=DEMO1900050&uniqueID=1234&description=Phone No.|08034569876|TEST PAY&amount=100.00&returnUrl=https://your.return.url?ref=022d086125fbc4ffc8d4a42504c7ad7b";

        System.out.println("Response for a  request : " + getResponse(apiUrl + email + urlparameters
                
        ));
        
        //int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + apiUrl);
            System.out.println("Post parameters : " + urlparameters);
        String responseCode = null;
            System.out.println("Response Code : " + responseCode);
    }

    private static String getResponse(String urlStr) {
        URLConnection conn;
        URL url;
        BufferedReader reader;
        String response = "";

        try {
            url = new URL(urlStr);
            conn = url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            response = reader.readLine();

            reader.close();

        } catch (MalformedURLException e) {
            // TODO: handle exception
            System.err.println("MalformedURLException");
            e.printStackTrace();

        } catch (IOException e2) {
            // TODO: handle exception
            System.err.println("IOException exception");
            e2.printStackTrace();

        }

        return response;


    }

    String GetBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}


