package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Array {
    public static void displayName (String[] customerName , String message){
        /*
        for (String name: customerName ) {
            System.out.println("Name :"+name);
            //Arrays.stream(customerName).forEach(i->i.toUpperCase());
        }
        */
     //or
        System.out.println("in Methode "+message+"Lsit of customer :" +Arrays.toString(customerName));
    }


    public static void reverseArray(String [] customerName){
      List<String> reverseOrder = Arrays.asList(customerName);
      Collections.reverse(reverseOrder);
       displayName(reverseOrder.toArray(customerName) ,"reverseArray Using Collection ");

      // Arrays.stream(customerName).forEach(str -> str.toUpperCase()); //didnt work
        // displayName(customerName);

    }

    public static Object[] reverseArray2(Object[] customerName){
        System.out.println("in reverser Arr2");
        Arrays.stream(customerName).map(i->customerName[customerName.length-1]);
        System.out.println("Revserse Array using stram"+customerName);
        return IntStream.rangeClosed(0,customerName.length)
                .mapToObj(i-> customerName[customerName.length-1]).toArray();
    }


    public  static  void removeElement1(String[] customerName){
        displayName(customerName,"Before Removing Element");
        for (int i=0;i< customerName.length-1;i++){
            if(customerName[i]!=null && customerName[i].equals("Rick")){
                for(int index=i; index< customerName.length-1;index++){
                    customerName[index]=customerName[index+1];
                    customerName[index+1]=null;
                }
                i--;
            }
        }
        displayName(customerName,"After Removing element");


    }
    public static void removeElemenet(String[]  customerName , String name){
        /*
        Write a traditional for loop that checks each element for the String “Rick”,
        if found in the array, remove it, shift the remaining elements up,
         leaving null at the last position.
        Note: You will fill in the last element of the array with the value of null, with no quotes, after shifting the elements up. You will also have to check that the customerName[i] != null before seeing if the value of customerName[i].equals(“Rick”).
         */
      //  DOITAGAIN

        int i=0;
            for ( i=0;i<customerName.length;i++) {
                if (customerName[i] == name ) {
                   customerName[i]=customerName[i+1];
                    customerName[i+1] = null;

                    System.out.println("i "+i);
                    i=i-1;
                }else
                {
//                   if(customerName[i]==null && (i+1) < customerName.length)
//                       customerName[i]=customerName[i+1];
//                        customerName[i+1]=null;

                }
            }
        displayName(customerName,"Remove Element old");

           }


           public static void removeElementUsingCollection(String[]  customerName , String name){
               //using collections

               List<String > custList= Arrays.asList(customerName);
               List<String> newCustList= new ArrayList<>();
               System.out.println("cust"
                       +custList);

               custList.forEach(name1->{
//            System.out.println(name1);
                   if(name1!=null && !name1.equals(name)){
                       newCustList.add(name1);

                   }

               });
               System.out.println(newCustList+"----");


           }
    public static void main(String[] args) {
        System.out.println("::"+args[0]);
        String[] tokens=args[0].split(",");
        System.out.println(tokens.length);
        String[] customerName= new String[8];
        for (int i=0 ;i<tokens.length; i++)
            customerName[i]=tokens[i];

         /* // or using list
       List<String> customerName = new ArrayList<>(8);
       customerName=  Arrays.stream(tokens).collect(Collectors.toList());
        System.out.println(customerName);
        System.out.println(customerName.size());
        */

        displayName(customerName,"Initial Array");

        /*
        //move the existing elements from indexes 4 and 5 to indices 6 and 7 respectively
         //You can then add the Strings “Rick” and “Jessica” into index 4, and 5, respectively.
         */
        customerName[6]=customerName[4];
        customerName[7]=customerName[5];
        customerName[4]="Rick";
        customerName[5]="Jessica";
        System.out.println("Affter Index changing ");
        displayName(customerName,"After Index Changing ");

      /*
        Write a method to reverse the elements in the array.
       */

        reverseArray(customerName);

        /*
        Write another method to reverse the elements in the customerNames array without creating a new array.
         */
        reverseArray2(customerName);

/*
        removing string element

 */
//        removeElemenet(customerName,"Rick");
        removeElementUsingCollection(customerName,"Rick");
//        removeElement1(customerName);



    }
}
/*

In IntelliJ, navigate to the Labs package and create another package named Lab8.

Create a class in the Lab8 package called Array.java with a main method that will do the following:

Input at the command line the following String: “Beth,Rick,Jerry,Rick,Summer,Morty” (DON”T type the “ ”.)

i.  Step 1: Go to Run à Edit Configurations















Step 2: Go to Application, you might need to use the + key to find it, and add the program arguments needed.























This will allow that string to be entered into the program when it is run. This string will be stored in the String[] args array in the 0 position.

Use this inputted String and the method .split(",") to create an array of String objects called tokens. The actual code you will use is below:

String[] tokens = args[0].split(",");

Create another String array called customerName. This array will have eight String objects.
Create a for loop to copy each element in the tokens array into the customerName array. At this point the last two positions in the tokens array will be null.




Write a method, displayNames(), to display the names within the array. You will pass the String array, customerName to the method. The method will then use a foreach loop (aka an enhanced for loop) to display the array of names so that each name is on a separate line. End your output with a blank line. Here is the method header:

public static void displayNames(String[] names)

Answer the following questions:

What is displayed for the last two array elements?

Why is it that value?

Move the existing elements from indexes 4 and 5 to indices 6 and 7 respectively. You can then add the Strings “Rick” and “Jessica” into index 4, and 5, respectively. The array should then contain the following elements in this order:




g.	Call the displayNames() method again to output the customerNames array.
Write a method to reverse the elements in the array. You will pass in the customerName array to this method and will return a new array with the elements reversed. Here is the method header:

public static String[] reverseNames(String[] names)




Answer the following question:

•  Is there a way to simplify this method so that you do not need to return an array?

Call the displayNames() method to output the names in the array that was returned in Step h.

Write another method to reverse the elements in the customerNames array without creating a new array. You will pass in the customerName array to this method and will switch the elements of this array around so that the elements reversed. Hint: Think about this switching. How many switches do you need to make? Do you need to walk through the entire array? Here is the method header:

public static void reverseNames2(String[] names)




Call the displayNames() method again to output the customerNames array.

Write a traditional for loop that checks each element for the String “Rick”, if found in the array, remove it, shift the remaining elements up, leaving null at the last position.

Note: You will fill in the last element of the array with the value of null, with no quotes, after shifting the elements up. You will also have to check that the customerName[i] != null before seeing if the value of customerName[i].equals(“Rick”).

Call the displayNames() method again to output the customerNames array.

Answer these questions:

Are both instances of “Rick” removed correctly from the array?

Why or why not? Can you explain what you observe in your code? Why do you still have one Rick?

 */