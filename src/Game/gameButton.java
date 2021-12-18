package Game;

import Game.gameStart;
import Menu_Items.Menu;
import Menu_Items.menuWindow;
import Winning_Menu.WinningMenuStart;
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
import Winning_Menu.WinningMenu;
import Winning_Menu.WinningMenuStart;
import java.io.IOException;
import java.net.URISyntaxException;

public class gameButton extends Button {
    String buttonType;
    gameButton g;
    public static String Player1;
    public static String Player2;
    public gameButton(String text, String buttonType) {
        this.g = this;
        this.buttonType = buttonType;
        setText(text);
        setStyle("-fx-background-color: #ff951f");
        if (!buttonType.equals("Exit")) {
            setPrefWidth(190);
            setPrefHeight(100);
            setFont(Font.loadFont(Main.rl.getPath("fonts/kenvector_future.ttf"), 25));
            setTextFill(Color.WHITE);
        } else {
            setPrefWidth(190);
            setPrefHeight(50);
            setFont(Font.loadFont(Main.rl.getPath("fonts/kenvector_future.ttf"), 35));
            setTextFill(Color.WHITE);
            setStyle("-fx-background-color: #6e0baf");
        }
    }

    public void updatePlayerTurn(String PlayerName) throws IOException, URISyntaxException {
        if (PlayerName.equals("Player1Won")) {
            Player1 = "Player1Won";
            Player2 = "Player2WLost";
            /*this.setStyle("-fx-background-color: #ff951f");
            */Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            WinningMenuStart menu = null;
                            try {
                                menu = new WinningMenuStart();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                            Main.changeScene(menu.getScene());
                            //Menu menu = new Menu(850, 600);
                            //Main.changeScene(menu.getScene());
                        }
                    });

                }
            });
            t.start();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    g.setText("Player 1\n" + " WON");
                }

            });
        } else if (PlayerName.equals("Player2Won")) {
            Player1 = "Player1Lost";
            Player2 = "Player2Won";
            /*this.setStyle("-fx-background-color: #ff951f");
            */Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            WinningMenuStart menu = null;
                            try {
                                menu = new WinningMenuStart();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                            Main.changeScene(menu.getScene());
                            //Menu menu = new Menu(850, 600);
                            //Main.changeScene(menu.getScene());
                        }
                    });
                }
            });
            t.start();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    g.setText("Player 2\n" + " WON");
                }
            });
        } else if (PlayerName.equals("Player1")) {
            this.setStyle("-fx-background-color: #ff951f");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    g.setText("Player 1\n" + " turn");
                }
            });
        } else {
            this.setStyle("-fx-background-color: #0fc6e0");
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    g.setText("Player 2\n" + " turn");
                }
            });
        }
    }

}
