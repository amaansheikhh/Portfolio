/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package employeedirectory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * HomePage.FXML Controller class for dealing with all of the User interactions 
 * with the FXML page.
 *
 * @author amaan
 */
public class HomePageController implements Initializable {

    static EmployeeList employeeListModel = new EmployeeList();
    static Employee showMoreInfoEmployee;
    static String showMoreInfoId;
        
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch,btnAddEmployee,btnMoreInfo;
    @FXML
    private TableView<Employee> tblEmployees;
    @FXML
    private TableColumn<Employee,String> tblColFName,tblColLName,tblColEmail;
            
    private Stage stage;
    private Parent root;
    private Scene scene;
    
    /**
     * Shows the addEmployee.fxml page when the User presses the "Add Employee" 
     * button in the Home Page.
     * 
     * @param event On "Add Employee" Button Press
     * @throws IOException For getting the addEmployee.fxml page
     */
    @FXML
    public void showAddEmployeePage(ActionEvent event) throws IOException{
        /*Parent root1 = FXMLLoader.load(getClass().getResource("addEmployee.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setTitle("Add Employee");
        stage.setScene(scene);
        stage.show();*/
        
        Parent root1 = FXMLLoader.load(getClass().getResource("addEmployee.fxml"));
        
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Add Employee");
        Scene scene = new Scene(root1);
        stage.getIcons().add(new Image("./employeeDirectory/addEmployee.png"));
        String css = this.getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }
    
   
    /**
     * Method for searching for an Employee. Searches for the user's input in 
     * the ObservableList.
     * User can search by first name, last name, and email address
     * 
     * @param event On "Search" Button Press
     * @throws IOException Exception
     */
    @FXML
    public void searchEmployee(ActionEvent event) throws IOException {
        String lastName = txtSearch.getText();
        String firstName = txtSearch.getText();
        String email = txtSearch.getText();
        if (txtSearch.getText().equals("")) {
            tblEmployees.setItems(employeeListModel.getEmployees());
            btnSearch.setText("Search");
        } else {
            btnSearch.setText("Reset");
            txtSearch.setText("");
            ObservableList<Employee> employees = employeeListModel.getEmployees();
            EmployeeList searchEmployees = new EmployeeList();
            for (Employee emp : employees) {
                if (emp.getLastName().equals(lastName) || emp.getFirstName().equals(firstName) || emp.getEmail().equals(email)) {
                    searchEmployees.add(emp);
                }
            }
            tblEmployees.setItems(searchEmployees.getEmployees());
        }
    }     
    
    /**
     * Function for showing the MoreInfo.fxml page. When the user clicks on a
     * certain employee, the page will change to the MoreInfo.fxml Page.
     * 
     * @param event Mouse Click on Employee
     * @throws InvocationTargetException Exception for when the User clicks on 
     * an empty row in the TableView.
     */
    @FXML
    public void showMoreInfoPage(MouseEvent event) throws InvocationTargetException{
        showMoreInfoEmployee=tblEmployees.getSelectionModel().getSelectedItem();
        try{
        Parent root1 = FXMLLoader.load(getClass().getResource("MoreInfo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setTitle("More Info");
        stage.setScene(scene);
        stage.show();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    /**
     * Initializes the controller class. Fills and updates the TableView.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        tblColFName.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        tblColLName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        tblColEmail.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        tblEmployees.setItems(employeeListModel.getEmployees());
    }    
    
}