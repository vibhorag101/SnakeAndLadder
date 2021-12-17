package assets.FXML;

import application.Main;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class gameBoardMaker {
    Pane gamePane;
    public gameBoardMaker(Pane gamePane){
        this.gamePane = gamePane;
    }
    public int GetXCord(int RowIndex){
        RowIndex = RowIndex-1;
        boolean startLeft = (((RowIndex/10)%2)==0);
        int rowNum = RowIndex%10;
        if (startLeft){
            return(rowNum*60+30);
        }
        else{
            return(600-(rowNum*60+30));
        }
    }
    public int GetYCord(int columnIndex){
        columnIndex = columnIndex-1;
        int columnNum = columnIndex/10;
        return(600-(columnNum*60+30));
    }
    public void LabelMaker(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                int presentNum = (i*10)+j+1;
                int xCord = GetXCord(presentNum);
                int yCord = GetYCord(presentNum);
                Text numText = new Text(Integer.toString(presentNum));
                numText.setLayoutX(xCord);
                numText.setLayoutY(yCord);
                numText.setFont(Font.loadFont(Main.rl.getPath("fonts/kenvector_future.ttf"), 14));
                gamePane.getChildren().add(numText);
            }
        }
    }
    public void pathMaker(int startNum , int endNum){
        int startX = GetXCord(startNum);
        int startY = GetYCord(startNum);
        int endX = GetXCord(endNum);
        int endY = GetYCord(endNum);
        Path path = new Path();
        MoveTo moveTo = new MoveTo(startX,startY);
        LineTo lineTo = new LineTo(endX,endY);
        path.getElements().addAll(moveTo,lineTo);
        gamePane.getChildren().add(path);
    }
    public void ladderMaker(int startNum , int endNum){
//        pathMaker(startNum,endNum);
        float startXL1 = GetXCord(startNum) -20;
        float startYL1 = GetYCord(startNum);
        float endXL1 = GetXCord(endNum)-20;
        float endYL1 = GetYCord(endNum);
        float startXL2 = GetXCord(startNum)+20;
        float startYL2 = GetYCord(startNum);
        float endXL2 = GetXCord(endNum) +20;
        float endYL2 = GetYCord(endNum);
        Line l1 = new Line(startXL1,startYL1,endXL1,endYL1);
        Line l2 = new Line(startXL2,startYL2,endXL2,endYL2);
        gamePane.getChildren().addAll(l1,l2);
        l1.setStroke(Color.web("#0d4517"));
        l1.setStrokeWidth(5);
        l2.setStroke(Color.web("#0d4517"));
        l2.setStrokeWidth(5);
        float slopeL1 = (startYL1-endYL1)/(startXL1-endXL1);
        float slopeL2 = (startYL2-endYL2)/(startXL2-endXL2);
        float nLadders = (startYL1-endYL1)/30;
        for (int i = 0; i < nLadders; i++){
            float YcordL1 = endYL1+ 15+ (i*30);
            float XcordL1 = (YcordL1-endYL1)/slopeL1 + endXL1;
            float YcordL2 = endYL2+ 15+ (i*30);
            float XcordL2 = (YcordL2-endYL2)/slopeL2 + endXL2;
            System.out.println(XcordL1+" "+YcordL1+" "+i);
            System.out.println(XcordL2+" "+YcordL2);
            System.out.println();
            Line l3 = new Line(XcordL1,YcordL1,XcordL2,YcordL2);
            l3.setStroke(Color.web("#0d4517"));
            l3.setStrokeWidth(5);
            gamePane.getChildren().add(l3);
        }
    }
}
