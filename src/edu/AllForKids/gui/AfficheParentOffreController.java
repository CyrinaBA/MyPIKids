/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.AllForKids.gui;

import com.jfoenix.controls.JFXButton;
import edu.AllForKids.entities.Offre;
import edu.AllForKids.services.CrudOffre;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheParentOffreController implements Initializable {
    

    @FXML
    private TableColumn<Offre,Integer> id_bbTab;
    @FXML
    private TableColumn<Offre,Integer> nbrenfTab;
    @FXML
    private TableColumn<Offre,String> servTab;
    @FXML
    private TableColumn<Offre,Integer> ageTab;
    @FXML
    private TableColumn<Offre,Date> dateTab;
    @FXML
    private TableColumn<Offre,String> temTab;
    
    @FXML
    private TableColumn<Offre,String> villeTab;
    @FXML
    private TableColumn<Offre,String> etatTab;
    @FXML
    private TableView<Offre> TabPar;



    @FXML
    private AnchorPane Popup;
    @FXML
    private JFXButton Modify;
    @FXML
    private JFXButton Delete;
    
    Boolean left = true;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        

        Popup.setVisible(false);
        
        
        CrudOffre crudoffre=new CrudOffre();
        List<Offre> myList= (ArrayList) crudoffre.findByParent(16);
        ObservableList<Offre> data=FXCollections.observableArrayList();
        for(Offre o : myList)
        {
         data.add(o);
        }
        
        System.out.println(data);
        TabPar.setItems(data);
        //ObservableList observableList = FXCollections.observableArrayList(arrayList);
        
      id_bbTab.setCellValueFactory(new PropertyValueFactory<>("babysitter_id"));
        nbrenfTab.setCellValueFactory(new PropertyValueFactory<>("NbrEnfant"));
        servTab.setCellValueFactory(new PropertyValueFactory<>("Service"));
       ageTab.setCellValueFactory(new PropertyValueFactory<>("Age"));
       dateTab.setCellValueFactory(new PropertyValueFactory<>("DateOffre"));
        temTab.setCellValueFactory(new PropertyValueFactory<>("temps"));
        villeTab.setCellValueFactory(new PropertyValueFactory<>("ville"));
        etatTab.setCellValueFactory(new PropertyValueFactory<>("Accept"));
        etatTab.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Offre, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Offre, String> param) {
            if(param.getValue().getAccept()==0)
            {
                return new SimpleStringProperty("En attente");
            }
            return new SimpleStringProperty("Accepte");
            }
        });
        
        TabPar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) { 
                
          if(left) {
            Popup.setTranslateX(event.getX());
            Popup.setTranslateY(event.getY());
            Popup.setVisible(true);
            left=false;
          } else {
              Popup.setVisible(false);
              left=true;
          }
            }
        });
          
    }    
    
}
