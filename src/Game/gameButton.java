package Game;

import Game.gameStart;
import Menu_Items.Menu;
import Menu_Items.menuWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import application.Main;

import java.io.IOException;
import java.net.URISyntaxException;

public class gameButton extends Button {
    String buttonType;
    gameButton g;
    public gameButton(String text,String buttonType) {
        this.g = this;
        this.buttonType = buttonType;
        setText(text);
        setPrefWidth(190);
        setPrefHeight(100);
        setStyle("-fx-background-color: #ff951f");
        if(!buttonType.equals("Exit")) {
            setFont(Font.loadFont(Main.rl.getPath("fonts/kenvector_future.ttf"), 18));
            setTextFill(Color.WHITE);
        }
        else{
            setFont(Font.loadFont(Main.rl.getPath("fonts/kenvector_future.ttf"), 35));
            setTextFill(Color.WHITE);
            setTextFill(Color.WHITE);
        }
    }
    public void updatePlayerTurn(String PlayerName){
        if (PlayerName.equals("Player1")){
            this.setStyle("-fx-background-color: #ff951f");
//            this.setText("Player 1\n"+" turn");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    g.setText("Player 1\n"+" turn");
                }
            });
        }
        else{
            this.setStyle("-fx-background-color: #0fc6e0");
//            this.setText("Player 2\n"+" turn");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    g.setText("Player 2\n"+" turn");
                }
            });
        }
    }

}
