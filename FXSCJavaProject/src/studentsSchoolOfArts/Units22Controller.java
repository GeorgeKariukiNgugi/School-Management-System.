/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsSchoolOfArts;

import studentSchoolOfComputing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author George
 */
public class Units22Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    ImageView view;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         File f = new File("src/images/maseno.png");
            Image image;
            try {
                image = new Image(f.toURI().toURL().toString());
                view.setImage(image);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Units11Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }    
    
}
