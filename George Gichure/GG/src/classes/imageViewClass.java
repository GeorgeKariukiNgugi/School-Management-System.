/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author George
 */
public class imageViewClass {
    public ImageView view;
    
    public void getImage(){
           try {
            File f = new File("src/images/maseno.png");
            Image image = new Image(f.toURI().toURL().toString());
            view.setImage(image);
        } catch (MalformedURLException ex) {
           // Logger.getLogger(StudentHomePageController.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println(ex);
        }
    }
}
