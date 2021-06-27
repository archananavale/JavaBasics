import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.*;


class Employee {
    Integer employeeId;
    String name;
    String city ;
    Integer departmentID;
    public Employee(Integer id,String name,String city,Integer deptId){
        this.employeeId=id;
        this.name=name;
        this.city=city;
        this.departmentID=deptId;
    }

    public Employee() {

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }



}
public class JavaCollections {
    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement preparedStatement;
    CallableStatement callableStatement;
    List<Employee> listOfEmployee= new ArrayList<>();

    public boolean connectDatabase(){
        try {
            //setp1 . driver class
            //TIP : Make sure the the server is started by command : brew services start mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2. connections
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","49archu49");
            //3. statements
            stmt= con.createStatement();
            return true;

        }catch (SQLException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            return false;
        }


    }
    public void addEmployeeToList(ResultSet rs) throws SQLException {
        Employee e= new Employee();
        e.setEmployeeId(rs.getInt(1));
        e.setName(rs.getString(2));
        e.setCity(rs.getString(3));
        e.setDepartmentID(rs.getInt(4));
        listOfEmployee.add(e);
    }
    public void  CollectionObject(){

        //Get data from database and add into employee list
        boolean isConnected =this.connectDatabase();
        if(isConnected){
            //get data into listof employee
            try {
                rs = stmt.executeQuery("Select * from Employee");
                while (rs.next()){
                    listOfEmployee.add(new Employee(rs.getInt(1),rs.getString(2)
                                        ,rs.getString(3),rs.getInt(4)));
                    //Add Employee to list using encapsulation
                    // addEmployeeToList(rs);

                }


            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            printEmployee();
        }
        else
        {
            System.out.println("Unable to coonect database");
        }

    }

    public void printEmployee(){
        //get data from local data
        listOfEmployee.forEach(e-> System.out.println("ID : "+e.getEmployeeId() +" Name: "+e.getName()));
    }

    public static void main(String[] args) {

            JavaCollections obj=new JavaCollections();
            obj.collectionBasics();
       //     obj.CollectionObject();


    }

    public void collectionBasics (){
        List<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(133);
        list.add(45);
        list.add(12);
        System.out.println(list);
        //  list.forEach(i-> System.out.println(i));  //iteration throw list
        //  list.forEach(System.out::println);
        list.remove(0); //incase of INT we can put index
        //   list.remove(133)  //incase of string we can pass objetct
        List<Integer> list2= new ArrayList<>();
        list2.add(56);
        list2.add(90);
        list2.add(88);

        list.addAll(list2); //merging two list
        list.forEach(System.out::println);
/*
    Set
    dosnt save duplicate value and you dint get it in order which is entered in
    Set -> is interface
    Hashset -> is class

    List -> interface
    Arraylist -> is class

 */
        Set<Integer> set=new HashSet<>();
        set.add(123);
        set.add(456);
        set.add(123);
        System.out.println(set);

    //iterate tgrough set
        Iterator<Integer> itr= set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        for (Integer s: set){
            System.out.println("For Loop "+s);
        }
//foreach
        System.out.println("Foreach Consumer ");
        set.forEach(System.out::println);



        /*
    `Treeset
    is set : avaoid duplicate but the record is sorted
     */

        TreeSet <Integer> tset = new TreeSet<>();
        tset.add(678);
        tset.add(69);
        tset.add(90);
        tset.add(987);
        tset.add(90);
        System.out.println("Treeset "+tset);

        /*
        Map
        it si interface . map has key and value pair
         */
        Map<String, String> map= new HashMap<>();
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C","Cap");
        map.put("D","Dog");

        //Iteration
        for (Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey() +" :"+entry.getValue());
        }
        //Funtional Interface
        map.forEach((k,v) -> System.out.println(k+" :"+v));

    }


}
