/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package employeedirectory;

import static employeedirectory.HomePageController.showMoreInfoEmployee;
import static employeedirectory.HomePageController.employeeListModel;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * MoreInfo.FXML Controller class for dealing with all of the User interactions 
 * with the FXML page.
 *
 * @author amaan
 */
public class MoreInfoController implements Initializable {
    
    @FXML
    private TextField txtId,txtFName,txtLName,txtAge,txtPhoneNum,txtAddress,txtEmailAdd,txtSalary,txtJobPos,txtDeptName;
    
    @FXML
    private Button btnHome,btnDelete,btnEdit,btnSaveEdit;
    
    Parent root1;
    Stage stage;
    Scene scene;
    
    private final int EMPLOYEE_SIZE = 38;
    private final int NAME_SIZE = 38;
    
    /**
     * Shows the Home Page when the User presses the "Home" button in 
     * the MoreInfo.fxml.
     * 
     * @param event On "Home" button press
     * @throws IOException Exception for if HomePage.fxml is not able to be loaded
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
     * Clears All TextFields.
     */
    public void clearTxtFlds(){
        txtId.setText("");
        txtFName.setText("");
        txtLName.setText("");
        txtAge.setText("");
        txtPhoneNum.setText("");
        txtAddress.setText("");
        txtEmailAdd.setText("");
        txtSalary.setText("");
        txtJobPos.setText("");
        txtDeptName.setText("");
    }
    
    /**
     * Sets all of the TextFields data to an Employee
     * 
     * @param e 
     */
    public void setFieldsToEmpData(Employee e){
        txtId.setText(e.getId());
        txtFName.setText(e.getFirstName());
        txtLName.setText(e.getLastName());
        txtAge.setText(Integer.toString(e.getAge()));
        txtPhoneNum.setText(Long.toString(e.getPhoneNumber()));
        txtAddress.setText(e.getAddress());
        txtEmailAdd.setText(e.getEmail());
        txtSalary.setText(Double.toString(e.getSalary()));
        txtJobPos.setText(e.getJobPos());
        txtDeptName.setText(e.getDeptName());
    }
    
    /**
     * Sets all of the TextFields to Editable when the "Edit" button is pressed
     * so the user can edit the fields.
     * 
     */
    public void setAllFieldsEditable(){
        txtId.setEditable(true);
        txtFName.setEditable(true);
        txtLName.setEditable(true);
        txtAge.setEditable(true);
        txtPhoneNum.setEditable(true);
        txtAddress.setEditable(true);
        txtEmailAdd.setEditable(true);
        txtSalary.setEditable(true);
        txtJobPos.setEditable(true);
        txtDeptName.setEditable(true);
        btnEdit.setText("Cancel Edit");
    }
    
    /**
     * Sets all of the TextFields to not editable when the "Cancel Edit" button
     * is pressed to stop editing.
     * 
     */
    public void setAllFieldsNotEditable(){
        txtId.setEditable(false);
        txtFName.setEditable(false);
        txtLName.setEditable(false);
        txtAge.setEditable(false);
        txtPhoneNum.setEditable(false);
        txtAddress.setEditable(false);
        txtEmailAdd.setEditable(false);
        txtSalary.setEditable(false);
        txtJobPos.setEditable(false);
        txtDeptName.setEditable(false);
        btnEdit.setText("Edit");
    } 
    
    /**
     * Initializes the controller class. Contains EventHandlers for various 
     * events including editing an Employee, saving an edit and deleting 
     * an employee.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setFieldsToEmpData(showMoreInfoEmployee);
        /**
         * Edit Employee Information EventHandler.
         */
        btnEdit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                setFieldsToEmpData(showMoreInfoEmployee);
                if(btnSaveEdit.isDisabled()){
                    setAllFieldsEditable();
                    btnSaveEdit.setDisable(false);
                }else{
                    setAllFieldsNotEditable();
                    btnSaveEdit.setDisable(false);
                }
            }
        });
        /**
         * EventHandler for saving New Information from Employee Edit.
         */
        btnSaveEdit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                employeeListModel.edit(showMoreInfoEmployee, txtId.getText(),
                        txtFName.getText(), txtLName.getText(), 
                        Integer.parseInt(txtAge.getText()), Long.parseLong(txtPhoneNum.getText()),
                        txtAddress.getText(), txtEmailAdd.getText(), Double.parseDouble(txtSalary.getText()), txtJobPos.getText(), txtDeptName.getText());
                clearTxtFlds();
            }
        });
        /**
         * EventHandler for deleting an Employee.
         */
        btnDelete.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                employeeListModel.getEmployees().remove(showMoreInfoEmployee);
                try {
                    RandomAccessFile temp = new RandomAccessFile(new File("temp.dat"),"rw");
                    for(int i=0;i<AddEmployeeController.getEmpList().getEmployees().size();i++){
                        try {
                            temp.seek(temp.length());
                            temp.seek(temp.length());
                            String firstName = txtFName.getText();
                            temp.writeChars(AddEmployeeController.getEmpList().getEmployees().get(i).getId());
                            if(AddEmployeeController.getEmpList().getEmployees().get(i).getFirstName().length() > NAME_SIZE){
                                firstName = firstName.substring(0,NAME_SIZE);
                                AddEmployeeController.getEmpList().getEmployees().get(i).setFirstName(firstName);
                            }else{
                                int numSpaces =  NAME_SIZE-AddEmployeeController.getEmpList().getEmployees().get(i).getFirstName().length();
                                for(int s=0;s<numSpaces;s++){
                                    firstName+="";
                                }
                                AddEmployeeController.getEmpList().getEmployees().get(i).setFirstName(firstName);
                            }
                            temp.writeChars(AddEmployeeController.getEmpList().getEmployees().get(i).getFirstName());
                            temp.writeChars(AddEmployeeController.getEmpList().getEmployees().get(i).getId());
                            } catch (IOException ex) {
                                Logger.getLogger(MoreInfoController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    }                    
                } catch (FileNotFoundException ex) {
                    System.out.println("ERROR");
                }
                clearTxtFlds();
            }
        });
    }
}
