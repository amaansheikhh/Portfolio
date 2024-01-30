/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeedirectory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Class for adding Employee's to the ObservableList employeeList.
 * In  this class, we have a constructor, Accessor method,
 * an edit, set, add and a get Employee method.
 * 
 * @author amaan
 */
public class EmployeeList {
    
    private ObservableList<Employee> employeeList;
    
    /**
     * No Parameter Constructor for setting the ObservableList 
     * to ObservableArrayList.
     * 
     */
    public EmployeeList(){
        employeeList = FXCollections.observableArrayList();
    }
    
    /**
     * Method for getting the employeeList
     * 
     * @return ObservableList employeeList
     */
    public ObservableList<Employee> getEmployees(){
        return employeeList;
    }
    
    /**
     * 11 Parameter Constructor for editing the Employee's Information. 
     * Assigns the new information to the employee
     * 
     * @param e Employee that the User's is editing
     * @param id Employee's ID
     * @param fName Employee's First Name
     * @param lName Employee's Last Name
     * @param age Employee's Age
     * @param phoneNum Employee's Phone Number
     * @param address Employee's Address
     * @param emailAdd Employee's Email Address
     * @param salary Employee's Salary
     * @param jobPos Employee's Job Position
     * @param deptName Employee's Department Name
     */
    public void edit(Employee e,String id, String fName,String lName,int age,long phoneNum,String address,String emailAdd,double salary,String jobPos,String deptName){
        e.setId(id);
        e.setFirstName(fName);
        e.setLastName(lName);
        e.setAge(age);
        e.setPhoneNumber(phoneNum);
        e.setAddress(address);
        e.setEmail(emailAdd);
        e.setSalary(salary);
        e.setJobPosition(jobPos);
        e.setDeptName(deptName);
    }
    
    /**
     * Mutator method for all employees.
     * 
     * @param employeeList ObservableList of Type Employee
     */
    public void setEmployees(ObservableList<Employee> employeeList){
        this.employeeList = employeeList;
    }
    
    /**
     * Method for adding an Employee
     * 
     * @param e Employee to be added
     */
    public void add(Employee e){
        employeeList.add(e);
    }
    
    /**
     * Accessor method for getting a certain Employee's Index value in 
     * the ObservableList
     * 
     * @param e The Employee that the Index is wanted for
     * @return Index of that Employee in the ObservableList
     */
    public int get(Employee e){
        return employeeList.indexOf(e);
    }
    
}
