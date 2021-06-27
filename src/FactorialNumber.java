import java.util.Scanner;

public class FactorialNumber {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int number,factorial=1;

        System.out.println("Enter number ");
        number= sc.nextInt();

        for (int i=1;i<=number;i++) {
            factorial = factorial * i;
        }
        System.out.println("Factoral of "+ number +" is : "+factorial);
    }

}
