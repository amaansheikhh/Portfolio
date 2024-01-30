/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeedirectory;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Employee class for creating an employee. Has all of the employee's data
 * fields. Class is made up of getters, setters and constructors.
 *
 * @author amaan
 */
public class Employee {
    
    public String firstName;
    public String lastName;
    public String id;
    public long phoneNumber;
    public int age;
    public String email;
    public double salary;
    public String address;
    public String jobPos;
    public String deptName;
    
    static Alert error = new Alert(AlertType.ERROR);
    
    /**
     * 10 parameter Constructor for creating an employee with the Users info.
     * 
     * @param ID Employee ID 
     * @param fName Employee's First Name
     * @param lName Employee's Last Name
     * @param empAge Employee's Age
     * @param num Employee's Phone Number
     * @param addr Employee's Address
     * @param slry Employee's Salary
     * @param emailAdd Employee's Email Address
     * @param pos Employee's Job Position
     * @param dptNme Department that Employee works in
     */
    Employee(String ID, String fName, String lName, int empAge,
            int num, String addr, double slry, String emailAdd, 
            String pos, String dptNme){
        id=ID;
        firstName = fName;
        lastName = lName;
        age = empAge;
        phoneNumber = num;
        address = addr;
        salary = slry;
        email = emailAdd;
        jobPos = pos;
        deptName = dptNme;
    }
    
    /**
     * No Parameter constructor for creating a employee with default values.
     * 
     */
    Employee(){
        id="";
        firstName ="";
        lastName ="";
        age =0;
        phoneNumber =0;
        address ="";
        salary =0;
        email ="";
        jobPos ="";
        deptName ="";
    }
    
    /**
     * Accessor method for Employee's ID.
     * 
     * @return Employee ID
     */
    public String getId(){
        return id;
    }
    
    /**
     * Mutator method for Employee's ID. Throws Exception and displays Alert if 
     * new ID value is Empty.
     * 
     * @param i New Employee ID
     */
    public void setId(String i){
        if(i.isEmpty()){
            error.setAlertType(AlertType.ERROR);
            error.setContentText("Please enter a value for Employee ID");
            error.show();
            throw new IllegalArgumentException("Please enter a value for Employee ID");
        }else{
            id=i;
        }
    }
    
    /**
     * Accessor method for Employee's First Name.
     * 
     * @return Employee's First Name
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Mutator method for Employee's First Name. Throws Exception and displays 
     * Alert if new First Name value is Empty.
     * 
     * @param fName Employee's First Name
     */
    public void setFirstName(String fName){
        if(fName.isEmpty()){
            error.setAlertType(AlertType.ERROR);
            error.setContentText("Please enter a value for Employee First Name");
            error.show();
        }else{
            firstName=fName;
        }
    }
    
    /**
     * Accessor method for Employee's last name
     * 
     * @return Employee's last name
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Mutator method for Employee's Last Name. Throws Exception and displays 
     * Alert if new Last Name value is Empty.
     * 
     * @param lName Employee's Last Name
     * 
     */
    public void setLastName(String lName){
        if(lName.isEmpty()){
            error.setAlertType(AlertType.ERROR);
            error.setContentText("Please enter a value for Employee Last Name");
            error.show();
        }else{
            lastName=lName;
        }
    }
    
    
    /**
     * Accessor method for Employee's Age.
     * 
     * @return Employee's Age
     */
    public int getAge(){
        return age;
    }
    
    /**
     * Mutator method for Employee's Age.
     * 
     * @param employeeAge New Employee Age 
     */
    public void setAge(int employeeAge){
            age=employeeAge;
    }
    
    /**
     * Accessor method for Employee's Phone Number.
     * 
     * @return Employee's Phone Number
     */
    public long getPhoneNumber(){
        return phoneNumber;
    }
    
    /**
     * Mutator method for Employee's Phone Number. Shows Alert to User if New 
     * Phone number is zero or a negative value.
     * 
     * @param phnNumber Employee's New Phone Number
     */
    public void setPhoneNumber(long phnNumber){
        if(phnNumber == 0){
            error.setContentText("Phone number cannot be 0");
            error.show();
        }else if(phnNumber < 0){
            error.setContentText("Please enter a valid phone number");
            error.show();
        }else{
            phoneNumber=phnNumber;
        }
    }
    
    /**
     * Accessor method for Employee's Address.
     * 
     * @return Employee's Address
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * Mutator method for Employee's Address. Shows an Alert if the new address 
     * variable is empty.
     * 
     * @param add Employee's New Address
     */
    public void setAddress(String add){
        if(add.isEmpty()){
            error.setContentText("Please enter a value for Employee Address");
            error.show();
        }else{
            address=add;
        }
    }
    
    /**
     * Accessor method for Employee's Salary.
     * 
     * @return Employee's Salary
     */
    public double getSalary(){
        return salary;
    }
    
    /**
     * Mutator method for Employee's Salary
     * 
     * @param slry Employee's new Salary
     */
    public void setSalary(double slry){
            salary=slry;
    }
    
    /**
     * Accessor method for Employee's Email Address.
     * 
     * @return Employee's Email Address
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * Mutator method for Employee's Email Address. Shows Alert if new email 
     * address variable is empty.
     * 
     * @param eAdd Employee's New Email Address
     */
    public void setEmail(String eAdd){
        if(eAdd.isEmpty()){
            error.setContentText("Employee email address cannot be empty");
            error.show();
        }else{
            email=eAdd;
        }
    }
    
    /**
     * Accessor method for Employee's Job Position.
     * 
     * @return Employee's Job Position
     */
    public String getJobPos(){
        return jobPos;
    }
    
    /**
     * Mutator method for Employee's Job Position.
     * 
     * @param jPos Employee's new Job Position
     */
    public void setJobPosition(String jPos){
        if(jPos.isEmpty()){
            error.setContentText("Employee job position cannot be empty");
            error.show();
        }else{
            jobPos=jPos;
        }
    }
    
    /**
     * Accessor method for Employee's Department Name.
     * 
     * @return Employee's Department Name
     */
    public String getDeptName(){
        return deptName;
    }
    
    /**
     * Mutator method for Employee's Department Name. Displays Alert if new 
     * Department Name variable is Empty.
     * 
     * @param dName Employee's new Department Name
     */
    public void setDeptName(String dName){
        if(dName.isEmpty()){
            error.setContentText("Employee department name cannot be empty");
            error.show();
        }else{
            deptName=dName;
        }
    }
    
}