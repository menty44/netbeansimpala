/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impala.paga.all;

/**
 *
 * @author mulikevs


    
}*/

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.impala.paga.util.PostWithIgnoreSSLPaga;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.element.Element;
import javax.servlet.annotation.WebServlet;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * @author mulikevs
 *
 */
@WebServlet(name = "MoneyTransfer", urlPatterns = {"/MoneyTransfer"})
public class RouteRemit extends HttpServlet { 
	
	private PostWithIgnoreSSLPaga PostWithIgnoreSSLPaga;
	
	private String statuscode = "00032";
	
	private String Statusdescription = "INTERNAL_SERVER_ERROR";
	
	 JSONObject toPaga= new JSONObject();
        
        
        
	
	
	private String CLIENT_URL ="";

	/**
	 * 
	 * @param config
	 * @throws ServletException
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
			
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 *             , IOException
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream out = response.getOutputStream();

		response.setContentType("text/plain;charset=UTF-8");
		response.setDateHeader("Expires", new Date().getTime()); // Expiration
																	// date
		response.setDateHeader("Date", new Date().getTime()); // Date and time
            try {
                // that the
                // message was
                // sent
                out.write(moneytransfer(request).getBytes());
            } catch (JSONException ex) {
                Logger.getLogger(RouteRemit.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(RouteRemit.class.getName()).log(Level.SEVERE, null, ex);
            }
		out.flush();
		out.close();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private String moneytransfer(HttpServletRequest request) throws IOException, JSONException, NoSuchAlgorithmException {
	
		// joined json string
		Account account = null;

		String join = "";
		JsonElement root = null, roots = null;
		JsonObject root2 = null, creditrequest = null;
                
                Properties prop = new Properties();
                String hashkey = prop.getProperty("hashkey");
                String principal = prop.getProperty("principal");
                String credentials = prop.getProperty("credentials");
                //String hashkey ="372e9b1c62ef47db83c566cf2db033cb4e1b847e12ec435997971ebd7ab8121cbd8458176374480eae7d4cb55f722f4ab328207b461f423a85a9bbad8850ce66";
                //String principal="02A10715-0E53-4A8C-982E-2B7BFC7CF550";
                //String credentials ="QE3@u=jd*2b+";

		String apiusername = "", apipassword = "", username = "", transactioinid = "", sourcecountrycode = "",
				recipientcurrencycode = "", recipientcountrycode = "", sourcemsisdn = "", recipientmobile = "",
				sendername = "", amountstring = "", remiturlss = "", responseobject = "", statuscode = "",
				statusdescription = "", referencenumber = "";

		// Get all parameters, the keys of the parameters are specified
		List<String> lines = IOUtils.readLines(request.getReader());

		// used to format/join incoming JSon string
		join = StringUtils.join(lines.toArray(), "");

		// ###############################################################################################
		// instantiate the JSon
		// Note
		// The = sign is encoded to \u003d. Hence you need to use
		// disableHtmlEscaping().
		// ###############################################################################################

		Gson g = new GsonBuilder().disableHtmlEscaping().create();
		// Gson g = new Gson();
		Map<String, String> expected = new HashMap<>();

		try {
			// parse the JSon string
			root = new JsonParser().parse(join);

			apiusername = root.getAsJsonObject().get("username").getAsString();

			apipassword = root.getAsJsonObject().get("password").getAsString();

			username = root.getAsJsonObject().get("sendingIMT").getAsString();

			transactioinid = root.getAsJsonObject().get("transaction_id").getAsString();

			sourcecountrycode = root.getAsJsonObject().get("sourcecountrycode").getAsString();

			recipientcurrencycode = root.getAsJsonObject().get("recipientcurrencycode").getAsString();

			recipientcountrycode = root.getAsJsonObject().get("recipientcountrycode").getAsString();

			sendername = root.getAsJsonObject().get("Sender_Name").getAsString();

			amountstring = root.getAsJsonObject().get("amount").getAsString();

			remiturlss = root.getAsJsonObject().get("url").getAsString();

			sourcemsisdn = root.getAsJsonObject().get("source_msisdn").getAsString();

			recipientmobile = root.getAsJsonObject().get("beneficiary_msisdn").getAsString();

			root2 = root.getAsJsonObject();

		} catch (Exception e) {

			expected.put("command_status", APIConstants.COMMANDSTATUS_INVALID_PARAMETERS);
			String jsonResult = g.toJson(expected);

			return jsonResult;
		}

		// check for the presence of all required parameters
		if (StringUtils.isBlank(apiusername) || StringUtils.isBlank(apipassword) || StringUtils.isBlank(username)
				|| StringUtils.isBlank(transactioinid) || StringUtils.isBlank(sourcecountrycode)
				|| StringUtils.isBlank(recipientcurrencycode) || StringUtils.isBlank(sendername)
				|| StringUtils.isBlank(amountstring) || StringUtils.isBlank(remiturlss)
				|| StringUtils.isBlank(recipientcountrycode)) {

			expected.put("status_code", "server error");
			expected.put("status_description", "missing parameters");
			String jsonResult = g.toJson(expected);

			return jsonResult;
		}

		if (root2.has("vendor_uniquefields")) {

		}

		// Retrieve the account details
		Element element;
		if ((element = accountsCache.get(username)) != null) {
			account = (Account) element.getObjectValue();
		}

		// Secure against strange servers making request(future upgrade should
		// lock on IP)
		if (account == null) {
			expected.put("status_code", "server error");
			expected.put("status_description", "unauthorised user");
			String jsonResult = g.toJson(expected);

			return jsonResult;
		}

                MessageDigest md = null;
                String saltedToken = transactioinid + amountstring + recipientmobile + hashkey;
                md = MessageDigest.getInstance("SHA-512");
                md.update(saltedToken.getBytes());
                byte byteData[] = md.digest();
                
                //convert the byte to hex format method 1
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < byteData.length; i++) {
                     sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                    }

                    System.out.println("Hex format : " + sb.toString());
                String hash = sb.toString();
                
                  int intamount = Integer.parseInt(amountstring);	
		
                                       
			               
			               
			               toPaga.put("referenceNumber", transactioinid);
			               toPaga.put("amount", amountstring);
			              
			               toPaga.put("destinationAccount", recipientmobile);
			            
			
			System.out.println(toPaga.toString());
			
			//assign the remit url from properties.config
			CLIENT_URL = remiturlss;
	        //principal = "" , credentials = "", hash = ""
			PostWithIgnoreSSLPaga = new PostWithIgnoreSSLPaga(CLIENT_URL, toPaga.toString(),principal,credentials,hash);
	
			//capture the switch respoinse.
			responseobject = PostWithIgnoreSSLPaga.doPost();
                        
                        System.out.println(responseobject);
     
			//pass the returned json string
			JsonElement roots1 = new JsonParser().parse(responseobject);
	        
			int responseCode = roots1.getAsJsonObject().get("responseCode")
					.getAsInt();
	
			
			
			
			
			

                     String switchresponse =  Integer.toString(responseCode);
			
		
			
			
			//add 
			
			
		String success = "S001";
		
		
		if(responseCode==0){
                    
                  //exctract a specific json element from the object(status_code)
			 statusdescription = roots1.getAsJsonObject().get("message").getAsString();
			
		  
		
			expected.put("am_referenceid", transactioinid);
		    expected.put("am_timestamp", success);
			expected.put("status_code", "S001");
			expected.put("status_description",statusdescription);
			String jsonResult = g.toJson(expected);
		 	

			return jsonResult;
		}
	
		expected.put("am_referenceid", "");
	    expected.put("am_timestamp", "");
		expected.put("status_code", "" );
		expected.put("status_description", "");
			
		
			
			
		String jsonResult = g.toJson(expected);

		return jsonResult;
		
       }

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 *             , IOException
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


}

