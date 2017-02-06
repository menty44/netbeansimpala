/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellodrools;

/**
 *
 * @author impala
 */
public class Message {
    
    private String type;
    private String msgtext;
 
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
 
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
 
    /**
     * @return the msgtext
     */
    public String getMsgtext() {
        return msgtext;
    }
 
    /**
     * @param msgtext the msgtext to set
     */
    public void setMsgtext(String msgtext) {
        this.msgtext = msgtext;
    }
    
}
