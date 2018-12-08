/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changePersonalDetails;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import classes.DatabaseConnection;
import classes.backAndExit;
import classes.getNameFromDataBase;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import classes.textFileGetAdmno;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author George
 */
public class MainPageController implements Initializable {
@FXML 
  public JFXTextField mobile;
  public JFXTextField email;
  public JFXTextField postalAdress;
  public JFXTextField postalCode;
  public JFXTextField residence;
  public JFXTextField nextOfKinName;
  public JFXTextField nextOfKinRelationaship;
  public JFXTextField nextOfKinPhoneNumber;
  public JFXButton exit;
  public JFXButton goBack;
  public JFXButton submit;
  public Label topic;
  public ImageView view;
  public Label lblname;
  public Label lbladmno;
  
  //  DEFINING THE DIFFERENT CLASS OBJECTS.
  
  DatabaseConnection conn = new DatabaseConnection();
  textFileGetAdmno file = new textFileGetAdmno();
  getNameFromDataBase databaseName = new getNameFromDataBase();
  backAndExit handleButtons = new backAndExit();
  
  // DEFINING THE VARIABLES TO BE USED IN THE PROGRAM.
    String sql;
    String sql2;
    String admno = file.getText();
    String name = databaseName.getNameFromDataBaseTable();
    String state;
    
  public void handleExit(ActionEvent event){
      handleButtons.handleExit();
      
  }
  public void handleGoBack(ActionEvent event){
      handleButtons.handleBack("/studentLogIn/StudentLogIn.fxml");
      ((Node)(event.getSource())).getScene().getWindow().hide();
      
  }
  
  public void handleSubmit(ActionEvent event){
      String txtMobile = mobile.getText();
      String txtEmail = email.getText();
      String txtPostalAddress = postalAdress.getText();
      String txtPostalCode= postalCode.getText();
      String txtResidence = residence.getText();
      String txtnextOfKinName = nextOfKinName.getText();
      String txtnextOfKinRelationaship = nextOfKinRelationaship.getText();
      String txtnextOfKinPhoneNumber = nextOfKinPhoneNumber.getText();
      
      
      
      // SQL WORKS.
      switch(state){
          case "notFound":
      sql = "insert into studentdetails (mobileNumber,emailAdress,postalAderess, postalCode,homeResidence,nextOfKin,nextOfKinRelationShip,nextOfKinPhoneNumber,admno,name)  VALUES ('"+txtMobile+"' , '"+txtEmail +"' , '"+txtPostalAddress+"' , '"+txtPostalCode+"' , '"+txtResidence+"' , '"+txtnextOfKinName+"' , '"+txtnextOfKinRelationaship+"' , '"+txtnextOfKinPhoneNumber+"' , '"+admno+"' , '"+name+"')";
      
    try {
        Statement statement = conn.co.createStatement();
        statement.executeUpdate(sql);
        System.out.println("THE DATA HAS BEEN INSERTED.");
          handleButtons.handleBack("/studentLogIn/StudentLogIn.fxml");
         ((Node)(event.getSource())).getScene().getWindow().hide();
    } catch (Exception ex) {
        System.out.println(ex);
    }
      break;
          case "found":
              
              sql2 = "update studentdetails set mobileNumber = '"+txtMobile+"',"+"emailAdress = '"+txtEmail+"',"+"postalAderess = '"+txtPostalAddress+"',"+"postalCode = '"+txtPostalCode+"',"+"homeResidence = '"+txtResidence+"',"+"nextOfKin= '"+txtnextOfKinName+"',"+"nextOfKinRelationShip= '"+txtnextOfKinRelationaship+"',"+"nextOfKinPhoneNumber= '"+txtnextOfKinPhoneNumber+"' where admno = '"+admno+"'";
                 try {
        Statement statement = conn.co.createStatement();
        statement.executeUpdate(sql2);
        System.out.println("THE DATA HAS BEEN UPDATE.");
    } catch (Exception ex) {
        System.out.println(ex);
    }
              break;
  }
     
     
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblname.setText(name);
        lbladmno.setText(admno);
        // LOADING THE IMAGE.
        
      try {
         
              String urls;
            urls= "src/images/maseno.png";
            File f = new File("src/images/maseno.png");
            Image image = new Image(f.toURI().toURL().toString());
            view.setImage(image);
        } catch (MalformedURLException ex) {
           // Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // HERE I AM DEFINING WHAT WILL BE DONE WHEN THE SYSTEM WILL FIND THAT THE USER HAS NOT SPECIFIED ANY PERSONAL DETAILS 
        //AND WHEN IT FINDS OUT THAT THE USER DEFINED SOME USER DETAILS.
        
        // DATABASE CONNECTION.
        conn.Connect();
        
        //GETTING THE ADMNO.
        admno = file.getText();
        // THE SQL QUERY.
        sql = "SELECT id FROM studentdetails where admno = '"+admno+"'";
        
    try {
        Statement statement = conn.co.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery(sql);
        if(resultSet.next()){
            state = "found";
            System.out.println("DATA FOUND.");
            topic.setText("UPDATE YOUR DETAILS.");
            sql = " select mobileNumber,emailAdress,postalAderess,postalCode,homeResidence,nextOfKin,nextOfKinRelationShip,nextOfKinPhoneNumber,admno,name from studentdetails where admno = '"+admno+"'";
            ResultSet resultSet2;
            resultSet2 = statement.executeQuery(sql);
            if(resultSet2.next()){
                String  Rsmobile = resultSet2.getString(1);
                String  Rsemail = resultSet2.getString(2);
                String  RspostalAdress = resultSet2.getString(3);
                String  RspostalCode = resultSet2.getString(4);
                String  RshomeResidence = resultSet2.getString(5);
                String  RsnextOfKin = resultSet2.getString(6);
                String  RsnextOfKinRelationShip = resultSet2.getString(7);
                String  RsnextOfKinPhoneNumber = resultSet2.getString(8);
                
                  mobile.setText( Rsmobile);
                  email.setText(Rsemail);
                  postalAdress.setText(RspostalAdress);
                  postalCode.setText(RspostalCode);
                  residence.setText(RshomeResidence);
                  nextOfKinName.setText(RsnextOfKin);
                  nextOfKinRelationaship.setText(RsnextOfKinRelationShip);
                  nextOfKinPhoneNumber.setText(RsnextOfKinPhoneNumber);
               
            }
            
        }  
        else{
            state = "notFound";
            System.out.println(" NO DATA FOUND");
            topic.setText("ENTER YOUR DETAILS.");
        }
    } catch (Exception ex) {
       // Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE, null, ex);
       System.out.println(ex);
    }
       
    }    
    
}
