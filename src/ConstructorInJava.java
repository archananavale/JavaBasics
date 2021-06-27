
/*
in java
In Java, constructors can be divided into 3 types:

No-Arg Constructor
Parameterized Constructor
Default Constructor
 */
public class ConstructorInJava {
    int i=0;

    public static void main(String[] args) {
        //Default  Constrctor
        ConstructorInJava objClass= new ConstructorInJava();     // When we dont declare any constructor , default construtor called.
        System.out.println("valuer of i :"+objClass.i);
        objClass.i=20;
        System.out.println("valuer of i :"+objClass.i);

        //No arg Constructor
        ConstructorType objConstrctorType = new ConstructorType();
        System.out.println(objConstrctorType.message);

        //argument constructor
        ConstructorType obj3=new ConstructorType("Argument String passed : ");
        System.out.println(obj3);


    }
    public static class ConstructorType{
        String message;
        ConstructorType (){
            this.message="No Argument passed";
        }
        ConstructorType(String msg){
            this.message=msg;
        }

    }

}
