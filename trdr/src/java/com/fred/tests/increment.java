/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fred.tests;

/**
 *
 * @author fred
 */
public class increment {
    public static void main(String[] args) {
        
        increment test1 = new increment();
        test1.sum(0);
        int num = test1.sum(0);
        System.out.println("val" + num );
    }
    
    public int sum( int num )
{
    return ( num * ( num + 1 ) ) / 2 ;
}
    
}
