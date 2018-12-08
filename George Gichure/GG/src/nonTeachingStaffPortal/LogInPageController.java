/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonTeachingStaffPortal;

import classes.DatabaseConnection;
import classes.backAndExit;
import classes.loadNewPage;
import classes.textFileGetAdmno;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lecturerPage.LecturerLogInController;

/**
 * FXML Controller class
 *
 * @author George
 */
public class LogInPageController implements Initializable {
@FXML 
 public ImageView view;
 public JFXTextField txtusername;
public JFXPasswordField txtpass;
public Label lbl;

// DEFINING THE STRINGS TO BE USED.

public String sql ;
 
 
// DEFING THE PBJECTS FROM DIFFERENT CLASSES

DatabaseConnection conn = new DatabaseConnection();
loadNewPage newPage = new loadNewPage();
backAndExit buttons = new backAndExit();
 textFileGetAdmno file = new textFileGetAdmno();
 
    public void HandleLogIn(ActionEvent event){
         String   username = txtusername.getText().toLowerCase();
         String password = txtpass.getText().toLowerCase();
           if(username == null || password == null){
               
               lbl.setText("EMPTY FIELDS.");
           }
           
            file.setText(username);
           sql = "select id from  nonstudentverification where username = '"+username+"' and password ='"+password+"'";
           
           
        try {
            Statement statement;
            statement = conn.co.createStatement();
             ResultSet resultset;
             resultset = statement.executeQuery(sql);
             
             if(resultset.next()){
               newPage.loadNewPage("/nonTeachingStaffPortal/nonTeachingStaffHomePage.fxml");
              ((Node)(event.getSource())).getScene().getWindow().hide();
             
              
             }
             else{
                   lbl.setText("WRONG CREDENTIALS.");
             }
        }catch (Exception ex) {
            Logger.getLogger(LecturerLogInController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }     
       }
    
    public void HandleExit(ActionEvent event){
        buttons.handleExit();
    }
    public void HandleoBack(ActionEvent event){
        buttons.handleBack("/fxscjavaproject/FXMLDocument.fxml");
          ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn.Connect();
        
                File g = new File("C:/wamp64/www/Maseno clone/PHOTOS/maseno.png");
         try {
            Image image = new Image(g.toURI().toURL().toString());
            view.setImage(image);
            
        } catch (Exception  ex) {
            System.out.println(ex);
         System.out.println("something");
        }
    }    
    
}
