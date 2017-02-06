/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelsort;

import java.util.Arrays;

/**
 *
 * @author fred
 */
public class ParallelSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] strings = { "x", "a", "c", "b", "y" };
        Arrays.parallelSort(strings);
        System.out.println(Arrays.toString(strings));   // [a, b, c, x, y]
    }
    
}
