/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturerLogIn;

import classes.backAndExit;
import classes.loadNewPage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author George
 */
public class UnitsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    loadNewPage page = new loadNewPage();
    backAndExit buttons = new backAndExit();
     public void HandleGoBack(ActionEvent event){
         page.loadNewPage("/lecturerLogIn/homePage.fxml");
         ((Node)(event.getSource())).getScene().getWindow().hide();
         
        }
    public void HandleExit(ActionEvent event){
        buttons.handleExit();
    };
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
       
    }    
    
}
