import java.util.Scanner;

public class MethodAndSwitch {
    int num1, num2;

    MethodAndSwitch(){
        System.out.println("default Constructor called");
    }
    MethodAndSwitch(int num1, int num2) // Parameter constrctor
    {
        this.num1=num1;
        this.num2=num2;
    }


    public void addition (int numb1 , int number2)
    {
        System.out.println("Addtion is " + (numb1 + number2));

    }

    public void subtraction(){
        System.out.println("Answer is :" + (num1-num2));
    }


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        MethodAndSwitch objMethod= new MethodAndSwitch(); //called default Constructor

        int number1 ;
        int number2;
        System.out.println("Enter Number 1 : ");
        number1= sc.nextInt();

        System.out.println("Enter Number 2 : ");
        number2= sc.nextInt();

        MethodAndSwitch objMethodwithConst= new MethodAndSwitch(number1,number2); //called Parameter Constrcutor
        System.out.println("Enter your choice from Following : /n 1. Addition /n 2. Substraction /n 3. multiplcation ");
        int choice = sc.nextInt();

        switch (choice)
        {
            case 1:
                objMethod.addition(number1, number2);
                break;
            case 2:
                objMethodwithConst.subtraction();
                break;
            case 3:
                break;
            default:
                System.out.println("Entered wrong choice");

        }

    }
}
