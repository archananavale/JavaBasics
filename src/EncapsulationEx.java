/*
Encapsulation is nothing but the data hididing in Java
the class object can not be alterd directly from outside of class
it is acihevd using getter and setter methid
 */

import javax.xml.crypto.Data;

class EmployeeE {
     private Integer employeeId;
     private String employeeName;
     private String employeeAddress;
     private String  empDesignation;

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}


public class EncapsulationEx {
    public static void main(String[] args) {
        EmployeeE e= new EmployeeE();
        e.setEmployeeId(12);
        e.setEmployeeName("Ravi");
        e.setEmployeeAddress("str 6 langen ");
        e.setEmpDesignation("chef");

        System.out.println(e.getEmployeeId() +" "+ e.getEmployeeName() +" "+e.getEmployeeAddress() +" "+e.getEmpDesignation());

    }
}
