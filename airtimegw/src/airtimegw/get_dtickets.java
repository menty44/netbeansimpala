package airtimegw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

import java.nio.charset.Charset;

import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//import jdk.internal.dynalink.beans.StaticClass;

/**
 * Tests our Nonce dispenser. This class is intended for use in the Developer 
 * API guide and is for demonstration rather than thorough testing.
 * <p>
 * Copyright (c) Tawi Commercial Services Ltd., Aug 29th, 2016  
 * 
 * @author Fred Oluoch
 * @author <a href="mailto:michael@tawi.mobi">Michael Wakahe</a>
 * 
 */
public class get_dtickets {

	// Bypassing the SSL verification to execute our code successfully 
//    static {
//        try {
//            disableSSLVerification();
//        } catch (NoSuchAlgorithmException ex) {
//        	System.err.println("NoSuchAlgorithmException");
//        	ex.printStackTrace();
//        }
//    }   

    
    
    /**
     * @param args
     * @throws NoSuchAlgorithmException 
     */
    public static void main(String[]args) throws NoSuchAlgorithmException{
        
    	String nonceEndpoint = "https://www.neosurf.info/soap/?wsdl";
        
        String currency = "EUR";
        String IDProduct = "14";
        String IDReseller = "impalapay.reseller.test@neosurf.com+soked3dpme";
        String IDTransaction = "TRX002";
        int IDUser = 225;
        int quantity = 1;
        String distributorSecretKey = "de544d61zekhe6fgkezuf64e69effztd";
    	
    	String fred = currency + IDProduct + IDReseller + IDTransaction + IDUser + quantity + distributorSecretKey;

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(fred.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        //System.out.println("Hex format : " + sb.toString());

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	//System.out.println("Hex format : " + hexString.toString());
    	
    	String hash = hexString.toString();
    	
    	System.out.println(hash);
    	System.out.println();
    	System.out.println();    	
        
//        System.out.println("\nOutput: \n" + callURL(nonceEndpoint + "?api_username=" + api_username 
//        		+ "&device_id=" + device_id + "&hash=" + hash ));        
    }    
    
    
    /**
     * @param myURL
     * @return the result of calling an URL
     */
//    public static String callURL(String myURL) {
//        System.out.println("Requeted URL:\n" + myURL);
//		StringBuilder sb = new StringBuilder();
//		URLConnection urlConn = null;
//		InputStreamReader in = null;
//        
//        try {
//            
//            URL url = new URL(myURL);
//            urlConn = url.openConnection();
//            
//            if (urlConn != null)
//                urlConn.setReadTimeout(60 * 1000);
//            
//            if (urlConn != null && urlConn.getInputStream() != null) {
//                in = new InputStreamReader(urlConn.getInputStream(),
//                        Charset.defaultCharset());
//                
//                BufferedReader bufferedReader = new BufferedReader(in);
//                
//                if (bufferedReader != null) {
//                    int cp;
//                    
//                    while ((cp = bufferedReader.read()) != -1) {
//                        sb.append((char) cp);                        
//                    }
//                    
//                    bufferedReader.close();
//                }// end 'if (bufferedReader != null)'
//                
//            } // end 'if (urlConn != null && urlConn.getInputStream() != null)'
//            
//            in.close();
//            
//            } catch (Exception e) {                
//                throw new RuntimeException("Exception while calling URL:"+ myURL, e);                
//            } 
//        
//        return sb.toString();
//	}    
    
    
    /**
     * Method used for bypassing SSL verification
     * 
     * @throws NoSuchAlgorithmException
     */
//    public static void disableSSLVerification() throws NoSuchAlgorithmException {

//        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
//            @Override
//			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
//                return null;
//            }
//
//            @Override
//			public void checkClientTrusted(X509Certificate[] certs, String authType) { }
//
//            @Override
//			public void checkServerTrusted(X509Certificate[] certs, String authType) { }
//
//        } };
//
//        SSLContext sc = null;
//        try {
//            sc = SSLContext.getInstance("SSL");
//            sc.init(null, trustAllCerts, new java.security.SecureRandom());
//            
//        } catch (KeyManagementException e) {
//        	System.err.println("KeyManagementException");
//            e.printStackTrace();
//            
//        } catch (NoSuchAlgorithmException e) {
//        	System.err.println("NoSuchAlgorithmException");
//            e.printStackTrace();
//        }
//        
//        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
//
//        HostnameVerifier allHostsValid = new HostnameVerifier() {
//        	
//            /**
//             * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String, javax.net.ssl.SSLSession)
//             */
//            @Override
//			public boolean verify(String hostname, SSLSession session) {
//                return true;
//            }
//        };      
//        
//        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);           
//    }
}