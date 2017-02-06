/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package airtimegw;

/**
 *
 * @author fred
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Airtimegw {

    /**
     * @param args the command line arguments
     */
    
    private final String USER_AGENT = "Mozilla/5.0";
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        

	//public static void main(String[] args) throws Exception {

		Airtimegw http = new Airtimegw();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

//		System.out.println("\nTesting 2 - Send Http POST request");
//		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://localhost:8443/AirtimeGateway/0.3/getNonce?api_username=tawi&device_id=abc123";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}

    
}
