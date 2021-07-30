
public class JavaInnerClasses {
    int x=0;

class innerClass{
    int i=10;
}

//Static inner class
    static class StaticInnerClass{
    String str="inside Static inner class";
}
//private inner class :  can not acces outside of class
    private class PrivateInnerclass{
    int y =200;
    void display(){
        System.out.println("value of x"+x+" value of y :"+y);
    }


}
     void methodOuterClass (){
        PrivateInnerclass obj= new PrivateInnerclass();
        obj.display();
    }

}

class MainJavaInnerClasses{
    public static void main(String[] args) {
        JavaInnerClasses objOuterClass=new JavaInnerClasses();
        JavaInnerClasses.innerClass objInner= objOuterClass.new innerClass(); //How to create object of nested inner class
        System.out.println("Outer class val of x:"+objOuterClass.x +"\n Inner class val of i"+objInner.i);

        // to create static inner class
//        no need to create outerclass objexc
        JavaInnerClasses.StaticInnerClass objStatic= new JavaInnerClasses.StaticInnerClass();
        System.out.println("Static "+ objStatic.str);
        objOuterClass.methodOuterClass();

        //
    }
}