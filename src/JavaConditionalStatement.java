import java.util.Scanner;

public class JavaConditionalStatement {
    public static void main(String[] args) {
        int intMarks;
        Scanner sc =new Scanner(System.in); //scanner is used to take user input
        System.out.println("Enter Marks :");
        intMarks= sc.nextInt();
        if (intMarks>=90)
            System.out.println("Grade a ");
        else if (intMarks>=70)
            System.out.println("Grade B");
        else if (intMarks>=50)
            System.out.println("Grade C ");
        else if(intMarks>=35)
            System.out.println("Grade D");
        else
            System.out.println("Failed");

        System.out.println("values "+(3/0));

        System.out.println("hello");
    }
}
