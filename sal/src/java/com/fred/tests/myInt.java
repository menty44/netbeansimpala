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
public class myInt {
    public int number;

	public myInt() {
	  number = 22;
	}

	public myInt(int i) {
	  number = i;
	}

	public void incr() {
		number++;
	}

	public boolean maxInt() {
	  return (number >= 27);
	}

	public void printInt() {
	  System.out.println(number);
	}
    
}
