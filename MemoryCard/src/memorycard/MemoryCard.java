/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycard;



import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Joco
 */




public class MemoryCard extends Application {
    public static List<Card> cards = new ArrayList<>();
    public static Card first = null;
    public static int bodovi = 0;
    public static int opened;
    

    static void gameOver() {
        String name = null;
        Records r = new Records();
        
        Stage dialog = new Stage();
        VBox content = new VBox(15);
        Label message = new Label("Uspjesno! Vas rezultat je " + bodovi + ". Upisite Vase ime");
        TextField getName = new TextField();
        Button save = new Button("Save");
        
        content.getChildren().addAll(message, getName, save);
        content.setPadding(new Insets(15,15,15,15));
        Scene dialogScene = new Scene(content, 400, 200);
        dialog.setScene(dialogScene);
        dialog.show();
        
        save.setOnMouseClicked(e ->{
            r.getResults();
            r.addResult(getName.getText().trim(), bodovi);
            r.saveResults();
            
            dialog.close();
        });
   }
   
    public void start(Stage primaryStage) throws MalformedURLException {
        
        Table table = new Table();;
        Home home = new Home();
        Help help = new Help();

        
        
        
        home.getNewGame().setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            public void handle(MouseEvent event) {
                Scene scene1 =  new Scene(table, 600, 600);
                primaryStage.setScene(scene1);
            }
        });
        
        home.getHelp().setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            public void handle(MouseEvent event) {
                Scene scene2 =  new Scene(help, 600, 600);
                primaryStage.setScene(scene2);
            }
        });
        
        help.getBack().setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            public void handle(MouseEvent event) {
                Scene scene1 =  new Scene(table, 600, 600);
                primaryStage.setScene(scene1);
               
            }
        });
        
       home.getResultBtn().setOnMouseClicked(e ->{
           Stage resultStage = new Stage();
           TextArea resultList = new TextArea(Records.getResults());
           resultList.setEditable(false);
           Pane pane = new Pane();
           pane.getChildren().add(resultList);
           pane.setPadding(new Insets(20,20,20,20));
           
           resultStage.setScene(new Scene(pane, 450, 450));
           resultStage.show();
       
       
       });
       
       Scene scene = new Scene(home, 600, 600); 
        
        primaryStage.setTitle("Igra memorije");
        primaryStage.show();
        primaryStage.setScene(scene);
        
       
    }

    
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
