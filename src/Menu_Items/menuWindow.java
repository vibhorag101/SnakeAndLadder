package Menu_Items;

import assets.resourceLoader;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import application.Main;
import javafx.util.Duration;

public class menuWindow extends SubScene {
    resourceLoader rl;
    StackPane root;
    boolean isHidden;

    public menuWindow(double width, double height) {
        super(new StackPane(), width, height);
        this.rl = Main.rl;
        this.isHidden = true;
        this.root = (StackPane) this.getRoot();
        prefHeight(height);
        prefWidth(width);
        stylePane();
        hideScene();
    }

    private void stylePane() {
//        setPosition();
        root.setBackground(createBackground(("Background/yellow.jpg")));
    }

    public void addText(String text) {
        Text t = new Text(text);
        root.getChildren().add(t);
        StackPane.setAlignment(t, Pos.CENTER);
        t.setFont(Font.loadFont(rl.getPath("fonts/kenvector_future.ttf"), 20));
    }

    public void animateSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1.5));
        transition.setNode(this);
        if (isHidden) {
            transition.setToX(10);
            isHidden = false;
        } else {
            transition.setToX(500);
            isHidden = true;
        }
        transition.play();
    }

    public void hideScene() {
        this.setTranslateX(540);
    }

    private Background createBackground(String pathString) {
        Image backgroundImage = new Image(rl.getPath(pathString));
        BackgroundImage bi = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, null);
        return new Background(bi);
    }

    private void setPosition() {
        // Border pane is a static method to add margin to the specified child of the pane.
        BorderPane.setMargin(this, new Insets(0, 0, 160, 0));
//        this.setLayoutY(-500);
    }


}
