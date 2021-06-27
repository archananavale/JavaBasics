import java.sql.*;
import java.util.Scanner;

public class JdbcConnectExample {
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;
    public JdbcConnectExample()  {
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
        }

    }
    public void printData ()  {
        //4. Getting data
        try {
            rs = stmt.executeQuery("Select * from student");
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getInt(4));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void insertDataMysql(int id,String name,String city,int age) throws SQLException {
        // Insertion

        String sqlInsert= "Insert into Student (studentId,name,city,age) values (?,?,?,?)";
        preparedStatement=   con.prepareStatement(sqlInsert);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,city);
        preparedStatement.setInt(4,age);
        int isInserted= preparedStatement.executeUpdate();

        System.out.println("After Data Inserted ");
        this.printData();
    }
    public void updateDataMysql(int id) throws SQLException {
        //find the data for ID
        rs=stmt.executeQuery("Select * from student where studentId ="+id);
        if (!rs.next())
            System.out.println("No Data Found for ID : "+ id);
        else {
            Scanner sc= new Scanner(System.in);
            System.out.println("Enetr New name , city and age  : ");
            String name = sc.next();
            String city = sc.next();
            Integer age = sc.nextInt();
            String sqlUpdate = "UPDATE student SET name=? ,city =?, age=? Where studentId=?";
            preparedStatement = con.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, city);
            preparedStatement.setInt(3, age  );

            preparedStatement.setInt(4, id);

            int isUpdate = preparedStatement.executeUpdate();

            System.out.println("After Data updated");
            this.printData();
        }
    }
    public void deleteDataMysql(int id)throws  SQLException{
        String sqlDelete="DELETE FROM student where studentId=?";
        preparedStatement = con.prepareStatement(sqlDelete);
        preparedStatement.setInt(1,id);
        int isDeleted = preparedStatement.executeUpdate();
        if(isDeleted==1) {
            System.out.println("After Data Deleted");
            this.printData();
        }
        else
             System.out.println("Data not found");


    }

    public void callCallableStatementEx() throws SQLException {
         //callable statement use to call procedure from data base
        callableStatement=con.prepareCall("call getEmployeebyDepartment (?)");

        callableStatement.setString(1,"HR");
        callableStatement.execute();
        rs=callableStatement.getResultSet();
        while (rs.next())
        {
            System.out.println(rs.getString(1) +" "+rs.getString(2)+" "+rs.getInt(3)+ " "+rs.getString(4));
        }
        System.out.println("success");

    }
    public void  callCallableStatementPintStudentEx()throws SQLException{
        callableStatement=con.prepareCall("call printALlStudent()");
        callableStatement.execute();
        rs=callableStatement.getResultSet();

        System.out.println("success");
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int id;
        JdbcConnectExample objClass = new JdbcConnectExample();
        System.out.println("Enter your choice : \n 1. Print Data \n2. Insert Data \n 3. Update Data \n 4.Delete Data \n 5. Callable Statement");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice)
        {
            case 1:
                objClass.printData(); //printing data:
                break;
            case 2:
                //INSERT QUERRy
                System.out.println("Enter ID :");
                 id=sc.nextInt();
                System.out.println("Enter Name:");
                String name= sc.next();
                System.out.println("Enter City:");
                String city= sc.next();
                System.out.println("Enter Age:");
                int age= sc.nextInt();

                objClass.insertDataMysql(id,name,city,age);
                break;

            case 3:      //update query
                System.out.println("Enter ID you would like to update:");
                 id=sc.nextInt();
                objClass.updateDataMysql(id);
                break;
            case 4:
                // Delete Querry
                System.out.println("Enter ID you would like to update:");
                id=sc.nextInt();
                objClass.deleteDataMysql(id);
                break;

            case 5:
                // callable statement
                objClass.callCallableStatementEx();
                break;
            case 6 :
                //callable stmt to print student data
                objClass.callCallableStatementPintStudentEx();
                break ;
            default:
                System.out.println("Wrong Choice provided");
        }
    }
}
