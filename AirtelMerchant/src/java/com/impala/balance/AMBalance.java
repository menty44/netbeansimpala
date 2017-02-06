/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impala.balance;

/**
 *
 * @author mulikevs
 */
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.json.XML;



/**
 * @author mulikevs
 *
 */
public class AMBalance {
	
	 /**
     * Starting point for the SAAJ - SOAP Client Testing
     */
    public String AirtelBalance(String nickname,
          String username,String password) {
        
        org.json.JSONObject xmlJSONObj = null;
        try {
            // Create SOAP Connection
        	String resp = "";
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            
            String url = "https://41.223.58.41:8446/MerchantPaymentService.asmx";
            doTrustToCertificates();
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(  nickname,
              username, password), url);
            
            ByteArrayOutputStream out = new ByteArrayOutputStream(); 
            soapResponse.writeTo(out);
           // System.out.println("Kasambe"+out.toString());
             String xml = out.toString();
             
          
             // System.out.println(xml);
              
              
               String replacedStr = xml.replaceAll("&lt;", "<");
               
               String replacedString = replacedStr.replaceAll("&gt;", ">");
               //&gt;
             
             
             //
            
            
            // String replacedStr3 = xml.replaceAll("&lt;", "<");
             
             System.out.println(replacedString);
             
              String replacedStr1 = replacedString.replaceAll("<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"><env:Header xmlns:work=\"http://bea.com/2004/06/soap/workarea/\"><work:WorkContext xmlns:wsu=\"http://schemas.xmlsoap.org/ws/2002/07/utility\" xmlns:work=\"http://bea.com/2004/06/soap/workarea/\"><java class=\"java.beans.XMLDecoder\"> \n" +
" <string>weblogic.app.BulkPaymentWebService</string> \n" +
" <int>214</int> \n" +
" <string>weblogic.workarea.StringWorkContext</string> \n" +
" <string>2.0</string> \n" +
" <string/> \n" +
"</java></work:WorkContext></env:Header><env:Body>", "");
             String replacedStr2 = replacedStr1.replaceAll("<m:CheckBalanceResponse xmlns:m=\"http://www.obopay.com/xml/bulkpayment/v1\"><m:CheckBalanceResult>", "");
             String replacedStr3 = replacedStr2.replaceAll("</m:CheckBalanceResult></m:CheckBalanceResponse></env:Body></env:Envelope>", "");
//java:
           String replacedStr4 = replacedStr3.replaceAll("xmlns:java=\"java:com.obopay.ws.bulkpayment.zain\"", "");
String replacedStr5 = replacedStr4.replaceAll("java:", "");

            System.out.println("");
            System.out.println("");

             System.out.println("RESPONSE : "+replacedStr5);
             
             System.out.println("");
             System.out.println("");
             
              xmlJSONObj = XML.toJSONObject(replacedStr5);
             
             System.out.println(xmlJSONObj);
             
            
     		
     		
           
            

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
        
        return xmlJSONObj.toString();
    }

    private static SOAPMessage createSOAPRequest(String nickname,
            String username,String password) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://www.obopay.com/xml/bulkpayment/v1";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("v1", serverURI);

       

        // SOAP Body
        
        UUID referencenumber = UUID.randomUUID();
        String reference_id=referencenumber.toString();
        
        SimpleDateFormat now = new SimpleDateFormat("YYYY-MM-dd");
        String timeto  = now.format(new Date());
        
        System.out.println(timeto);
        
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("CheckBalance", "v1");
       SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("username", "v1");
        soapBodyElem6.addTextNode(username);
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("password", "v1");
       soapBodyElem7.addTextNode(password);
        //receiver_msisdn, wallet_operator_code, sending_amount, sender_name, third_party_trans_id, sending_currency_code , d360_service_code, reference
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("nickname", "v1");
        soapBodyElem3.addTextNode(nickname);
        
        
        
     
        

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "d360_book_transaction");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

 
    static public void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]
             {new X509TrustManager() {
               @Override
               public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                   return null;
               }
               @Override
               public void checkClientTrusted(X509Certificate[] certs, String authType) {
               }
               @Override
               public void checkServerTrusted(X509Certificate[] certs, String authType) {
               }
           }
        };
 
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
               System.setProperty("java.net.useSystemProxies", "true");
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }



}
