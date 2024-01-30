/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package employeedirectory;

import static employeedirectory.HomePageController.employeeListModel;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Controls all of the User interactions with the AddEmployee.fxml GUI
 * 
 * FXML Controller class
 *
 * @author amaan
 */
public class AddEmployeeController implements Initializable {

    /** 
     * In this Class we have a RandomAccessFile in which we Add Employees to.
     * EmployeeList in which we use to display records to the TableView add,
     * edit and delete records.
     * 
     * Initializes the controller class.
     */
    private static RandomAccessFile file;
    private final int EMPLOYEE_SIZE = 38;
    private final int NAME_SIZE = 38;
    
    private Stage stage;
    private Parent root;
    private Scene scene; 
    
    @FXML
    private TextField txtId,txtFName,txtLName,txtAge,txtPhoneNum,txtAddress,txtEmailAdd,txtSalary,txtJobPos,txtDeptName;
    @FXML
    private Button btnSubmit,btnHome;
    
    private static EmployeeList employeeList = new EmployeeList();
    
    /**
     * Function to add an employee to the ObservableList and to the RandomAccessFile
     * Method is ran when the "Add" button is pressed.
     * 
     * @param event on "Add" button press
     * @throws IOException For accessing the RandomAccessFile
     */
    @FXML
    public void addEmployee(ActionEvent event) throws IOException{
        Employee e = new Employee();
        try{
        int employeeAge = Integer.parseInt(txtAge.getText());
        long employeeNum = Long.parseLong(txtPhoneNum.getText());
        double employeeSal=Double.parseDouble(txtSalary.getText());
        
        e.setId(txtId.getText());
        e.setFirstName(txtFName.getText());
        e.setLastName(txtLName.getText());
        e.setAge(employeeAge);
        e.setPhoneNumber(employeeNum);
        e.setAddress(txtAddress.getText());
        e.setSalary(employeeSal);
        e.setEmail(txtEmailAdd.getText());
        e.setJobPosition(txtJobPos.getText());
        e.setDeptName(txtDeptName.getText());
        employeeListModel.add(e);
        }catch(NumberFormatException s){
            System.out.println("Fields cannot be empty!");
        }
        
        try{
         file.seek(file.length());
         String firstName = txtFName.getText();
         file.writeChars(e.getId());
         if(e.getFirstName().length() > NAME_SIZE){
             firstName = firstName.substring(0,NAME_SIZE);
             e.setFirstName(firstName);
         }else{
             int numSpaces =  NAME_SIZE-e.getFirstName().length();
             for(int i=0;i<numSpaces;i++){
                 firstName+="";
             }
             e.setFirstName(firstName);
         }
         file.writeChars(e.getFirstName());
         file.writeChars(e.getId());
         clearTextFields();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }        
    }
    
    /**
     * Method for clearing all of the Text values for each TextField.
     * 
     */
    public void clearTextFields(){
        txtId.clear();
        txtFName.clear();
        txtLName.clear();
        txtAge.clear();
        txtPhoneNum.clear();
        txtAddress.clear();
        txtSalary.clear();
        txtEmailAdd.clear();
        txtJobPos.clear();
        txtDeptName.clear();
    }   
    
    /**
     * Getter for Private EmployeeList
     * 
     * @return EmployeeList employeeList
     */
    public static EmployeeList getEmpList(){
        return employeeList;
    }
    
    /**
     * Method for showing HomePage.fxml. Ran when the User presses the "Home"
     * button in the AddEmployee.fxml
     * 
     * @param event When user presses "Home" button.
     * @throws IOException For getting the HomePage.FXML file
     */
    public void showHomePage(ActionEvent event)throws IOException{
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage.setTitle("Home Page");
        stage.getIcons().add(new Image("./employeeDirectory/logo.png"));
        scene = new Scene(root1);
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }
    
    /**
     * Getter for the Private RandomAccessFile
     * 
     * @return RandomAccessFile
     */
    public static RandomAccessFile getFile() {
        return file;
    }
    
    /**
     * Initialize method creates the RandomAccessFile
     * 
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            file = new RandomAccessFile(new File("Employees.dat"),"rw");
        } catch (FileNotFoundException ex) {
            System.out.println("Error ocurred while creating RandomAccessFile");
        }        
    }    
    
}