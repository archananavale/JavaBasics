public class JavaDataType {
    /*
    Primitive data type
        int, float , double , short , long , bool

    Non Primitive datatype
     string
     */
    /*
    every datatype has range
     */

    public static void main(String[] args) {
        int intRangeCheck=99393983;
        System.out.println("Upper range integer : "+ Integer.MAX_VALUE + "Lower Range of Int : "+ Integer.MIN_VALUE);
        //declare float: use f at the end of number else it consider it as double.
        // Float is preferably used for const or final variable
        final float PI = 3.14f;
        System.out.println("float values "+ PI);

        boolean boolIsTrue = false; // wrong initalising :::>> boolIsTrue = 0;// you have too initialise bool value
        System.out.println("boolean  value "+ boolIsTrue);
        boolIsTrue = true;
        System.out.println("boolean new value "+ boolIsTrue);

    }


}
