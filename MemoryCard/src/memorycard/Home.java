/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycard;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 *
 * @author rade
 */
class Home extends VBox  {
    private Button newGame = new Button("Nova igra");
    private Button help   = new Button("Pomoc!");
    private Button results   = new Button("Rezultati");
    
    
    public Home(){
        super(10);
        super.getChildren().addAll(newGame, help, results);
        super.setAlignment(Pos.CENTER);
        super.setPadding(new Insets(15,15,15,15));
        
        
        
    }

    public Button getNewGame() {
        return newGame;
    }

    public Button getHelp() {
        return help;
    }
    public Button getResultBtn() {
        return results;
    }
    
    
    
    
}
