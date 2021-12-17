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
    public void playAnimation(Circle p,int pPos,int pDest){
        PathTransition pathTransition = new PathTransition();
        pathTransition.setPath(gb.getMovingPath(pPos,pDest));
        pathTransition.setAutoReverse(false);
        pathTransition.setNode(p);
        pathTransition.setDuration(Duration.seconds(1.5));
        pathTransition.setCycleCount(1);
        pathTransition.play();
    }
    public void movePlayer(int diceNum){
        if (p1Turn){
            if(!p1Unlocked && (diceNum==1 || diceNum==6)){
                p1Unlocked=true;
            }
            p1Turn = false;
            p2Turn = true;
            if (p1Unlocked){
                int p1Dest = p1Pos + diceNum;
                if(p1Dest<=100){
                    playAnimation(p1,p1Pos,p1Dest);
                    p1Pos= p1Dest;
                }

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
                    //TODO complete the winning logic
                    playAnimation(p2,p2Pos,p2Dest);
                    p2Pos= p2Dest;
                }

            }
        }
    }

}
