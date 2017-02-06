package parallelsort;

   /*
        Java Sort String Array Example
        This Java Sort String Array example shows how to sort an array of Strings
        in Java using Arrays.sort method.
 */
 
import java.util.Arrays;
 
public class SortStringArrayExample {
       
        public static void main(String args[]){
               
                //String array
                String[] strNames = new String[]{"John", "alex", "Chris", "williams", "Mark", "Bob"};
               
                /*
                 * To sort String array in java, use Arrays.sort method.
                 * Sort method is a static method.               *
                 */
               
                //sort String array using sort method
                Arrays.sort(strNames);
               
                System.out.println("String array sorted (case sensitive)");
               
                //print sorted elements
                for(int i=0; i < strNames.length; i++){
                        System.out.println(strNames[i]);
                }
               
                /*
                 * Please note that, by default Arrays.sort method sorts the Strings
                 * in case sensitive manner.
                 *
                 * To sort an array of Strings irrespective of case, use
                 * Arrays.sort(String[] strArray, String.CASE_INSENSITIVE_ORDER) method instead.
                 */
               
                //case insensitive sort
                Arrays.sort(strNames);
               
                System.out.println("String array sorted (case insensitive)");
                //print sorted elements again
                for(int i=0; i < strNames.length; i++){
                        System.out.println(strNames[i]);
                }
 
        }
}
 
/*
Output of above given Java Sort String Array example would be
String array sorted (case sensitive)
Bob
Chris
John
Mark
alex
williams
String array sorted (case insensitive)
Bob
Chris
John
Mark
alex
williams
*/
