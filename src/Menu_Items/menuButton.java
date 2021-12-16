package Menu_Items;

import Game.gameStart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import application.Main;

public class menuButton extends Button {
    menuWindow popUp;
    String ButtonType;

    public menuButton(String text, String ButtonType, menuWindow window) {
        this.ButtonType = ButtonType;
        this.popUp = window;
        setText(text);
        setPrefWidth(190);
        setPrefHeight(49);
        String BUTTON_FREE_STYLE = "-fx-background-color: transparent;" +
                " -fx-background-image: url('/assets/button/red_button.png');";
        setStyle(BUTTON_FREE_STYLE);
        mouseEventHandler();
        setFont(Font.loadFont(Main.rl.getPath("fonts/kenvector_future.ttf"), 23));
    }

    private void mouseEventHandler() {

        setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());

            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setEffect(null);

            }
        });

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (ButtonType.equals("Start")) {
                    gameStart game = new gameStart();
                    Main.changeScene(game.getScene());
                }
                if (ButtonType.equals("Exit")) {
                    System.exit(0);
                }
                boolean notEqual = !(Menu.toBeHidden == popUp);
                if (Menu.toBeHidden != null) {
                    Menu.toBeHidden.animateSubScene();
                    Menu.toBeHidden = null;
                }
                if (popUp != null && notEqual) {
                    popUp.animateSubScene();
                    Menu.toBeHidden = popUp;
                }
            }
        });

    }

}