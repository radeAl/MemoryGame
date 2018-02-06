/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycard;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Joco
 */
public class Help extends VBox {
    private Button backBtn;
    private TextArea content;
    
    String text = "Ovde se pise kako se igra to cete vi";
    
    
    public Help(){
        super(10);
        backBtn = new Button("Nazad");
        content = new TextArea(text);
        content.setEditable(false);
        super.getChildren().addAll(backBtn, content);
        super.setPadding(new Insets(10, 10, 10, 10));
    }

    public Button getBack() {
        return backBtn;
    }

    public TextArea getContent() {
        return content;
    }
    
    
}
