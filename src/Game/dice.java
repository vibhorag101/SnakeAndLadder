package Game;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.image.Image;
import assets.resourceLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class dice {
    int height;
    int width;

    private final ImageView diceImage;
    private Image diceFace;
    private int randomNumber;

    public dice() {
        this.height = 85;
        this.width = 85;
        diceImage = new ImageView(new Image(Main.rl.getPath("Dice/1.png"), width, height, false, true));
        DiceEventHandler();

    }

    private void generateRandomNumber() {
        randomNumber = (int) (Math.random() * 6) + 1;
    }

    public int getRandomNumber() {
        return (randomNumber);
    }

    public void setDiceFace() throws InterruptedException {
        int i = 0;
        while (i < 10) {
            generateRandomNumber();
            Image diceFace = new Image(Main.rl.getPath("Dice/" + randomNumber + ".png"), width, height, false, true);
            diceImage.setImage(diceFace);
            Thread.sleep(50);
            i++;
        }
    }

    private void DiceEventHandler() {
        diceImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            setDiceFace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                t.start();
            }
        });
    }

    public ImageView getDiceImage() {
        return (diceImage);
    }

}
