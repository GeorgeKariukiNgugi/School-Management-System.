/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxscjavaproject;

import classes.imageViewClass;
import classes.loadNewPage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author George
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    public ComboBox cmbx;
    public ImageView view;
     
    @FXML
   // LOADING THE SPECIFIED OBJECT OF THE NECCESSARY CLASSES.
    loadNewPage newPage = new loadNewPage();
    imageViewClass loadImage = new imageViewClass();
    public void handleChaneInComboBox(ActionEvent event) {
        String value = (String) cmbx.getValue();
          
        value = value.toLowerCase();
          
          if ("student".equals(value)){
            newPage.loadNewPage("/studentLogIn/StudentLogIn.fxml");
            ((Node)(event.getSource())).getScene().getWindow().hide();
       
          }
           if ("lecturer".equals(value)){
                newPage.loadNewPage("/lecturerPage/LecturerLogIn.fxml");   
                ((Node)(event.getSource())).getScene().getWindow().hide();
       
                    }
           if("dean of school".equals(value)){
                newPage.loadNewPage("/studentSchoolOfComputing/trial.fxml");   
                ((Node)(event.getSource())).getScene().getWindow().hide();
          }
           if("non-teaching staff".equals(value)){
               newPage.loadNewPage("/nonTeachingStaffPortal/logInPage.fxml");
               ((Node)(event.getSource())).getScene().getWindow().hide();
           }
    }
         
        public void handleExit(ActionEvent e){
            System.exit(1);
        }  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
                File g = new File("C:/wamp64/www/Maseno clone/PHOTOS/maseno.png");
         try {
            Image image = new Image(g.toURI().toURL().toString());
            view.setImage(image);
            
        } catch (Exception  ex) {
            System.out.println(ex);
         System.out.println("something");
        }
         cmbx.getItems().addAll("STUDENT","LECTURER","DEAN OF SCHOOL","NON-TEACHING STAFF");
         cmbx.setValue("SELECT .... ");
        
    }      
    
}
