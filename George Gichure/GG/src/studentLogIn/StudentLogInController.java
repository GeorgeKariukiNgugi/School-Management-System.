/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentLogIn;

import classes.textFileGetAdmno;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import classes.DatabaseConnection;
import classes.backAndExit;
import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author George
 */
public class StudentLogInController implements Initializable {

    /**
     * Initializes the controller class.
     */
      public JFXTextField txtusername;
      public JFXPasswordField txtpassword;
      public ImageView view;
      DatabaseConnection datacon = new  DatabaseConnection();
      public String username;
      public String password;
      public Label lblwrong;
      textFileGetAdmno files = new textFileGetAdmno();
    backAndExit buttonHandlers = new  backAndExit();
      
        public void handleLogIn(ActionEvent event){
            
            //CHECKING IF THE TWO TEXT FIELDS ARE EMPTY.
            username = txtusername.getText();
            password = txtpassword.getText();
            
            if(!"".equals(username) && !"".equals(password)){
                    //CONNECTION TO THE DATABASE.
                 datacon.Connect();
             
                   // VERIFYING THE DATA THAT IS IVEN.           
        try {
            Statement statement;
            statement = datacon.co.createStatement();
            ResultSet sql = statement.executeQuery("select id  from studentverification where username = '" + username + "' and password = '"+password + "'"); 
            if(sql.next()){
               // ADDING THE DATA TO THE TEXT FILE .
           files.setText(username);
                
             FXMLLoader loader = new  FXMLLoader(getClass().getResource("StudentHomePage.fxml"));
             Parent root1 = (Parent) loader.load();
             StudentHomePageController controller1 = loader.getController();
             controller1.Admission(username);
             Scene scene = new Scene(root1);
             Stage stage = new Stage();
             stage.setScene(scene);
             stage.setTitle("THE NEW PAGE.");
             stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            else{
                lblwrong.setText("INPUT MISMATCH TRY AGAIN..");
                
            }
            
        } catch (Exception ex) {
           System.out.println(ex);
           System.out.println("HAPA LUNA SHDA");
        
        }
                
             //HERE WAS THE GETTIN OF TEXT.
             files.getText();
             
                }
             else {
                System.out.println("THE FIELDS ARE EMPTY TRY ONCE MORE.");
                lblwrong.setText("THE FIELDS ARE EMPTY TRY ONCE MORE.");
                
          }
            
         
             
             
             
       
    
    }
       public void HandleExit(ActionEvent event){
              buttonHandlers.handleExit();
       }
       public void handleGoBack(ActionEvent event){
           buttonHandlers.handleBack("/fxscjavaproject/FXMLDocument.fxml");
             ((Node)(event.getSource())).getScene().getWindow().hide();
       }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
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
