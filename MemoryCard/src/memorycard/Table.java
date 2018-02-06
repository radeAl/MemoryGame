package memorycard;

import java.net.MalformedURLException;
import java.util.Collections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import static memorycard.MemoryCard.cards;


/**
 *
 
 */
public class Table extends GridPane {
    Table() throws MalformedURLException{
        createCards();
        createPane();
        super.setAlignment(Pos.CENTER);
        Background background;
        background = new Background(new BackgroundFill(Color.rgb(17, 119, 255), CornerRadii.EMPTY, Insets.EMPTY));
        super.setBackground(background);
    }

    
    private void createCards() throws MalformedURLException {
        for (int i = 0; i < 8; i++) {
            Card c = new Card("Card" + i +".jpg", i);
            c.setOnMouseClicked(c);
            MemoryCard.cards.add(c);
            
            Card d = new Card(c);
            d.setOnMouseClicked(d);
            MemoryCard.cards.add(d);
        }
    }

    private void createPane(){
        Collections.shuffle(cards);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                super.add(cards.get(j+4*i), i, j);
            }
        }
    }
}
