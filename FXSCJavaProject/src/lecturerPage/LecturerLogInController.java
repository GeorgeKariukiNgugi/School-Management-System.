/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturerPage;

import classes.DatabaseConnection;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import classes.backAndExit;
import classes.loadNewPage;
import classes.textFileGetAdmno;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author George
 */
public class LecturerLogInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
      public ComboBox cmbx;
      public Text username;
      public Text password;
      public FontAwesomeIconView user;
      public FontAwesomeIconView key;
      public JFXTextField txtusername;
      public JFXPasswordField txtpass;
      public JFXCheckBox chk1;
      public JFXButton btnLogIn;
      public JFXButton btngoBack;
      public ImageView view;
      public Label lbl;
      @FXML
      String urlx,sql;
    
     
      // DEFINING THE OBJECT CLASSES USED IN THE PROGRAM.
      
      backAndExit handleButtons = new backAndExit();
      DatabaseConnection conn = new DatabaseConnection(); 
      loadNewPage  newPage = new loadNewPage();
      textFileGetAdmno file = new textFileGetAdmno();
       public void handleExit(ActionEvent e){
            System.exit(1);
        }  
       public void handleGoBack(ActionEvent event){
           handleButtons.handleBack("/fxscjavaproject/FXMLDocument.fxml");
            ((Node)(event.getSource())).getScene().getWindow().hide();
       }
       public void HandleLogIn(ActionEvent event){
            String username;
            String password;
           
           username = txtusername.getText();
           password = txtpass.getText();
           
           if(username == null || password == null){
               
               lbl.setText("EMPTY FIELDS.");
           }
           sql = "select password from  lecturerverification where username = '"+username+"'";
           
           
        try {
            Statement statement;
            statement = conn.co.createStatement();
             ResultSet resultset;
             resultset = statement.executeQuery(sql);
             
             if(resultset.next()){
                username = txtusername.getText();
               newPage.loadNewPage("/lecturerLogIn/homePage.fxml");
               ((Node)(event.getSource())).getScene().getWindow().hide();
               file.setText(username);
             }
             else{
                   lbl.setText("WRONG CREDENTIALS.");
             }
        } catch (SQLException ex) {
            Logger.getLogger(LecturerLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
           
       }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        conn.Connect();
        try {
            // TODO
            urlx = "src/images/maseno.png";
            File file = new File(urlx);
            Image image = new Image(file.toURI().toURL().toString());
            view.setImage(image);
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(LecturerLogInController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
    }    
    
}
