package memorycard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author rade
 */
public class Card extends StackPane implements EventHandler<MouseEvent> {

    private String url;
    private int pokusaja = 0;
    private Image faceImage;
    private Image backImage;
    private ImageView image;
    private boolean faceUp = false;
    private int num;
    private boolean isOpen = false;

    public Card(String url, int num) {

        super();
        this.url = url;
        Path path = Paths.get(url);

        String pathURL = null;
        try {
            pathURL = path.toUri().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MemoryCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.faceImage = new Image(pathURL);
        path = Paths.get("CardCover.jpg");
        try {
            pathURL = path.toUri().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        backImage = new Image(pathURL);
        this.num = num;

        this.image = new ImageView(this.backImage);
        image.setFitHeight(120);
        image.setFitWidth(70);
        super.getChildren().add(this.image);

    }

    public Card(Card c) {
        this.url = c.url;
        Path path = Paths.get(this.url);

        String pathURL = null;
        try {
            pathURL = path.toUri().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(MemoryCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.faceImage = new Image(pathURL);
        path = Paths.get("CardCover.jpg");
        try {
            pathURL = path.toUri().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Card.class.getName()).log(Level.SEVERE, null, ex);
        }
        backImage = new Image(pathURL);
        this.num = c.num;

        this.image = new ImageView(this.backImage);
        image.setFitHeight(120);
        image.setFitWidth(70);
        super.getChildren().add(this.image);
        super.setPadding(new Insets(5,5,5,5));

    }

    public Image getFaceImage() {
        return faceImage;
    }

    public Image getBackImage() {
        return backImage;
    }

    public ImageView getImage() {
        return image;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public int getNum() {
        return num;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean o) {
        isOpen = o;
    }

    public void open() {
        this.isOpen = true;
        this.image.setImage(faceImage);

    }

    public void close() {
        if (isOpen) {
            this.image.setImage(backImage);
            isOpen = false;
        }
    }

    
    public void handle(MouseEvent event) {
        if(this.isOpen == true)
            return;
        Timer timer = new Timer();
        this.open();
        if (MemoryCard.first == null) {

            MemoryCard.first = this;
        } 
        else {
            if (this.getNum() != MemoryCard.first.getNum()) {
                Card c = this;
                this.pokusaja ++;
                timer.schedule(new TimerTask() {
                    public void run() {
                        MemoryCard.first.close();
                        c.close();
                        MemoryCard.first = null;
                    }
                }, (long) (0.5 * 1000));
                

            }
            else{
                MemoryCard.bodovi += 10 - this.pokusaja - MemoryCard.first.pokusaja;
                MemoryCard.first.isOpen = true;
                MemoryCard.first = null;
                this.isOpen = true;
                MemoryCard.opened++;
                
                if (MemoryCard.opened == 8){
                    MemoryCard.gameOver();
                }
                
            }
        }
    }
}


