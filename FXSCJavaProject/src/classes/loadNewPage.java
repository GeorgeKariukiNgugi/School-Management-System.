/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author George
 */
public class loadNewPage {
    
    public String name;
    
    public void loadNewPage(String name){
            try {
            Parent root1 = FXMLLoader.load(getClass().getResource(name));
             Stage stag = new Stage();
    
    stag.setTitle("NEW WINDOW.");
    stag.setScene(new Scene(root1));
    stag.setResizable(false);
    stag.show();
    
        } catch (Exception es) {
          System.out.println(es);
        }
    }
    
}
