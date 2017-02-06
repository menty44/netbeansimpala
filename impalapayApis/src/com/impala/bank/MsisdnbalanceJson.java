/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.impala.bank;

import impalapayapis.*;
//import com.impala.bank.sendJson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fred 0720106420 
 */
public class MsisdnbalanceJson {

    public String tumaBankms() throws IOException {

        try {

            URL url = new URL("https://staging.impalapay.net:8454/msisdnbalance");
            //URL url = new URL("https://staging.impalapay.net/msisdnbalance");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input =    "{\"api_username\":\"demo\","
                    + "\"session_id\":\"063451666b984c2cb66a2963bd2d2e39\","
                    + "\"country_code\":\"KE\"}\n" +
                      "";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            
            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
                System.out.println("Failed Response code is : " + conn.getResponseCode());
                //conn.disconnect();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            try {
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
            } catch (IOException ex) {
                Logger.getLogger(sendJson.class.getName()).log(Level.SEVERE, null, ex);
            }

            conn.disconnect();
            System.exit(0);

//        } catch (MalformedURLException e) {
//
//            e.printStackTrace();

//        } catch (IOException e) {
//
//            e.printStackTrace();

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return tumaBankms();

    }
    

}
