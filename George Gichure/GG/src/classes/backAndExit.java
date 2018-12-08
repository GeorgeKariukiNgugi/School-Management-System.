/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author George
 */
public class backAndExit {
    public void handleExit(){
      System.exit(1);
      Platform.exit();
    }
    public void handleBack(String file){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(file));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("THIS IS THE PAGE.");
            stage.show();
            
                    
        } catch (Exception ex) {
            //Logger.getLogger(backAndExit.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
   /* public void handleLeavePage(String file){
          ((Node)(event.getSource())).getScene().getWindow().hide();
    }*/
}
