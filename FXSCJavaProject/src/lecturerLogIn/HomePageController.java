/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturerLogIn;

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
public class HomePageController implements Initializable {
    
    DatabaseConnection con = new DatabaseConnection();
    textFileGetAdmno file = new textFileGetAdmno();
    backAndExit buttons = new backAndExit ();
    loadNewPage loadPage = new loadNewPage();

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
    public Label lblSchool;
    public Label lblCampus;
    public Label lblId;
    
    
    public void HandleGoBack(ActionEvent event){
        loadPage.loadNewPage("/lecturerPage/LecturerLogIn.fxml");
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    public void HandleExit(ActionEvent event){
        buttons.handleExit();
    }
    public void HandleUnits(ActionEvent event){
         loadPage.loadNewPage("/lecturerLogIn/units.fxml");
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con.Connect();
           String regNo = file.getText();
         System.out.println("DATA.");
        try {
            String sql;
             sql = "select CONCAT(fName , '  ' ,lName) AS name ,RegNo ,school ,campus,homeResidence,phoneNumber,email,depertment,jobGroup,postalAddress,postalCode,salaryDue from lecPersonalDetails where RegNo ='"+regNo+"'";
            
             Statement statement = con.co.createStatement();
            ResultSet resultset ;
           resultset = statement.executeQuery(sql);
//             System.out.println("DATA SHOULD BE SET.");
//            ResultSet resultset = con.state.executeQuery(sql);
            if(resultset.next()){     
              lblName.setText(resultset.getString("name"));
              lblRegNo.setText(resultset.getString("RegNo"));
              lblPhoneNum.setText(resultset.getString("phoneNumber"));
              lblEmail.setText(resultset.getString("email")); 
              lblPostalAdd.setText(resultset.getString("postalAddress"));
              lblPostalCode.setText(resultset.getString("postalCode"));
              lblDepert.setText(resultset.getString("depertment"));
              lblJobGroup.setText(resultset.getString("jobGroup"));
              lblResidence.setText(resultset.getString("homeResidence"));
              lblSchool.setText(resultset.getString("school"));
              lblCampus.setText(resultset.getString("campus"));
              lblId.setText(resultset.getString("natId"));
              
            }
            else{
             System.out.println("NO DATA FOUND.."+regNo);
            }
        } catch (Exception ex) {
            //Logger.getLogger(NonTeachingStaffHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("wrong");
            System.out.println(ex);
        }
    }    
    
}
