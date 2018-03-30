/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.AllForKids.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class OffreMainFx extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception {
       
 //Parent root = FXMLLoader.load(getClass().getResource("AddOffre.fxml"));
           // Scene scene = new Scene();
            primaryStage.setTitle("Hello World!");
           // primaryStage.setScene(scene);
            primaryStage.show();
    }
    
       public static void main(String[] args) {
        launch(args);
    }
    
}
