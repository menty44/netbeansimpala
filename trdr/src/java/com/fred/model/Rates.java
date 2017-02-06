/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.model;

/**
 *
 * @author fred
 */
public class Rates {
    
    private int id;
    private String ratename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRatename() {
        return ratename;
    }

    public void setRatename(String ratename) {
        this.ratename = ratename;
    }

    public String getRatevalue() {
        return ratevalue;
    }

    public void setRatevalue(String ratevalue) {
        this.ratevalue = ratevalue;
    }
    private String ratevalue;
    
    
}
