// Write your code here.
package com.example.employee.model;
import javax.persistence.*;

@Entity
@Table(name="employeelist")
public class Employee{
    @Id
    @Column(name="employeeid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int employeeId;
    @Column(name="email")
    private String email;
    @Column(name="employeename")
    private String employeeName;
    @Column(name="department")
    private String department;

    public Employee(){}
    public Employee(int id,String name,String em,String department){
        employeeId=id;
        email=em;
        employeeName=name;
        this.department=department;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public String getEmail(){
        return email;
    }
    public  String getEmployeeName(){
        return employeeName;
    }
    public String getDepartment(){
        return department;
    }
    public void setEmployeeId(int id){
        employeeId=id;
    }
    public void setEmail(String em){
        email=em;
    }
    public void setEmployeeName(String name){
        employeeName=name;
    }
    public void setDepartment(String department){
        this.department=department;
    }
}