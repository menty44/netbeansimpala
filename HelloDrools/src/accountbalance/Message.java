/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountbalance;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 *
 * @author impala
 */
public class Message {
    
    private String type;
    private String msgtext;
    
    private int type1;
    private int msgtext1;
 
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    public int getType1(){
        return type1;
    }
 
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    public void setType1(int type1) {
        
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

    void setType(int number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setType(Message number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
