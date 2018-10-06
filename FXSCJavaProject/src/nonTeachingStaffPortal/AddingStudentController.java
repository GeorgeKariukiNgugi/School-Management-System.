/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonTeachingStaffPortal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author George
 */

public class AddingStudentController implements Initializable {

    @FXML
    public ComboBox campus ;
    public ComboBox beginYear ;
    public ComboBox school;
    public Label lblPost;
    public Label lblPrefix;
    public JFXButton next;
    public Label lblpre;
    public Label lblpost;
    public ComboBox depertment;
    public ComboBox programme;
    public JFXTextField admNos;
    public JFXTextField fname;
    public JFXTextField lname;
    public JFXTextField sname;
    public JFXTextField phone;
    public JFXTextField email;
    public JFXTextField idNo;
    public JFXRadioButton male;
    public JFXRadioButton female;
    public Label control; 
    
    // CREATING ARRAYLISTS FOR THE DEPERMENTS .
    
    // School Of Computing.
    
    ArrayList<String> SCIDepertments = new ArrayList<>();
    ArrayList<String> SCIProgramme = new ArrayList<>();
    
    //School Of Arts.
  
    ArrayList<String> SADepertments = new ArrayList<>();
    ArrayList<String> SAProgramme = new ArrayList<>();
    
    //School Of Education.
    
    ArrayList<String> SEDepertments = new ArrayList<>();
    ArrayList<String> SEProgramme = new ArrayList<>();
    
    // THE METHOD CALLED WHEN THE CMBOBOX IS CLICKED.
   
    
    public void HandleComboBoxSchool(ActionEvent event){
       depertment.setDisable(false);
       depertment.setValue("SELECT DEPERTMENT.");
       String value = school.getValue().toString().toLowerCase();
       String year = beginYear.getValue().toString();
      switch(value){
          case  "school of computing":
             // HandleClear();
               depertment.getItems().clear();
               SCIDepertments.clear();
               SCIDepertments.add("CompTech");
               SCIDepertments.add("CompScience");
               depertment.getItems().addAll(SCIDepertments);
              lblpre.setText("CI");
              break;
          case  "school of education":
              //  HandleClear();
                depertment.getItems().clear();
               SEDepertments.clear();
               SEDepertments.add("Arts.");
               SEDepertments.add("Science.");
              depertment.getItems().addAll(SEDepertments);
               lblpre.setText("ED");
              break;
          case  "school of arts":
              // HandleClear();
                depertment.getItems().clear();
               SADepertments.clear();
               SADepertments.add("Criminology.");
               SADepertments.add("Fine Arts.");
               depertment.getItems().addAll(SADepertments);
               lblpre.setText("AT");
              break;
          default:
               depertment.setValue("SELECT DEPERTMENT.");
              break;
              
      }
       switch(year){
                     case "2016":
                         lblpost.setText("016");
                         break;
                           case "2017":
                         lblpost.setText("017");
                         break;
                           case "2018":
                         lblpost.setText("018");
                         break;
                 }
    } 
    
     public void HandleComboboxDepertment(ActionEvent event){
         //depertment.setValue("SELECT DEPERTMENT.");
         String value2 = depertment.getValue().toString().toLowerCase();
         programme.setDisable(false);
       
         switch(value2){
             case "comptech":
                  // HandleClear();
                  programme.getItems().clear();
                  SCIProgramme.clear();
                  SCIProgramme.add("Bsc.Comp Science");
                  SCIProgramme.add("Bsc.Comp Engeneering");
                  programme.getItems().addAll(SCIProgramme);
                 break;
             case "compscience":
                  // HandleClear();
                  programme.getItems().clear();
                  SCIProgramme.clear();
                  SCIProgramme.add("Bsc.Comp Technology"); 
                  SCIProgramme.add("Bsc. Hardware Engeneering."); 
                  programme.getItems().addAll(SCIProgramme);
                 break;
             case "arts.":
                   // HandleClear();
                     programme.getItems().clear();
                    SEProgramme.clear();
                   SEProgramme.add("Bsc.Kiswahili"); 
                   SEProgramme.add("Bsc.English Literature."); 
                   programme.getItems().addAll(SEProgramme);
                 break;
             case "science.":
                 // HandleClear();
                     programme.getItems().clear();
                  SEProgramme.clear();
                 SEProgramme.add("Bsc.Edu Science"); 
                 SEProgramme.add("Bsc.Sport Science"); 
                 programme.getItems().addAll(SEProgramme);
                 break;
             case "criminology.":
                // HandleClear();
                     programme.getItems().clear();
                  SAProgramme.clear();
                 SAProgramme.add("Bsc Criminology"); 
                 SAProgramme.add("Bsc Forensics"); 
                 programme.getItems().addAll( SAProgramme);
                 break;
             case "fine arts.":
                 // HandleClear();
                     programme.getItems().clear();
                  SAProgramme.clear();
                 SAProgramme.add("Bsc. Fine Arts"); 
                 SAProgramme.add("Bsc. Apparel Arts"); 
                 programme.getItems().addAll(SAProgramme);
                 
                 break;
             default:
                 
                 break;      
         }
         
        }
     public void HandleComboBoxProramme(ActionEvent event){
        //  programme.setValue("SELECT PROGRAMME.");
         lblpre.setDisable(false);
         lblpost.setDisable(false);
         next.setDisable(false);
         admNos.setDisable(false);
     }
      public void HandleClear(){
            SEProgramme.clear();
            SEDepertments.clear();
            SAProgramme.clear();
            SADepertments.clear();
            SCIProgramme.clear();
            SCIDepertments.clear();
            programme.getItems().clear();
             depertment.getItems().clear();
            
      }
      public void HandleNext(ActionEvent event){
        
          if("".equals(fname.getText())){
            
             fname.setPromptText("FILL IN THIS VALUE.");
          }
          else if("".equals(lname.getText())){
            
             lname.setPromptText("FILL IN THIS VALUE.");
            // lname.getText().setFont("","","","");
          }
          else if("".equals(sname.getText())){
            
             sname.setPromptText("FILL IN THIS VALUE.");
          }
          else if("".equals(email.getText())){
            
             email.setPromptText("FILL IN THIS VALUE.");
          }
          else if("".equals(phone.getText())){
            
             phone.setPromptText("FILL IN THIS VALUE.");
          }
          else if("".equals(idNo.getText())){
            
             idNo.setPromptText("FILL IN THIS VALUE.");
          }
          else if(!(male.isSelected()) && !(female.isSelected())){
              control.setVisible(true);
              control.setText("SET THE GENDER OF STUDENT.");
          }
          else if(beginYear.getValue().toString().equals("Choose Year .") ){
              control.setVisible(true);
              control.setText("SET THE YEAR OF ADDMISSION OF THE STUDENT."); 
          }
          else if((campus.getValue().toString()).equals("Select Campus .")){
               control.setVisible(true);
              control.setText("SET THE CAMPUS OF THE STUDENT."); 
          } 
          else if(programme.getValue().toString().toLowerCase().equals("")){
                 control.setVisible(true);
              control.setText("SET THE PROGRAMME OF THE STUDENT."); 
          }
          else if("".equals(admNos.getText())){
               control.setVisible(true);
              control.setText("SET THE ADMISSON NUMBER F THE STUDENT.");
          }
          else{
            control.setVisible(true);
              control.setText("ALL VALUES SET.");
          }
      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Integer> years = new ArrayList<>();
        for(int i = 2016 ; i <= 2018 ; i++){
            years.add(i);
        }
        // TODO
        campus.getItems().addAll("Main Campus.","City Campus","Homa-Bay Campus");
        campus.setValue("Select Campus .");
        beginYear.getItems().addAll(years);
        beginYear.setValue("Choose Year .");
        school.getItems().addAll("School Of Computing","School Of Education","School Of Arts","School Of Medicine");
        school.setValue("SELECT A SCHOOL  .");
        programme.setValue("SELECT PROGRAMME.");
        depertment.setValue("SELECT DEPERTMENT.");
    }    
    
}
