package Game;

import Game.gameStart;
import Menu_Items.Menu;
import Menu_Items.menuWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import application.Main;

import java.io.IOException;
import java.net.URISyntaxException;

public class gameButton extends Button {
    String buttonType;
    public gameButton(String text,String buttonType) {
        this.buttonType = buttonType;
        setText(text);
        setPrefWidth(190);
        setPrefHeight(49);
        String BUTTON_FREE_STYLE = "-fx-background-color: transparent;" +
                " -fx-background-image: url('/assets/button/red_button.png');";
        setStyle(BUTTON_FREE_STYLE);
        setFont(Font.loadFont(Main.rl.getPath("fonts/kenvector_future.ttf"), 23));
    }

}
