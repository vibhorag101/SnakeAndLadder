package Menu_Items;

import assets.resourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.*;
import java.net.URISyntaxException;

public class Menu {
    resourceLoader rl;
    Scene scene;
    BorderPane mainPane;
    HBox TopPane;
    VBox LeftPane;
    public Menu(int Width,int Height,resourceLoader rl) throws URISyntaxException {
        this.rl = rl;
        InitialisePane();
        InitialiseScene(Width,Height);
    }
    private void InitialiseScene(int Width,int Height){
        this.scene = new Scene(mainPane,Width,Height);
    }
    private void InitialisePane() throws URISyntaxException {
        this.mainPane = new BorderPane();
        this.TopPane = new HBox();
        this.LeftPane = new VBox();
        addTopBar();
        addLeftBar();
        mainPane.setPadding(new Insets(20,20,20,20));
        stylePane();

    }
    private void addTopBar(){
        Label projectName = new Label("Snake and Ladders by Vibhor Agarwal and Pritish Poswal");
        projectName.setFont(Font.font("Verdana",20));
        TopPane.getChildren().add(projectName);
        TopPane.setAlignment(Pos.CENTER);
        mainPane.setTop(TopPane);
        TopPane.setPadding(new Insets(0,0,50,0));
    }
    private void addLeftBar(){
        Button Start = new Button("Start");
        Button Info = new Button("Info");
        Button Credits = new Button("Credits");
        Button Exit = new Button("Exit");
        LeftPane.getChildren().addAll(Start,Info,Credits,Exit);
        LeftPane.setSpacing(15);
        mainPane.setLeft(LeftPane);
    }
    public BorderPane getMenu(){
        return mainPane;
    }
    public Scene getScene(){
        return scene;
    }
    private void stylePane(){
        String path = rl.getPath("Background/Blue-background.jpg");
        BackgroundImage bi = new BackgroundImage(new Image(path),BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,null);
        mainPane.setBackground(new Background(bi));
    }

    }
