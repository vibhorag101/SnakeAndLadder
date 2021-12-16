package Game;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import assets.resourceLoader;
import javafx.scene.image.ImageView;

public class dice extends Button {

    private final ImageView diceImage;
    private Image diceFace;
    private int randomNumber;
    public dice(){
        diceImage = new ImageView(new Image(Main.rl.getPath("Dice/1.png")));
    }
    private void generateRandomNumber(){
        randomNumber = (int)(Math.random()*6)+1;
    }
    public int getRandomNumber(){
        return(randomNumber);
    }
    public void setDiceFace(){
        int i=0;
        while (i<5){
            generateRandomNumber();
            Image diceFace = new Image(Main.rl.getPath("Dice/"+randomNumber+".png"));
            diceImage.setImage(diceFace);
            i++;
        }
    }

    private void DiceEventHandler(){
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setDiceFace();
            }
        });
    }
    public ImageView getDiceImage(){
        return(diceImage);
    }

}
