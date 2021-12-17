package assets.FXML;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Game.dice;
import Game.gameButton;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;

public class GameController {
    playerControl pc;
    gameBoardMaker gb;
    dice gameDice;
    int diceNum;
    gameButton player1;
    gameButton player2;
    gameButton exit;
    /* Initialising the components and injecting them into the controller */
    @FXML
    private VBox leftPane;
    @FXML
    private Pane gamePane;
    @FXML
    private Circle P1;
    @FXML
    private Circle P2;
    @FXML
    private void initialize() {
        System.out.println("GameController initialized");
        initialiseGamePane();
        initialiseLeftPane();
//        initialiseGamePane();
    }
    private void initialiseGamePane(){
        this.gb = new gameBoardMaker(gamePane);
        gb.LabelMaker();
        styleGamePane();
        createLadderPaths();
        this.pc = new playerControl(P1,P2,gb);
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
        gameDice = new dice(pc);
    }
    private void styleLeftPane(){
        leftPane.setStyle("-fx-background-color: rgba(140,8,62,0.88);");
    }
    private void styleGamePane(){
        gamePane.setStyle("-fx-background-color: rgba(2,252,19,0.88);");
    }
    private void createLadderPaths(){
        gb.ladderMaker(4,25);
        gb.ladderMaker(8,31);
        gb.ladderMaker(28,46);
        gb.ladderMaker(32,48);
        gb.ladderMaker(42,80);
        gb.ladderMaker(58,77);
        gb.ladderMaker(52,68);
        gb.ladderMaker(69,93);
        gb.ladderMaker(84,98);
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

