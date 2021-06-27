import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class ExceptionHandling extends  Exception{
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;
    Scanner sc;

    public ExceptionHandling(){
        try {
            //setp1 . driver class
            //TIP : Make sure the the server is started by command : brew services start mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. connections
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","49archu49");
            //3. statements
            stmt= con.createStatement();

        }catch (SQLException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Data Base not connected !! "); //Write final logic here
            //
        }
    }
    public ExceptionHandling(String errorMessage) {
        super (errorMessage);
    }

    public void insertNewEmployeeRecord(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter employee ID :");
        int id=sc.nextInt();
        System.out.println("Enter Name:");
        String name= sc.next();
        System.out.println("Enter City:");
        String city= sc.next();

        System.out.println("Enter Age:");
        int age= sc.nextInt();
        if (age < 18) {
            throw new ArithmeticException("Access denied - You must be at least 18 years old.");

        }
        else {
            System.out.println("Access granted - You are old enough!");
        }
        System.out.println("enter Department ID ");
        int dept_id=sc.nextInt();
        // Insertion
    try {
    String sqlInsert = "Insert into employee (employeeID,name,city,dept_id) values (?,?,?,?)";
    preparedStatement = con.prepareStatement(sqlInsert);
    preparedStatement.setInt(1, id);
    preparedStatement.setString(2, name);
    preparedStatement.setString(3, city);
    preparedStatement.setInt(4,dept_id );
    int isInserted = preparedStatement.executeUpdate();

    System.out.println("After Data Inserted ");
    }   catch (SQLException e){

    }finally {

    }

    }

    public  void showEmployeeDetails(){

        try {
            rs=stmt.executeQuery("Select * from employee");
            while (rs.next()) {
                System.out.println( "- - - - - - - - - - - - - ");
                System.out.println(rs.getInt(1) + " --- "+rs.getString(2)+" --- "+rs.getString(3)+" --- "+rs.getInt(4));

            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }



    public static void main(String[] args) {
        int a, b ,choice;
        ExceptionHandling objExeption = new ExceptionHandling();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter choice : \n 1. show Employee Record  \n 2.Insert Employee Data \n. 3. ");
        choice=sc.nextInt();
        switch (choice){
            case 1:
                objExeption.showEmployeeDetails();
                break;
            case 2:
                objExeption.insertNewEmployeeRecord();
                break;
            default:
                break;

        }

    }
}
