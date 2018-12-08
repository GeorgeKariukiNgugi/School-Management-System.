/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeCredentials;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import classes.DatabaseConnection;
import classes.backAndExit;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import studentLogIn.StudentHomePageController;
import classes.textFileGetAdmno;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author George
 */
public class MainpageController implements Initializable {

  @FXML
  public JFXButton btnChange;
  public JFXTextField txtpass;
  public JFXTextField txtnewpass;
  public Label username;
  public Text txt;
  public ImageView view;
  @FXML
  DatabaseConnection conn = new DatabaseConnection();
  textFileGetAdmno file = new textFileGetAdmno();
  backAndExit handleButton = new backAndExit();
  public String admno = file.getText();
  public void handleChange(ActionEvent event){
      System.out.println("THERE IS HERE.");
      String pass = txtpass.getText();
      String newPass = txtnewpass.getText();
      if(pass.equals(newPass)){
          try {
              Statement statement = conn.co.createStatement();
              String sql = "UPDATE studentverification SET password = '"+newPass+"'where username = '"+admno+"'";
              statement.executeUpdate(sql);
              System.out.println("DATA HAS BEEN UPDATED.");
              handleButton.handleBack("/studentLogIn/StudentLogIn.fxml");
             ((Node)(event.getSource())).getScene().getWindow().hide();
          } catch (SQLException ex) {
              Logger.getLogger(MainpageController.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      else{
       
        txt.setVisible(true);
         System.out.println("WRONG.");
      }
  }
   public void handleGoBack(ActionEvent event){
      handleButton.handleBack("/studentLogIn/StudentLogIn.fxml");
      ((Node)(event.getSource())).getScene().getWindow().hide();
      
  }
  public void handleSecondTextField(ActionEvent event){
      System.out.println("THE NEXT");
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
         
              String urls;
            urls= "src/images/maseno.png";
            File f = new File("src/images/maseno.png");
            Image image = new Image(f.toURI().toURL().toString());
            view.setImage(image);
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        conn.Connect();
       
        username.setText(admno);
        
    }    
    
}
