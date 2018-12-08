/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


public class schoolNameOfStudent {
    // GETTING THE TEXTFILE CLASS .
    textFileGetAdmno file = new textFileGetAdmno();
    public String schoolName = "school";
    public String admnoNumber = "empryValue";
    
    public String getSchoolNameOfStudent(){
        admnoNumber = file.getSchool();
        switch (admnoNumber){
            case "ci":
                schoolName = "schoolofcomputing";
                break;
            case "mt":
                schoolName = "schoolofmaths";
                break;
            case "ed":
                schoolName = "schoolofeducation";
                break;
            case "at":
                schoolName = "schoolofarts";
                break;
            case "sc":
                schoolName = "schoolofbioloicalandpysicalsciences";
                break;
        }
        return  schoolName;
        
    }
}
