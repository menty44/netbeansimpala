package uba_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Balance {

    public  static void main(String [] args){}


    public String GetBalance(){

        StringBuilder responseSB = null;

        try
        {

            UUID referencenumber = UUID.randomUUID();
            Map<String,String> user2=new HashMap<>();

                String urlparameters = "email=john33@yahou.com&firstname=John&lastname=Obi&phone=0834569876&merchantID=DEMO1900050&uniqueID=1234&description=Phone No.|08034569876|TEST PAY&amount=100.00&returnUrl=https://your.return.url?ref=022d086125fbc4ffc8d4a42504c7ad7b";

            URL url = new URL("https://ke.ubillsafrica.com/api/bill/payment");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            // Write data
            OutputStream os = connection.getOutputStream();
            os.write(urlparameters.getBytes());
            // System.out.println("connection : " + connection);
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + urlparameters);
            System.out.println("Response Code : " + responseCode);

            responseSB = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ( (line = br.readLine()) != null)
                responseSB.append(line);

            // Close streams
            br.close();
            os.close();
            if (!responseSB.toString().trim().equals(""))
            {
                System.out.println("OK");

            }

        }catch (Exception ee)
        {
            ee.printStackTrace();

        }
        return responseSB.toString();

    }

}