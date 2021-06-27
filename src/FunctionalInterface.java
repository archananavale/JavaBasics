/*
Types of Functional Interface

 */


import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterface {
    public static void main(String[] args) {
        Function<String,Integer> f1= str->str.length();  
        Integer i =f1.apply("Archana");
        System.out.println("value of i :"+ i);

        BiFunction<Integer,Integer,Integer> f2= (a,b) -> a+b;
        Integer i2=f2.apply(4,5);
        System.out.println("Addition of two numbers : " +i2);

        BiFunction <String,String,String> funConcatString=(str1,str2)->str1.concat(str2);
        String strConcat= funConcatString.apply("Archana","navale");
        System.out.println(" My name is "+ strConcat );
/*
funtion chaining
 */
        Function<String,Integer> f3= str->str.length();
        Function<Integer,Integer> f4=value->value*10;
        Integer i3=f3.andThen(f4).apply("Archana");
        System.out.println("Value of i3 :"+i3);

        BinaryOperator<Integer> f5=(a,b)->a+b;
        Integer i4=f5.apply(3,5);
        System.out.println("value of i4 is : "+i4);

        UnaryOperator<Integer> f6=value ->value+11;
        Integer i5= f6.apply(23);
        System.out.println("Value of i5 :"+ i5);

        List<Integer> list= Arrays.asList(12,34,5,6,78,9,6);
        Predicate<Integer> p=val->val>10;
        List<Integer> list1=list.stream().filter(p).collect(Collectors.toList());
        System.out.println("List 1 :"+list1);


        BiPredicate<String,Integer> f7=(str,value)->{
            return str.length()==value;
        };
        Boolean flag=f7.test("Archana",7);
        System.out.println(flag);

        Consumer<Integer> c= value-> System.out.println("Value is :"+ value);
        c.accept(45);

        BiConsumer<Integer,Integer>  cBi= (value1,value2 )-> System.out.println("Addition is :"+(value1+value2));
        cBi.accept(20,22);

        List<String> list3= Arrays.asList("sidha","ram","shyam","sitra");
  //traDITIONAL WAY OF PROGRMING
        System.out.println("-------: for loop -------");
      for(int j=0;j<list3.size();j++)
        {
            System.out.println(list3.get(j));
        }

        //OR
        System.out.println("-------:Using For Loop  -------");
        for(String str:list3){
            System.out.println(str);
        }

        // implimentation Java 8 : lambda operator
        System.out.println("-------: lambda operator -------");
       list3.forEach(strVal-> System.out.println(strVal));

        list3.forEach(strValue2->
            System.out.println(strValue2.toUpperCase()));

        //sort
        System.out.println("-------SORTING -------");
        List<String> list4=
                list3.stream().map(strValu3->strValu3.toUpperCase()).sorted().collect(Collectors.toList());
        list4.forEach(strVal4-> System.out.println(strVal4));



    }

}
