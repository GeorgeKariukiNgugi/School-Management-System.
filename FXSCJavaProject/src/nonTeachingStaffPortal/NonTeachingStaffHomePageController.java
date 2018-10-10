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
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class NonTeachingStaffHomePageController implements Initializable {
    
    // DEFININNG THE CONTROLS IN THE SYSTEM/
    
    public Label lblName;
    public Label lblRegNo;
    public Label lblPhoneNum;
    public Label lblEmail;
    public Label lblPostalAdd;
    public Label lblPostalCode;
    public Label lblDepert;
    public Label lblJobGroup;
    public Label lblResidence;
    public Label lblNextOfKin;
    public Label lblGross;
    public Label lblNet;
    

   // OBJECTS OF ALL THE CLASSES NEEDED IN THE SYSTEM.
    
    DatabaseConnection conn = new DatabaseConnection();
    textFileGetAdmno file = new textFileGetAdmno();
    backAndExit buttons = new backAndExit ();
    loadNewPage loadPage = new loadNewPage();
   // DEFINING THE VARIABLES TO BE USED.
    
    String regNo = file.getText();
    String sql;
    
    
    // METHOS TO HANDLE BUTTONS .
    
    public void HandleExit(ActionEvent event){
        buttons.handleExit();
    }
    public void HandleAddStudent(ActionEvent event){
        loadPage.loadNewPage("/nonTeachingStaffPortal/addingStudent.fxml");
        ((Node)(event.getSource())).getScene().getWindow().hide();
        
    }
    public void HandleGoBack(ActionEvent event){
          loadPage.loadNewPage("/nonTeachingStaffPortal/logInPage.fxml");
         ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // HERE IS THE CODE WHERE ALL THE DEFAULT EDITS WILL GO ONCE THE SYSTEM IS LOADED.
        
        // CONNECTING TO THE DATABASE.
        
        conn.Connect();
        
        //  FETCHING DATA FROM DATABASE.
       System.out.println("DATA.");
        try {
             sql = "select CONCAT(fName , '  ' ,lName) AS name ,RegNo ,homeResidence,phoneNumber,email,depertment,jobGroup,postalAddress,postalCode,salaryDue from nonteachingpersonaldetails where RegNo ='"+regNo+"'";
            Statement statement = conn.co.createStatement();
            ResultSet resultset ;
            resultset = statement.executeQuery(sql);
            
            if(resultset.next()){
                
                System.out.println("DATA SHOULD BE SET.");
               
              lblName.setText(resultset.getString("name"));
              lblRegNo.setText(resultset.getString("RegNo"));
              lblPhoneNum.setText(resultset.getString("phoneNumber"));
              lblEmail.setText(resultset.getString("email")); 
              lblPostalAdd.setText(resultset.getString("postalAddress"));
              lblPostalCode.setText(resultset.getString("postalCode"));
              lblDepert.setText(resultset.getString("depertment"));
              lblJobGroup.setText(resultset.getString("jobGroup"));
              lblResidence.setText(resultset.getString("homeResidence"));
             // lblNextOfKin.setText(resultset.getNString(""));
            
            }
            else{
             System.out.println("NO DATA FOUND.."+regNo);
            }
        } catch (Exception ex) {
            //Logger.getLogger(NonTeachingStaffHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        
    }    
    
}
