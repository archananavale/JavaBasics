import java.sql.SQLOutput;

//Variable :storage area in memory
/*Types :
Instance variable
local variable
class or static Variable
Parameters

*/
public class FirstJava {
    int x=20;// here x is instance variable
    int y=30;
    static int z=40;

    public static void main(String[] args) {
        System.out.println("hello Java ");
        if(args.length>0)
            System.out.println(args[0]);
        else
            System.out.println("No runtime Argument passed");

        int a =1;
        System.out.println(a); // a is a local variable : defined inside method

        System.out.println("Instance variable called using object or instace of class");
        FirstJava f=new FirstJava();  // created instance of class
        System.out.println(f.x); // instance variable classed using object of class
        f.y=2;
        System.out.println(f.y);
        //OR : But using below method object of class created twice
        System.out.println(new FirstJava().x);
        System.out.println(new FirstJava().y);

        System.out.println("Static or Class Variable can be called in static methode without creating object of class ");
        System.out.println(FirstJava.z); // static variable r class variable - called using class name without creating instance of class
        //or
        z=z+20;
        System.out.println(z);
        System.out.println(f.z);
        f.z=33;
        System.out.println(f.z);
        System.out.println(FirstJava.z); // there will be one and only instance of static variable and can be modify using any number of object of class

    }

}
