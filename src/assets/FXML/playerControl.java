package assets.FXML;

import Game.gameButton;
import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class playerControl {
    gameBoardMaker gb;
    Circle p1;
    Circle p2;
    gameButton turnInfo;
    Boolean p1Turn, p2Turn;
    Boolean p1Unlocked, p2Unlocked;
    Boolean p1Won, p2Won;
    int p1Pos, p2Pos;

    public playerControl(Circle p1, Circle p2, gameButton turnInfo, gameBoardMaker gb) {
        this.gb = gb;
        this.p1 = p1;
        this.p2 = p2;
        this.turnInfo = turnInfo;
        this.p1Turn = true;
        this.p2Turn = false;
        this.p1Unlocked = false;
        this.p2Unlocked = false;
        this.p1Pos = 1;
        this.p2Pos = 1;
        this.p2Won= false;
        this.p1Won = false;
    }

    public void playAnimation(Circle p, int pPos, int pDest) {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(gb.getMovingPath(pPos, pDest));
        pathTransition.setAutoReverse(false);
        pathTransition.setNode(p);
        pathTransition.setDuration(Duration.seconds(1.5));
        pathTransition.setCycleCount(1);
        pathTransition.play();
    }

    public void movePlayer(int diceNum){
        if (p1Turn) {
            if (!p1Unlocked && (diceNum == 1 || diceNum == 6)) {
                p1Unlocked = true;
            }
            p1Turn = false;
            p2Turn = true;
            if (p1Unlocked) {
                int p1Dest = p1Pos + diceNum;
                if (p1Dest <= 100) {
                    playAnimation(p1, p1Pos, p1Dest);
                    p1Pos = p1Dest;
                }
                if (p1Dest==100){
                    p1Won = true;
                }
                else if(p1Won || p2Won){
                    System.exit(0);
                }

            }

        } else {
            p2Turn = false;
            p1Turn = true;
            if (!p2Unlocked && (diceNum == 1 || diceNum == 6)) {
                p2Unlocked = true;
            }
            if (p2Unlocked) {
                int p2Dest = p2Pos + diceNum;
                if (p2Dest <= 100) {
                    //TODO complete the winning logic
                    playAnimation(p2, p2Pos, p2Dest);
                    p2Pos = p2Dest;
                }
                if (p2Dest==100){
                    p2Won = true;
                }
                else if (p2Won || p1Won){
                    System.exit(0);
                }

            }
        }
    }

    public void updateTurnInfo() {
        if (p1Won) {
            turnInfo.updatePlayerTurn("Player1Won");
        }
        else if(p2Won){
            turnInfo.updatePlayerTurn("Player2Won");
        }
        else if (p1Turn) {
            turnInfo.updatePlayerTurn("Player1");
        } else {
            turnInfo.updatePlayerTurn("Player2");
        }
    }

}
