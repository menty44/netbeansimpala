package uba_api;

import org.json.JSONException;
import org.json.JSONObject;

public class TestGetBalance {

    private static Balance balance;
    
    public static void main(String[] args) throws JSONException {
        // TODO Auto-generated method stub
        
              balance = new Balance();
                
                
                String request =balance.GetBalance();
                
                JSONObject myObject = new JSONObject(request);
                System.out.println("nop"+request);
                
                System.out.println("status: " + myObject.getInt("Status"));
                System.out.println("message: " + myObject.getString("Response"));
               

                
        
        
    }

}