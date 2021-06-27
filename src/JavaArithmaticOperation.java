import java.util.Scanner;

public class JavaArithmaticOperation {
    public static void main(String[] args) {
        int number1,number2;
        //int additionOfNumber;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter first number");
        number1=sc.nextInt();
        System.out.println("Enter second number");
        number2=sc.nextInt();
        System.out.println("Addition of number ="+ (number1 + number2) );
        System.out.println("substraction of number ="+ (number1 - number2) );
        System.out.println("multiplication of number ="+(number1 * number2));
        System.out.println("mod of number ="+(number1 % number2));
        double divOfNumber;
        divOfNumber = number1 / number2;
        System.out.println("division of number ="+ divOfNumber);
    }
}
