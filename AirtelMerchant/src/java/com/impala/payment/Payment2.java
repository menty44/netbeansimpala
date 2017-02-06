/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impala.payment;

/**
 *
 * @author mulikevs
 */
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.StringReader;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.json.XML;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



/**
 * @author mulikevs
 *
 */
public class Payment2 {
	
	 /**
     * Starting point for the SAAJ - SOAP Client Testing
     */
    public String Airtelpayout(String referenceid,String customermsisdn,String nickname,
            String amount,String batchref,String username,String password,String narrative) {
        
        org.json.JSONObject xmlJSONObj = null;
        try {
            // Create SOAP Connection
        	String resp = "";
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            
            String url = "https://41.223.58.41:8446/MerchantPaymentService.asmx";
            doTrustToCertificates();
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest( referenceid, customermsisdn, nickname,
             amount, batchref, username, password, narrative), url);
            
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
             
              
            
     		System.out.println(resp);
     		
           
            

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
        
        return "";
    }

    private static SOAPMessage createSOAPRequest(String referenceid,String customermsisdn,String nickname,
            String amount,String batchref,String username,String password,String narrative) throws Exception {
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
        SOAPElement soapBodyElem = soapBody.addChildElement("TrxPayment", "v1");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("referenceid", "v1");
        soapBodyElem1.addTextNode(referenceid);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("customermsisdn", "v1");
        soapBodyElem2.addTextNode(customermsisdn);
        //receiver_msisdn, wallet_operator_code, sending_amount, sender_name, third_party_trans_id, sending_currency_code , d360_service_code, reference
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("nickname", "v1");
        soapBodyElem3.addTextNode(nickname);
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("amount", "v1");
        soapBodyElem4.addTextNode(amount);
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("batchref", "v1");
        soapBodyElem5.addTextNode(batchref);
        SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("username", "v1");
        soapBodyElem6.addTextNode(username);
        SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("password", "v1");
        soapBodyElem7.addTextNode(password);
        SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("narrative", "v1");
        soapBodyElem8.addTextNode(narrative);
     
        

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
