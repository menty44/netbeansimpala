/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impala.servlet;

/**
 *
 * @author mulikevs
 */
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
import com.google.gson.JsonParser;
import com.impala.payment.Payment2;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * @author mulikevs
 *
 */
@WebServlet(name = "Remit", urlPatterns = {"/Remit"})
public class Remit extends HttpServlet { 
	
    
    Payment2 remittoairtel = new Payment2();
	//private Payment2 remittoairtel;
	
	private String statuscode = "00032";
	
	private String Statusdescription = "INTERNAL_SERVER_ERROR";
	
	 
        
	
	
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
                Logger.getLogger(Remit.class.getName()).log(Level.SEVERE, null, ex);
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
	private String moneytransfer(HttpServletRequest request) throws IOException, JSONException {
	
		// joined json string
		String join = "";
		JsonElement root = null;
		JsonElement root2 = null;
		JsonElement root3 = null;
		
		String responseobject = "";
                 String nickname="KENDYIPL";

		// These represent parameters received over the network
		String   referenceid="", customermsisdn="",amount="",batchref="",username="", password="", narrative="";
						//referenceid, customermsisdn, nickname,amount, batchref, username, password, narrative
		
		// Get all parameters, the keys of the parameters are specified
		List<String> lines = IOUtils.readLines(request.getReader());

		// used to format/join incoming JSon string
		join = StringUtils.join(lines.toArray(), "");
		
		//###############################################################################
		// instantiate the JSon
		//Note
		//The = sign is encoded to \u003d. Hence you need to use disableHtmlEscaping().
		//###############################################################################
		
		Gson g = new GsonBuilder().disableHtmlEscaping().create();
		//Gson g = new Gson();
		Map<String, String> expected = new HashMap<>();

		try {
			// parse the JSon string
                        //referenceid, customermsisdn, nickname,amount, batchref, username, password, narrative
		
			root = new JsonParser().parse(join);
			
			referenceid = root.getAsJsonObject().get("transaction_id").getAsString();
			
			
			customermsisdn = root.getAsJsonObject().get("beneficiary_msisdn").getAsString();
			
			amount = root.getAsJsonObject().get("amount").getAsString();
			
			password = root.getAsJsonObject().get("password").getAsString();
			batchref= root.getAsJsonObject().get("source_msisdn").getAsString();
			username = root.getAsJsonObject().get("username").getAsString();
                        narrative = root.getAsJsonObject().get("sendingIMT").getAsString();

		} catch (Exception e) {
		
			expected.put("command_status","COMMANDSTATUS_INVALID_PARAMETERS");
			String jsonResult = g.toJson(expected);
                        System.out.println(e);

			return jsonResult;
		}
		
		// check for the presence of all required parameters
		if (StringUtils.isBlank(referenceid) || StringUtils.isBlank(customermsisdn) || StringUtils.isBlank(nickname)
				|| StringUtils.isBlank(amount) ||  StringUtils.isBlank(password) || StringUtils.isBlank(batchref)
				|| StringUtils.isBlank(username) || StringUtils.isBlank(narrative)) {
			
			expected.put("am_referenceid", username);
		    expected.put("am_timestamp", "tombwa");
			expected.put("status_code", statuscode );
			expected.put("status_description", Statusdescription);
			String jsonResult = g.toJson(expected);

			return jsonResult;
		}
          
			
			
			//assign the remit url from properties.config
			
	        
			String processtransaction = remittoairtel.Airtelpayout( referenceid, customermsisdn, nickname,
             amount, batchref, username, password, narrative);
			//capture the switch respoinse.
			
                        
                        System.out.println(processtransaction);
     
			//pass the returned json string
			JsonElement roots = new JsonParser().parse(processtransaction);
	        
			//exctract a specific json element from the object(status_code)
			String switchresponse = roots.getAsJsonObject().get("Status")
					.getAsString();
	
			
			
			
			
			
			
			
			
			if(switchresponse.equalsIgnoreCase("success") ){
				switchresponse = "S000";
			}
			
			//map error
			if(switchresponse.equalsIgnoreCase("failed")){
				switchresponse = "00029";
			}
                        
                        if(switchresponse.equalsIgnoreCase("Insufficient Funds In Source Wallet")){
				switchresponse = "00029";
			}
			
		
			
			
			//add 
			
			
		String success = "S000";
		
		
		if(switchresponse.equalsIgnoreCase(success)){
                    
                    //exctract a specific json element from the object(transactionID)
		String transactionID = roots.getAsJsonObject().get("Reference").getAsString();
			
		  
		
			expected.put("am_referenceid", transactionID);
		    expected.put("am_timestamp", username);
			expected.put("status_code", "S000");
			expected.put("status_description","SUCCESSFUL");
			String jsonResult = g.toJson(expected);
		 	

			return jsonResult;
		}
	
		expected.put("am_referenceid", username);
	    expected.put("am_timestamp", username);
		expected.put("status_code", switchresponse );
		expected.put("status_description", "FAILED");
			
		
			
			
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
