/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author George
 */
public class getNameFromDataBase {
    // DEFINING THE OBJECT OF DATABASE CLASS.
    DatabaseConnection conn = new DatabaseConnection();
    schoolNameOfStudent schoolName = new schoolNameOfStudent();
    textFileGetAdmno file = new textFileGetAdmno();
    //DEFIN THE PUBLIC STRINGS.
    
     public String sql;
     public String name;
    
    public String getNameFromDataBaseTable(){
       schoolName.getSchoolNameOfStudent();
        conn.Connect();
        sql = "select concat(fName,'  ',lName) AS Name from  "+ schoolName.getSchoolNameOfStudent()+ " "+"   where admno = '"+file.getText()+"'";
        try {
            Statement statement =   conn.co.createStatement();
            ResultSet resultSet ;
            resultSet = statement.executeQuery(sql);
            
            if(resultSet.next()){
                name = resultSet.getString("Name");
                System.out.println("GOOD .....");
                System.out.println(name);
            }
            else{
                name = "NO RETURN A PROBLEM IS HERE.";
                System.out.println("BAAD .....");
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        return name;
    }
}
