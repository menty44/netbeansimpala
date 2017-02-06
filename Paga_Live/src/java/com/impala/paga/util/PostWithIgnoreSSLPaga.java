 
  /**
   * Description of class.
   * <p>
   * Copyright (c) ImpalaPay Ltd., Sep 20, 2016  
   * 
   * @author <a href="mailto:kmuli@impalapay.com">Kelvin Muli M.</a>
   * 
   */
package com.impala.paga.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.log4j.Logger;
import org.apache.commons.codec.binary.Base64;

/**
 * @author mulikevs
 *
 */
public class PostWithIgnoreSSLPaga {


	private String httpsUrl;
	private String params;
	private String principal;
	private String credentials;
        private String hash;
        
	boolean retry;
	private Logger logger;
	public PostWithIgnoreSSLPaga() {
		logger = Logger.getLogger(this.getClass());
	}

	public PostWithIgnoreSSLPaga(String httpsUrl, String params,String principal, String credentials, String hash) {
		super();
		this.httpsUrl = httpsUrl;
		this.params = params;
		this.principal = principal;
		this.credentials = credentials;
                this.hash = hash;

	}

	public String doPost() {
		URL url;
		String response = "";
                
            
		

		try {
			// Create a context that doesn't check certificates.
			SSLContext sslContext = SSLContext.getInstance("TLS");
			TrustManager[] trustMgr = getTrustManager();

			sslContext.init(null, // key manager
					trustMgr, // trust manager
					new SecureRandom()); // random number generator
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext
					.getSocketFactory());
                        System.out.println("principal:"+principal);
                        System.out.println("credentials:"+credentials);
                        System.out.println("hash:"+hash);

			url = new URL(httpsUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            
			      con.setRequestProperty("principal", principal); 
			       con.setRequestProperty("credentials",credentials); 
                               con.setRequestProperty("hash",hash); 
			       con.setRequestProperty("Content-Type", "application/json");
			     
			       con.setRequestProperty("Cache-Control", "no-cache");
			
			con.setRequestMethod("POST");
			con.setDoOutput(true);
                        System.out.println(con);
			//######################################################################
			// Send data to the output
			//######################################################################
			sendData(con, params);
            
			//######################################################################
			// Dump all the content
			//#######################################################################
			response = getContent(con);

		} catch (MalformedURLException e) {
			System.err.println("MalformedURLException");
			e.printStackTrace();

		} catch (IOException e) {
			System.err.println("IOException");
			e.printStackTrace();

		} catch (NoSuchAlgorithmException e) {
			System.err.println("NoSuchAlgorithmException");
			e.printStackTrace();

		} catch (KeyManagementException e) {
			System.err.println("KeyManagementException");
			e.printStackTrace();
		}

		return response;
	}
	
	public String doGet() {
		URL url;
		String response = "";
              
		

		try {
			// Create a context that doesn't check certificates.
			SSLContext sslContext = SSLContext.getInstance("TLS");
			TrustManager[] trustMgr = getTrustManager();

			sslContext.init(null, // key manager
					trustMgr, // trust manager
					new SecureRandom()); // random number generator
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext
					.getSocketFactory());

			url = new URL(httpsUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            
			
			       con.setRequestProperty("content-type", "application/json");
			     
			       con.setRequestProperty("Cache-Control", "no-cache");
			
			con.setRequestMethod("GET");
			//con.setDoOutput(false);
			//######################################################################
			// Send data to the output
			//######################################################################
			//sendData(con, params);
            
			//######################################################################
			// Dump all the content
			//#######################################################################
			response = getContent(con);

		} catch (MalformedURLException e) {
			System.err.println("MalformedURLException");
			e.printStackTrace();

		} catch (IOException e) {
			System.err.println("IOException");
			e.printStackTrace();

		} catch (NoSuchAlgorithmException e) {
			System.err.println("NoSuchAlgorithmException");
			e.printStackTrace();

		} catch (KeyManagementException e) {
			System.err.println("KeyManagementException");
			e.printStackTrace();
		}

		return response;
	}

		    //##################################################################
			/**
			 * Send data to the url
			 * @param con
			 */
			//#################################################################
			private void sendData(HttpsURLConnection con, String args) {
				if (con != null) {
			
					try {
						// send data to output
						OutputStreamWriter writer = new OutputStreamWriter(
								con.getOutputStream());
			
						writer.write(args);
						writer.flush();
						writer.close();
			
					} catch (IOException e) {
						System.err.println("IOException");
						e.printStackTrace();
					}
				}
			}
			
			//###############################################################
			/**
			 * @param con
			 */
			//###############################################################
			private String getContent(HttpsURLConnection con) {
				StringBuffer buff = new StringBuffer("");
			
				if (con != null) {
			
					try {
			
						BufferedReader br = new BufferedReader(new InputStreamReader(
								con.getInputStream()));
			
						String input;
			
						while ((input = br.readLine()) != null) {
							buff.append(input + "\n");
						}
						br.close();
			
					} catch (IOException e) {
						e.printStackTrace();
					}
				}// end 'if(con != null)'
			
				return buff.toString().trim();
			}
			
			//################################################################
			/**
			 * @return {@link TrustManager}
			 */
			//################################################################
			private TrustManager[] getTrustManager() {
			
				TrustManager[] certs = new TrustManager[] { new X509TrustManager() {
					public X509Certificate[] getAcceptedIssuers() {
						return null;
					}
			
					public void checkClientTrusted(X509Certificate[] certs, String t) {
					}
			
					public void checkServerTrusted(X509Certificate[] certs, String t) {
					}
				} };
			
				return certs;
			}


}

