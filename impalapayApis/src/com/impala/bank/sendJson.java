/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impala.bank;

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
public class sendJson {

    public String tumaBank() throws IOException {

        try {

            URL url = new URL("https://staging.impalapay.net/bankTransfer");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\n" +
                            "    \"api_username\": \"demo\",\n" +
                            "    \"session_id\": \"be5686245f214f7fa1a1c0f2e5010e2a\",\n" +
                            "    \"source_country_code\": \"KE\",\n" +
                            "    \"sendername\": \"eugene chimita\",\n" +
                            "    \"recipient_mobile\": \"2347062988820\",\n" +
                            "    \"recipient_currency_code\": \"UGX\",\n" +
                            "    \"recipient_country_code\": \"UG\",\n" +
                            "    \"reference_number\": \"12345454\",\n" +
                            "    \"bank_code\": \"CBA\",\n" +
                            "    \"amount\": \"2 \",\n" +
                            "    \"client_datetime\": \"656565\",\n" +
                            "    \"sender_address\": \"nairobikenya\",\n" +
                            "    \"sender_city\": \"nairobi\",\n" +
                            "    \"recipientname\": \"machetteeee\",\n" +
                            "    \"accountnumber\": \"256715290374\"\n" +
                            "}";

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
        return tumaBank();

    }
    

}
