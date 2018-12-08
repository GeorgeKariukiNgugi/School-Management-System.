/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsSchoolOfEducation;

import studentSchoolOfComputing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author George
 */
public class SemesterSelectionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public ImageView view;
       public void handleButton11(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("units11.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
           // Logger.getLogger(SemesterSelectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
}
       public void handleButton12(){
            try {
            Parent root = FXMLLoader.load(getClass().getResource("units12.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
           // Logger.getLogger(SemesterSelectionController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
           
           
}
       public void handleButton21(){
            try {
            Parent root = FXMLLoader.load(getClass().getResource("units21.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
 System.out.println(ex);           
// Logger.getLogger(SemesterSelectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
}
       public void handleButton22(){
            try {
            Parent root = FXMLLoader.load(getClass().getResource("units22.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
           // Logger.getLogger(SemesterSelectionController.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println(ex);
        }
           
           
}
       public void handleButton31(){
           
}
       public void handleButton32(){
           
}
       public void handleButton41(){
           
}
       public void handleButton42(){
           
}
       public void handleButton33(){
           
}
       
    @Override
 
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            File file = new File("src/images/maseno.png");
            Image image = new Image(file.toURI().toURL().toString());
            view.setImage(image);
        } catch (Exception ex) {
            //Logger.getLogger(SemesterSelectionController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }    
    
}
