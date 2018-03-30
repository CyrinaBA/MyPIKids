/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.AllForKids.gui;

import edu.AllForKids.entities.Offre;
import edu.AllForKids.services.CrudOffre;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddOffreController implements Initializable {

    @FXML
    private TextField NbrEnfantbtn;
    @FXML
    private TextField Servicebtn;
    @FXML
    private TextField Agebtn;
    @FXML
    private ChoiceBox<String> Tempsbtn;
    @FXML
    private DatePicker Datebtn;
    @FXML
    private ChoiceBox<String> Villebtn;
    @FXML
    private Button SendOffrebtn;
    @FXML
    private Button ResetOffrebtn;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("hhhh");
        // TODO
        ObservableList<String> temps =FXCollections.observableArrayList("Matin","Soir","Aprés midi","Tout au long du jour");
        Tempsbtn.setItems(temps);
        ObservableList<String> ville =FXCollections.observableArrayList("Tunis","Sousse","Sfax","Bizerte");
        Villebtn.setItems(ville); 
    }    

    @FXML
    private void SendOffre(ActionEvent event) throws SQLException, IOException {
       
        CrudOffre myTool = new CrudOffre();
        Offre o = new Offre();
        o.setParent_id(14);
        o.setBabysitter_id(13);
        int nbrEnfant=Integer.parseInt(NbrEnfantbtn.getText());
        o.setNbrEnfant(nbrEnfant);
        o.setService(Servicebtn.getText());
        int age=Integer.parseInt(Agebtn.getText());
        o.setAge(age);
        o.setTemps(Tempsbtn.getValue());
        
        o.setDateOffre(Date.valueOf(Datebtn.getValue()));
        
        o.setAccept(0);
        
        o.setVille(Villebtn.getValue());
        
        myTool.insertOffre(o);
        JOptionPane.showMessageDialog(null,"Offre Ajouté"); 
        
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("AfficheParentOffre.fxml"));
            Parent root = loader.load();
            
            SendOffrebtn.getScene().setRoot(root);
        
       
    }


    @FXML
    private void Reset(ActionEvent event) {
    }
    
    
    
}
