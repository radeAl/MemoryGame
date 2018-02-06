/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memorycard;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardView extends ImageView{

    private String url;
    private Image faceImage;
    private Image backImage;
    private ImageView image;
    
    public CardView(){
    
    }

    public CardView(String url) throws MalformedURLException {
        
        this.url = url;
        Path path = Paths.get(url);

        String pathURL = null;
        pathURL = path.toUri().toURL().toString();
        this.faceImage = new Image(pathURL);
        path = Paths.get("CardCover.jpg");
        pathURL = path.toUri().toURL().toString();
        backImage = new Image(pathURL);
        this.image = new ImageView(this.backImage);
        image.setFitHeight(120);
        image.setFitWidth(70);
    }

    public String getUrl() {
        return url;
    }

    public Image getFaceImage() {
        return faceImage;
    }

    public Image getBackImage() {
        return backImage;
    }


   
    
}
