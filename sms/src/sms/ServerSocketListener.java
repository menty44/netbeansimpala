/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author impala
 */
public class ServerSocketListener {
    
    final  static int SERVERSOCKET_PORT = 7777;
    
    public static void main(String[] args) {
        System.out.println("Have started socket listener");
        ServerSocket serverSocket;
        Socket socket = null;
        InputStream is = null;
        
        BufferedInputStream bufferedInputStream = null;
        
        byte[] buffer = new byte[1024];
        
        try {
            serverSocket = new ServerSocket(SERVERSOCKET_PORT);
            
            while (true) { 
                socket = serverSocket.accept();
                System.out.println("Have received the text");
                is = socket.getInputStream();
                bufferedInputStream = new BufferedInputStream(is);
                int bytesRead = 0;
                
                //keep reading till we reach the end of the stream
                //when the end of the stream has reached, -1 is retuned
                
                while ((bytesRead = bufferedInputStream.read(buffer))!= -1) {
                    //construct a string from the bytes read
                    String received = new String(buffer,0,bytesRead);
                    
                    System.out.println("This is the string received" + received);
                    
                }
            }
        } catch (IOException e) {
            System.err.println("IOException while listening on server socket");
            e.printStackTrace();
        }finally{
            
            //close the stream and socket
            try {
                if(bufferedInputStream != null)
                    bufferedInputStream.close();
                
                if(socket != null)
                    socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        
        
    }
    
}
