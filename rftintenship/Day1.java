// Write a program to reverse a string  without using built in reverse function

import java.util.*;
 
public class Day1{
    public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the word");
    String s = in.next();
    char[] arr = s.toCharArray();
    int i=0;
    int j = arr.length-1;
    while(i<j)
    {
        char temp =arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }
    System.out.println( "Reversed String is: "+new String(arr));

}
}