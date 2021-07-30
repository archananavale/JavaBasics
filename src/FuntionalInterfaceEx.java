import java.util.Collections;
import java.util.function.BiFunction;
import java.util.function.Function;
interface  InterfaceEx{
    void function_Addition(int a,int b); //abstact funtion
    int fun_substraction(int a, int b); // abstract fun
    /*
    //Interface methodes have default keyword
     */
    default void defaultMethode(String str){
        System.out.println("Default methode"+ str);
    }

    default int funStringLenghts(String str){
        return str.length();
    }

}
@java.lang.FunctionalInterface   // good practice to mention @functionala interface. in team of developer to avaoid comnflicts
interface FunctionalInterfaceEx1{
    void funEx(int a, int b);

//    void  funex1(int a);   // @functional interface cant have two abstract methode . but it can have solid methods\\\\
   default void funPrint (int a){
        System.out.println("At fucntional interface print : "+a);
    }
}
public class FuntionalInterfaceEx {



    public static void main(String[] args) {
        Function<String,Integer> funLenght=str->str.length();
        System.out.println("Lenght od string:"+funLenght.apply("siddhant"));

        Function<Integer,String> funToStr = i ->i.toString().concat("XYZ");
        System.out.println("int to String :"+funToStr.apply(78));
// creating obj of interface class
        InterfaceEx obj=new InterfaceEx() {
            @Override
            public void function_Addition(int a, int b) {
                System.out.println("addtion is "+ (a+b));
            }

            @Override
            public int fun_substraction(int a, int b) {
                return a-b;
            }
        };

        obj.defaultMethode("check one");
        System.out.println("sub is "+ obj.fun_substraction(34,23));
        obj.function_Addition(232,23);
        System.out.println("String Lenght is "+obj.funStringLenghts("siddhant"));
//

        FunctionalInterfaceEx1 obj3=(num1,num2)-> System.out.println("Addion is "+ (num1+num2));
        obj3.funEx(3,4);
        obj3.funPrint(2); // thsi is solid method
        //OR another way to creat e object
        FunctionalInterfaceEx1 obj2 =  new FunctionalInterfaceEx1() {
            @Override
            public void funEx(int a, int b) {
                System.out.println("substraction is "+(a-b)); // as per requirement the body written
            }

            @Override
            public void funPrint(int a) {

            }
        };
        obj2.funEx(46646,3455677);


 //BIfuntional
        BiFunction<String,String,String> funStrConcat= (str1,str2)->str1.concat(" "+str2);
        System.out.println("Full Name is : "+ funStrConcat.apply("Firstname" ,"lastnane"));



    }
}
