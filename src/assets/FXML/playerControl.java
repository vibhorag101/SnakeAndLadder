package assets.FXML;

import javafx.animation.PathTransition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;

public class playerControl {
    gameBoardMaker gb;
    Circle p1;
    Circle p2;
    Boolean p1Turn,p2Turn;
    Boolean p1Unlocked,p2Unlocked;
    int p1Pos, p2Pos;
    public playerControl(Circle p1,Circle p2,gameBoardMaker gb){
        this.gb = gb;
        this.p1=p1;
        this.p2=p2;
        this.p1Turn= true;
        this.p2Turn = false;
        this.p1Unlocked= false;
        this.p2Unlocked= false;
        this.p1Pos=1;
        this.p2Pos = 1;
    }
    public void movePlayer(int diceNum){
        System.out.println("Dice num: "+diceNum);
        if (p1Turn){
            if(!p1Unlocked && (diceNum==1 || diceNum==6)){
                p1Unlocked=true;
            }
            p1Turn = false;
            p2Turn = true;
            if (p1Unlocked){
                int p1Dest = p1Pos + diceNum;
                if(p1Dest<=100){
                    ArrayList<Path> path = gb.getMovingPath(p1Pos,p1Dest);
                    if (path.size()==1){
                        PathTransition pathTransition = new PathTransition(Duration.seconds(1),path.get(0),p1);
                        pathTransition.setAutoReverse(false);
                        pathTransition.play();
                    }
                    else{
                        for (Path value : path) {
                            PathTransition pathTransition = new PathTransition(Duration.seconds(1), value, p1);
                            pathTransition.setAutoReverse(false);
                            pathTransition.play();
                        }
                    }
                }
                p1Pos= p1Dest;
            }

        }
        else{
            p2Turn = false;
            p1Turn = true;
            if(!p2Unlocked && (diceNum==1 || diceNum==6)){
                p2Unlocked=true;
            }
            if (p2Unlocked){
                int p2Dest = p2Pos + diceNum;
                if(p2Dest<=100){
                    ArrayList<Path> path = gb.getMovingPath(p2Pos,p2Dest);
                    if (path.size()==1){
                        System.out.println("Size 1");
                        PathTransition pathTransition = new PathTransition(Duration.seconds(1),path.get(0),p2);
                        pathTransition.setAutoReverse(false);
                        pathTransition.play();
                    }
                    else{
                        PathTransition pathTransition = new PathTransition();
                        for (Path value : path) {
                            pathTransition.setPath(value);
                            pathTransition.setAutoReverse(false);
                            pathTransition.setNode(p2);
                            pathTransition.setDuration(Duration.seconds(1));
                            pathTransition.setCycleCount(1);
                            pathTransition.play();
                        }
                    }
                }
                p2Pos= p2Dest;
            }
        }
    }

}
