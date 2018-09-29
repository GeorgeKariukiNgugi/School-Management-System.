/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentSchoolOfComputing;

import com.jfoenix.controls.JFXCheckBox;
import classes.DatabaseConnection;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import classes.textFileGetAdmno;

/**
 * FXML Controller class
 *
 * @author George
 */
public class Units11Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public JFXCheckBox ccs101;
    public JFXCheckBox ccs102;
    public JFXCheckBox ccs103;
    public JFXCheckBox ccs104;
    public JFXCheckBox ccs105;
    public JFXCheckBox ccs106;
    public JFXCheckBox ccs107;
    public ImageView view;
    public Label error;
    public ArrayList <String> units = new ArrayList <> ();
    public String sql;
    ResultSet  resultset;
    DatabaseConnection connection = new DatabaseConnection();
   //  java.io.File file = new java.io.File("src/studentLogIn/java.txt");
    textFileGetAdmno files = new textFileGetAdmno();   
    public String values =  files.getText();
      public void handleSubmit(ActionEvent e){
          if(ccs101.isSelected()){
              units.add(ccs101.getText());
          }
          if(ccs102.isSelected()){
              units.add(ccs102.getText());
          }
          if(ccs103.isSelected()){
              units.add(ccs103.getText());
          }
          if(ccs104.isSelected()){
              units.add(ccs104.getText());
          }
        if(ccs105.isSelected()){
              units.add(ccs105.getText());
          }
        if(ccs106.isSelected()){
              units.add(ccs106.getText());
          }
        
       // System.out.println(units.size());
        
        int length = units.size();
        if(length <1){
            System.out.println("NO UNITS SUBMITTED.");
           // error.setText("NO UNITS SELECTED FOR SUBMISSION.");
           error.setVisible(true);
        }
        else{
            // WE NEED TO GET THE PARTICULAR ABOUT THE STUDENT AS FROM THE DATABASE.
            String school = values.substring(0, 2);
            System.out.println(school);
            String schoolDataBaseName = "";
            switch(school){
                case "ci":
                  schoolDataBaseName = "schoolofcomputing"; 
                  System.out.println(schoolDataBaseName);
                  break;
                case "sc":
                 schoolDataBaseName = "schoolofbioloicalandpysicalsciences"; 
                 System.out.println(schoolDataBaseName);
                 break;
                case "mt":
                  schoolDataBaseName = " schoolofmaths";  
                  System.out.println(schoolDataBaseName);
                  break;
                case "ed":
                    schoolDataBaseName = "schoolofeducation";
                    System.out.println(schoolDataBaseName);
                    break;
                case "at":
                    schoolDataBaseName ="schoolofarts";
                    System.out.println(schoolDataBaseName);
                    break;
                default:
                    System.out.println("AN ERROR IS OCCURRINg PLEASE CHECK THE DATA GIVEN");
            }
            
                try {
                    // SELECTIN THE EXACT DATA.
                    String fname = "";
                    String lname = "";
                    Statement statement = connection.co.createStatement();
                    // String sql1 = "select fName,lName from '" + schoolDataBaseName + "' where admno = '"+values +"'";
                    String sql1 = "select fname , lName from  " +schoolDataBaseName+" where admno = '"+(String)values+"'";
                     
                     resultset = statement.executeQuery(sql1);
                     if( resultset.next()){
                         fname = resultset.getString("fName");
                         lname = resultset.getString("lName");
                         
                        
                     }
                      if(length == 1){
                   // INSERT THE ONE UNIT IN THE DATABASE.
                    System.out.println( " "+fname + " "+lname+ " "+ values);
                
               
                     //Statement statement2 = connection.co.createStatement();
                    String unit1 = units.get(0);
                    // unit1.replace("\\\\r || \\\\n ", " ");
                   // System.out.println(unit1);
                 //  System.out.println(System.getProperty("line.separator"));
                   String sql2 = "INSERT INTO registerunits (fname,lname,admno,unit1) values('"+ fname + "','"+ lname + "','" +values+"','"+unit1+"')";
                  // String sql2 = "insert into registerunits (fname,lname,admno,unit1) values ('"+fname+"','karis','ca567','uuduud')";
                    statement.executeUpdate(sql2);
                   System.out.println("THE DATA IS UPDATED");
               }  
                } catch (Exception ex) {
                   // Logger.getLogger(Units11Controller.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println(ex);
                }
            }
                   
                      
                    
            
          
          
        }
        
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        connection.Connect();
        try {
            Statement statement = connection.co.createStatement();
            String sql = "select password from  studentverification where username = '"+values+"'";
           // statement.executeQuery(sql);
          // ResultSet resultset ;
            resultset = statement.executeQuery(sql);
            if(resultset.next()){
                String number = resultset.getString(1);
                System.out.println("THE PASSWORD IS :"+number);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Units11Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      // System.out.println("THE BI BREAKTHROUH :" + values);
      
        try {
            // TODO
            ccs101.setFocusTraversable(false);
            ccs102.setFocusTraversable(false);
            ccs103.setFocusTraversable(false);
            ccs104.setFocusTraversable(false);
            ccs105.setFocusTraversable(false);
            ccs106.setFocusTraversable(false);
            
            //ADDING THE IMAGE IN THE IMAGEVIEW.
            File f = new File("src/images/maseno.png");
            Image image;
            try {
                image = new Image(f.toURI().toURL().toString());
                view.setImage(image);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Units11Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
       
    }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
    

