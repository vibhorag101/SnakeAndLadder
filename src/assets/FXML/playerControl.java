package assets.FXML;

import Game.gameButton;
import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.util.Duration;

import java.util.ArrayList;

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
    public int getLadderDest(int Start){
        return switch (Start) {
            case 4 -> 25;
            case 8 -> 31;
            case 28 -> 46;
            case 32 -> 48;
            case 42 -> 80;
            case 52 -> 68;
            case 58 -> 77;
            case 69 -> 93;
            case 84 -> 98;
            default -> 0;
        };
    }
    public Path getLadderPath(int intitialPos ,int ladderStart){
        Path path = new Path();
        ObservableList<PathElement> elementsPath = gb.getMovingPath(intitialPos, ladderStart).getElements();
        ObservableList<PathElement> elementsPathLadder = gb.pathMaker(ladderStart, getLadderDest(ladderStart)).getElements();
        elementsPath.addAll(elementsPathLadder);

        for (PathElement element : elementsPath) {
            path.getElements().add(element);
        }
        return path;
    }
    public void playAnimationOnLadder(Circle p, int pPos, int pDest) {
        PathTransition pathTransition = new PathTransition();
        Path path = new Path();
        if (pDest== 4){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 8){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 28){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 32){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 42){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 52){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 58){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 69){
            path = getLadderPath(pPos, pDest);
        }
        else if (pDest== 84){
            path = getLadderPath(pPos, pDest);
        }
        pathTransition.setPath(path);
        pathTransition.setAutoReverse(false);
        pathTransition.setNode(p);
        pathTransition.setDuration(Duration.seconds(3));
        pathTransition.setCycleCount(1);
        pathTransition.play();
    }
    public boolean checkOnLadder(int Destination){
        if (Destination==4 || Destination == 8 || Destination == 28 || Destination== 32
        || Destination == 42 || Destination ==58 || Destination == 52 || Destination == 69 ||
                Destination == 84) {
            return true;
        }
        else{
            return false;
        }
    }


    public void movePlayer(int diceNum){
        if (p1Turn) {
            if (!p1Unlocked && (diceNum == 1 || diceNum == 6)) {
                p1Unlocked = true;
            }
            p1Turn = false;
            p2Turn = true;
            if (p1Unlocked) {
                boolean onLadder;
                int p1Dest = p1Pos + diceNum;
                if (p1Dest <= 100) {
                    onLadder = checkOnLadder(p1Dest);
                    System.out.println("Ladder "+onLadder);
                    if(!onLadder){
                        playAnimation(p1, p1Pos, p1Dest);
                        p1Pos = p1Dest;
                    }
                    else{
                        playAnimationOnLadder(p1, p1Pos, p1Dest);
                        p1Pos = getLadderDest(p1Dest);
                    }

                }
                if (p1Dest==100){
                    p1Won = true;
                }
//                else if(p1Won || p2Won){
//                    System.exit(0);
//                }

            }

        } else {
            p2Turn = false;
            p1Turn = true;
            if (!p2Unlocked && (diceNum == 1 || diceNum == 6)) {
                p2Unlocked = true;
            }
            if (p2Unlocked) {
                boolean onLadder;
                int p2Dest = p2Pos + diceNum;
                if (p2Dest <= 100) {
                    onLadder = checkOnLadder(p2Dest);
                    System.out.println("Ladder "+onLadder);
                    if(!onLadder){
                        playAnimation(p2, p2Pos, p2Dest);
                        p2Pos = p2Dest;
                    }
                    else{
                        playAnimationOnLadder(p2, p2Pos, p2Dest);
                        p2Pos = getLadderDest(p2Dest);
                    }

                }
                if (p2Dest==100){
                    p2Won = true;
                }
//                else if (p2Won || p1Won){
//                    System.exit(0);
//                }

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
