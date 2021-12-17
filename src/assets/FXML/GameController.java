package assets.FXML;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import Game.dice;
import Game.gameButton;

public class GameController {
    dice gameDice;
    int diceNum;
    gameButton player1;
    gameButton player2;
    gameButton exit;
    /* Initialising the components and injecting them into the controller */
    @FXML
    private VBox leftPane;
    @FXML
    private GridPane gamePane;
    @FXML
    private void initialize() {
        System.out.println("GameController initialized");
        initialiseLeftPane();
    }
    private void initialiseLeftPane(){
        player1 = new gameButton("Player 1","P1");
        player2 = new gameButton("Player 2","P2");
        exit = new gameButton("Exit","Exit");
        createDice();
        leftPane.getChildren().addAll(player1,gameDice.getDiceImage(),player2,exit);
        styleLeftPane();
        initialiseMouseHandler();
    }
    private void createDice(){
        gameDice = new dice();
    }
    private void styleLeftPane(){
        leftPane.setStyle("-fx-background-color: rgba(140,8,62,0.88);");
        gamePane.setStyle("-fx-background-color: #b9b913");
    }
    private void initialiseMouseHandler(){
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

}
