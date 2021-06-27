import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        int number ;
        boolean isPrime=false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        number=sc.nextInt();
        if (number==1 || number==0)
            System.out.println(number+ "  is not Primary Number");
        else
        {
            for (int i=2; i<=(number/2); i++)
            {
                if(number%i==0)
                {
                    System.out.println(number+ "  is  Primary Number");
                    isPrime=true;
                    break;
                }
            }
        }
        if (isPrime==false)
            System.out.println(number+ "  is not Primary Number");

    }

}
