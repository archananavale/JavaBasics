
/*
JDBC connections
imp 4 stepss :
1. Driver class : Class is interface and Forname is the static methode
2. Connection : using connection interface , connect the desired database
3. Statemnet : here statemnet also interface
4. getting data : getting data using resultset
 */

import java.sql.*;
import java.util.Collections;

public class JdbcConnect {

    public void printData (ResultSet rs) throws SQLException {

        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getInt(4));
        }
    }

    public void insertDataMysql(Connection con,Statement stmt) throws SQLException {
        // Insertion
        String sqlInsert= "Insert into Student (studentId,name,city,age) values (?,?,?,?)";
        PreparedStatement stmtInsert=   con.prepareStatement(sqlInsert);
        stmtInsert.setInt(1,5);
        stmtInsert.setString(2,"Suraj");
        stmtInsert.setString(3,"Solapur");
        stmtInsert.setInt(4,45);
        int isInserted= stmtInsert.executeUpdate();

        System.out.println("After Data Inserted ");
        ResultSet rs=stmt.executeQuery("select * from student");
        this.printData(rs);
    }
    public void updateDataMysql(Connection con, Statement stmt) throws SQLException {
        String sqlUpdate ="UPDATE student SET name=? Where studentId=?";
        PreparedStatement stmtUpdate=con.prepareStatement(sqlUpdate);
        stmtUpdate.setString(1,"simar");
        stmtUpdate.setInt(2,5);

        int isUpdate=stmtUpdate.executeUpdate();

        System.out.println("After Data updated");
        ResultSet rs =stmt.executeQuery("select * from student");
        this.printData(rs);

    }
    public void deleteDataMysql(Connection con, Statement stmt)throws  SQLException{
        String sqlDelete="DELETE FROM student where studentId=?";
        PreparedStatement stmtDelete = con.prepareStatement(sqlDelete);
        stmtDelete.setInt(1,4);
        int isDeleted = stmtDelete.executeUpdate();
        System.out.println("After Data Deleted");
        ResultSet rs= stmt.executeQuery("Select * from Student");
        this.printData(rs);


    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JdbcConnect objClass = new JdbcConnect();
        //setp1 . driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. connections
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","49archu49");
        //3. statements
        Statement stmt= con.createStatement();
       //4. Getting data
        ResultSet rs=stmt.executeQuery("Select * from student");

        objClass.printData(rs); //printing data:
        //INSERT QUERRY
      //  objClass.insertDataMysql(con,stmt);

        //update query
        objClass.updateDataMysql(con,stmt);
        // Delete Querry
        objClass.deleteDataMysql(con,stmt);

    }
}
