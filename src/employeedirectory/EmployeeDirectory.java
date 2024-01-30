/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeedirectory;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
* Project's main class. Starts the user in the HomePage.fxml page
* 
* @author amaan
*/
public class EmployeeDirectory extends Application {
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Home Page Start method
     * 
     * @param stage for setting the stage to the HomePage.FXML Scene
     * @throws Exception for opening the FXML
     */
    @Override
    public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
    stage.setTitle("Home Page");
    stage.getIcons().add(new Image("./employeeDirectory/logo.png"));
    Scene scene = new Scene(root);
    String css = this.getClass().getResource("style.css").toExternalForm();
    scene.getStylesheets().add(css);
    stage.setScene(scene);
    stage.show();

    }

}
