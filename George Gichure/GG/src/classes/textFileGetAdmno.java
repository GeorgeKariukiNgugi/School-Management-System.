/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Scanner;

/**
 *
 * @author George
 */
public class textFileGetAdmno {
      java.io.File file = new java.io.File("data.txt");
      java.io.PrintWriter  write = null;
      public  String value = "empryValue";
      public  String school = "empryValue";
     public void setText( String admno){
             try{
               if(file.exists()){
                 //  System.out.println("ERROR REPORTED.");
               
               
                write = new java.io.PrintWriter(file);
                write.print(admno);
               }
              }
              catch(Exception ex){
                  System.out.println("THERE IS SOMETHING WRONG.");
                  System.out.println(ex);
              }
              finally{
                  write.close();
              }
     }
             public String getText(){
            
                    try {      
                    Scanner scan = new Scanner(file);
                    value = scan.next();
                    System.out.println("This Is Gotten From The Class. "+value);
                } catch (Exception ex) {
                   // Logger.getLogger(StudentLogInController.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println(ex);
                }
                    return value;
             }
     
             public String getSchool(){
               try {      
                    Scanner scan = new Scanner(file);
                    value = scan.next();
                    System.out.println("This Is Gotten From The Class. "+value);
                    school = value.substring(0, 2);
                } catch (Exception ex) {
                   // Logger.getLogger(StudentLogInController.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println(ex);
                }
                    return school;
             
             }
}
