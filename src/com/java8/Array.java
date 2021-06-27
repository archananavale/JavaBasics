package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Array {
    public static void displayName (String[] customerName){
        /*
        for (String name: customerName ) {
            System.out.println("Name :"+name);
            //Arrays.stream(customerName).forEach(i->i.toUpperCase());
        }
        */
     //or
        System.out.println("Lsit of customer :" +Arrays.toString(customerName));
    }


    public static void reverseArray(String [] customerName){
      List<String> reverseOrder = Arrays.asList(customerName);
      Collections.reverse(reverseOrder);
        System.out.println("After Reverse");
       displayName(reverseOrder.toArray(customerName));

      // Arrays.stream(customerName).forEach(str -> str.toUpperCase()); //didnt work,
       // displayName(customerName);

        /*
        //dint work
        String[] reverseUsingStream=(String[]) IntStream.rangeClosed(0,customerName.length)
                        .mapToObj(i-> customerName[customerName.length-1]).toArray();
        displayName(reverseUsingStream);
       */
    }

    public static void reverseArray2(String[] customerName){
        System.out.println("revrese 2");

        displayName(customerName);
    }
    /*
    public static Object[] reverseArray2(Object[] customerName){
        System.out.println("in reverser Arr2");
        Arrays.stream(customerName).map(i->customerName[customerName.length-1]);
        System.out.println(customerName);
        return IntStream.rangeClosed(0,customerName.length)
                .mapToObj(i-> customerName[customerName.length-1]).toArray();
    }
    */

    public static void removeElemenet(String[]  customerName , String name){
        /*
        Write a traditional for loop that checks each element for the String “Rick”,
        if found in the array, remove it, shift the remaining elements up,
         leaving null at the last position.
        Note: You will fill in the last element of the array with the value of null, with no quotes, after shifting the elements up. You will also have to check that the customerName[i] != null before seeing if the value of customerName[i].equals(“Rick”).
         */
      //  DOITAGAIN
        System.out.println("removing element");
        for (int i=0 ;i< customerName.length;i++){
            if(customerName[i].equals(name)) {
               // customerName[i]=null;
               for (int j=i+1;j< customerName.length-i;j++)
                {
                    customerName[i]=customerName[j];


                }
            }
        }
        displayName(customerName);
        //



    }
    public static void main(String[] args) {
        System.out.println("::"+args[0]);
        String[] tokens=args[0].split(",");
        System.out.println(tokens.length);
        String[] customerName= new String[8];
        for (int i=0 ;i<tokens.length; i++)
            customerName[i]=tokens[i];

       System.out.println("Initial Array e");
          displayName(customerName);

        /*
        //move the existing elements from indexes 4 and 5 to indices 6 and 7 respectively
         //You can then add the Strings “Rick” and “Jessica” into index 4, and 5, respectively.
         */
        customerName[6]=customerName[4];
        customerName[7]=customerName[5];
        customerName[4]="Rick";
        customerName[5]="Jessica";
        System.out.println("Affter Index changing ");
        displayName(customerName);

      /*
        Write a method to reverse the elements in the array.
       */

        reverseArray(customerName);

        /*
        Write another method to reverse the elements in the customerNames array without creating a new array.
         */
        reverseArray2(customerName);

/*
        remoning string elelment

 */
            removeElemenet (customerName ,"Rick");
      /*
       List<String> customerName = new ArrayList<>(8);
       customerName=  Arrays.stream(tokens).collect(Collectors.toList());
        System.out.println(customerName);
        System.out.println(customerName.size());
        */

    }
}
