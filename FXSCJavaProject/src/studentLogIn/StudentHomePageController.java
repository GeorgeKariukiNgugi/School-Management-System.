/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentLogIn;

import classes.textFileGetAdmno;
import com.jfoenix.controls.JFXButton;
import classes.DatabaseConnection;
import classes.backAndExit;
import classes.loadNewPage;
import java.io.File;
import java.io.IOException;
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
public class StudentHomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public ImageView view;
     public String sql = "";
     Statement statement;
     ResultSet resultSet;
     public String schoolaccronym;
     //public Parent root1 = null;
   @FXML
     public Label lblAdmno;
     public Label lblNames;
     public Label lblSchool;
     public Label lblDepertment;
     public Label lblProgramme;
     public Label lblIdNumber;
     public Label lblCampus;
     public Label lblYearOfAdmission;
     public Label lblCurrentYear;
     public Label lblCurrentSemester;
     public JFXButton register;
     public JFXButton changePassword;
     public JFXButton editPersonalDetails;
     DatabaseConnection connect = new   DatabaseConnection();
    // java.io.File file = new java.io.File("data.txt");
     textFileGetAdmno files = new textFileGetAdmno();
     backAndExit buttonHandlers = new  backAndExit();
     loadNewPage page = new loadNewPage();
     
     public void HandleRegisterReal(ActionEvent event){
          page.loadNewPage("/studentLogIn/register.fxml");
         ((Node)(event.getSource())).getScene().getWindow().hide();
     }
     
     public void handleViewUnits(ActionEvent event){
         page.loadNewPage("/studentLogIn/studentViewUnits.fxml");
         ((Node)(event.getSource())).getScene().getWindow().hide();
         
     }
   public void HandleExit(ActionEvent event){
             buttonHandlers.handleExit();
       }
       public void handleGoBack(ActionEvent event){
           buttonHandlers.handleBack("/studentLogIn/StudentLogIn.fxml");
             ((Node)(event.getSource())).getScene().getWindow().hide();
       }
    // THIS EVENT HANDLER IS USED TO TAKE THE USER TO THE PAE WHERE THE CHANGING TAKES PLACE.
       
       public void handleChangeCredentials(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/changeCredentials/mainpage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception ex) {
            //Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
       }
       
       public void handleEditDetails(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/changePersonalDetails/mainPage.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (Exception ex) {
            //Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
       }
       
    // THE METHOD TO GET THE ADMN OF THE STUDENT.
       public String admissionNumber;
   
        public void  Admission(String value){
        try {
            admissionNumber = value ;
            System.out.println(admissionNumber);  
            //.setText(admissionNumber);
            String substring = admissionNumber.substring(0, 2);
            System.out.println(substring);
            switch(substring){
                case "CI":
                    System.out.println("SCHOOL OF COMPUTING.");
                    sql = "SELECT concat(fName, ' ', lName),campus,depertment,programme,idNumber,yearOfAdmission,currentYear,currentSemester from schoolOfComputing where admno = '"+ admissionNumber+ "'";
                    statement = connect.co.createStatement();
                     resultSet = statement.executeQuery(sql);
                     if(resultSet.next()){
                         String names = resultSet.getString(1).toUpperCase();
                         String campus = resultSet.getString(2).toUpperCase();
                         String depertment = resultSet.getString(3).toUpperCase();
                         String programme = resultSet.getString(4).toUpperCase();
                         String idNumber = resultSet.getString(5).toUpperCase();
                         String yearOfAdmission = resultSet.getString(6).toUpperCase();
                         String currentYear = resultSet.getString(7).toUpperCase();
                         String currentSemester = resultSet.getString(8).toUpperCase();
                         
                         lblAdmno.setText(admissionNumber);
                         lblNames.setText(names); 
                         lblSchool.setText("SCHOOL OF COMPUTING."); 
                         lblDepertment.setText(depertment); 
                         lblProgramme.setText(programme); 
                         lblIdNumber.setText(idNumber);  
                         lblCampus.setText(campus);  
                         lblYearOfAdmission.setText(yearOfAdmission);  
                         lblCurrentYear.setText(currentYear); 
                         lblCurrentSemester.setText(currentSemester); 
                         
                         
                     }
                    break;
                case "SC":
                    System.out.println("SCHOOL OF BIOLOGICAL AND PHYSICAL SCIENCES..");
                     sql = "SELECT concat(fName, ' ', lName),campus,depertment,programme,idNumber,yearOfAdmission,currentYear,currentSemester from  schoolofbioloicalandpysicalsciences where admno = '"+ admissionNumber+ "'";
                    statement = connect.co.createStatement();
                     resultSet = statement.executeQuery(sql);
                     if(resultSet.next()){
                         String names = resultSet.getString(1).toUpperCase();
                         String campus = resultSet.getString(2).toUpperCase();
                         String depertment = resultSet.getString(3).toUpperCase();
                         String programme = resultSet.getString(4).toUpperCase();
                         String idNumber = resultSet.getString(5).toUpperCase();
                         String yearOfAdmission = resultSet.getString(6).toUpperCase();
                         String currentYear = resultSet.getString(7).toUpperCase();
                         String currentSemester = resultSet.getString(8).toUpperCase();
                         
                         lblAdmno.setText(admissionNumber);
                         lblNames.setText(names); 
                         lblSchool.setText("SCHOOL OF BIOLOGICAL AND PHYSICAL SCIENCES."); 
                         lblDepertment.setText(depertment); 
                         lblProgramme.setText(programme); 
                         lblIdNumber.setText(idNumber);  
                         lblCampus.setText(campus);  
                         lblYearOfAdmission.setText(yearOfAdmission);  
                         lblCurrentYear.setText(currentYear); 
                         lblCurrentSemester.setText(currentSemester); 
                         
                         
                     }
                    break;
                case "MD":
                    System.out.println("SCHOOL OF MEDICINE.");
                        sql = "SELECT concat(fName, ' ', lName),campus,depertment,programme,idNumber,yearOfAdmission,currentYear,currentSemester from  schoolofmedicine where admno = '"+ admissionNumber+ "'";
                    statement = connect.co.createStatement();
                     resultSet = statement.executeQuery(sql);
                     if(resultSet.next()){
                         String names = resultSet.getString(1).toUpperCase();
                         String campus = resultSet.getString(2).toUpperCase();
                         String depertment = resultSet.getString(3).toUpperCase();
                         String programme = resultSet.getString(4).toUpperCase();
                         String idNumber = resultSet.getString(5).toUpperCase();
                         String yearOfAdmission = resultSet.getString(6).toUpperCase();
                         String currentYear = resultSet.getString(7).toUpperCase();
                         String currentSemester = resultSet.getString(8).toUpperCase();
                         
                         lblAdmno.setText(admissionNumber);
                         lblNames.setText(names); 
                         lblSchool.setText("SCHOOL OF MEDICINE."); 
                         lblDepertment.setText(depertment); 
                         lblProgramme.setText(programme); 
                         lblIdNumber.setText(idNumber);  
                         lblCampus.setText(campus);  
                         lblYearOfAdmission.setText(yearOfAdmission);  
                         lblCurrentYear.setText(currentYear); 
                         lblCurrentSemester.setText(currentSemester); 
                         
                         
                     }
                    break;
                case "MT":
                    System.out.println("SCHOOL OF MATHEMATICS.");
                          sql = "SELECT concat(fName, ' ', lName),campus,depertment,programme,idNumber,yearOfAdmission,currentYear,currentSemester from  schoolofmaths where admno = '"+ admissionNumber+ "'";
                    statement = connect.co.createStatement();
                     resultSet = statement.executeQuery(sql);
                     if(resultSet.next()){
                         String names = resultSet.getString(1).toUpperCase();
                         String campus = resultSet.getString(2).toUpperCase();
                         String depertment = resultSet.getString(3).toUpperCase();
                         String programme = resultSet.getString(4).toUpperCase();
                         String idNumber = resultSet.getString(5).toUpperCase();
                         String yearOfAdmission = resultSet.getString(6).toUpperCase();
                         String currentYear = resultSet.getString(7).toUpperCase();
                         String currentSemester = resultSet.getString(8).toUpperCase();
                         
                         lblAdmno.setText(admissionNumber);
                         lblNames.setText(names); 
                         lblSchool.setText("SCHOOL OF MATHEMATICS."); 
                         lblDepertment.setText(depertment); 
                         lblProgramme.setText(programme); 
                         lblIdNumber.setText(idNumber);  
                         lblCampus.setText(campus);  
                         lblYearOfAdmission.setText(yearOfAdmission);  
                         lblCurrentYear.setText(currentYear); 
                         lblCurrentSemester.setText(currentSemester); 
                         
                         
                     }
                    break;
                case "ED":
                    System.out.println("SCHOOL OF EDUCATION.");
                          sql = "SELECT concat(fName, ' ', lName),campus,depertment,programme,idNumber,yearOfAdmission,currentYear,currentSemester from  schoolofeducation where admno = '"+ admissionNumber+ "'";
                    statement = connect.co.createStatement();
                     resultSet = statement.executeQuery(sql);
                     if(resultSet.next()){
                         String names = resultSet.getString(1).toUpperCase();
                         String campus = resultSet.getString(2).toUpperCase();
                         String depertment = resultSet.getString(3).toUpperCase();
                         String programme = resultSet.getString(4).toUpperCase();
                         String idNumber = resultSet.getString(5).toUpperCase();
                         String yearOfAdmission = resultSet.getString(6).toUpperCase();
                         String currentYear = resultSet.getString(7).toUpperCase();
                         String currentSemester = resultSet.getString(8).toUpperCase();
                         
                         lblAdmno.setText(admissionNumber);
                         lblNames.setText(names); 
                         lblSchool.setText("SCHOOL OF EDUCATION."); 
                         lblDepertment.setText(depertment); 
                         lblProgramme.setText(programme); 
                         lblIdNumber.setText(idNumber);  
                         lblCampus.setText(campus);  
                         lblYearOfAdmission.setText(yearOfAdmission);  
                         lblCurrentYear.setText(currentYear); 
                         lblCurrentSemester.setText(currentSemester); 
                         
                         
                     }
                    break;
                case "AT":
                    System.out.println("SCHOOL OF ARTS.");
                      sql = "SELECT concat(fName, ' ', lName),campus,depertment,programme,idNumber,yearOfAdmission,currentYear,currentSemester from  schoolofarts where admno = '"+ admissionNumber+ "'";
                      statement = connect.co.createStatement();
                     resultSet = statement.executeQuery(sql);
                     if(resultSet.next()){
                         String names = resultSet.getString(1).toUpperCase();
                         String campus = resultSet.getString(2).toUpperCase();
                         String depertment = resultSet.getString(3).toUpperCase();
                         String programme = resultSet.getString(4).toUpperCase();
                         String idNumber = resultSet.getString(5).toUpperCase();
                         String yearOfAdmission = resultSet.getString(6).toUpperCase();
                         String currentYear = resultSet.getString(7).toUpperCase();
                         String currentSemester = resultSet.getString(8).toUpperCase();
                         
                         lblAdmno.setText(admissionNumber);
                         lblNames.setText(names); 
                         lblSchool.setText("SCHOOL OF ARTS."); 
                         lblDepertment.setText(depertment); 
                         lblProgramme.setText(programme); 
                         lblIdNumber.setText(idNumber);  
                         lblCampus.setText(campus);  
                         lblYearOfAdmission.setText(yearOfAdmission);  
                         lblCurrentYear.setText(currentYear); 
                         lblCurrentSemester.setText(currentSemester); 
                         
                         
                     }
                    break;
                default:
                    System.out.println("THE PARTICULAR SCHOOL NOT FOUND.");
                    break;
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
      public void handleRegisterUnits(ActionEvent e){
          schoolaccronym = files.getSchool();
       switch(schoolaccronym){
           case "ci":
          {
              try {
                Parent  root1 = FXMLLoader.load(getClass().getResource("/studentSchoolOfComputing/SemesterSelection.fxml"));
                   Stage stage = new Stage();
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("THIS IS THE NEXT PAGE.");
            stage.show();
              } catch (IOException ex) {
                  Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
           break;
           case "mt":
          {
              try {
              Parent   root1 =  FXMLLoader.load(getClass().getResource("/studentsSchoolOfMaths/SemesterSelection.fxml"));
                  Stage stage = new Stage();
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("THIS IS THE NEXT PAGE.");
            stage.show();
              } catch (Exception ex) {
                  //Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
          }
               break;
           case "ed":
          {
              try {
               Parent   root1 =  FXMLLoader.load(getClass().getResource("/studentsSchoolOfEducation/SemesterSelection.fxml"));
                   Stage stage = new Stage();
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("THIS IS THE NEXT PAGE.");
            stage.show();
              } catch (IOException ex) {
                  Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
               break;
           case "at":
          {
              try {
               Parent  root1 =   FXMLLoader.load(getClass().getResource("/studentsSchoolOfArts/SemesterSelection.fxml"));
                  Stage stage = new Stage();
            Scene scene = new Scene(root1);
            stage.setScene(scene);
            stage.setTitle("THIS IS THE NEXT PAGE.");
            stage.show();
              } catch (IOException ex) {
                  Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
               break;
       }
           
       
      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //DATABASE CONNECTION.
        connect.Connect();
        try {
            // TODO
          //  System.out.println( "THIS IS USERNAME::"+cont1.txtusername.getText());
              String urls;
            urls= "src/images/maseno.png";
            File f = new File("src/images/maseno.png");
            Image image = new Image(f.toURI().toURL().toString());
            view.setImage(image);
        } catch (MalformedURLException ex) {
            Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       files.getText();
    }    
    
}
