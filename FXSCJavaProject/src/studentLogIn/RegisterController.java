/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentLogIn;

import classes.backAndExit;
import classes.loadNewPage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author George
 */
public class RegisterController implements Initializable {

    /**
     * Initializes the controller class.
     */
    backAndExit buttonHandlers = new  backAndExit();
    loadNewPage page = new loadNewPage();
    
    public Label verify;
    public void HandleGoBack(ActionEvent event){
         page.loadNewPage("/studentLogIn/StudentHomePage.fxml");
         ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    public void HandleExit(ActionEvent event){
             buttonHandlers.handleExit();
       }
    public void HandleRegisterUnits(ActionEvent event){
        verify.setVisible(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
}
