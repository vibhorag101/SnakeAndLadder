package Menu_Items;

import assets.resourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.net.URISyntaxException;

public class Menu {
    resourceLoader rl;
    Scene scene;
    BorderPane mainPane;
    HBox TopPane;
    VBox LeftPane;
    public Menu(int Width,int Height,resourceLoader rl){
        this.rl = rl;
        InitialisePane();
        InitialiseScene(Width,Height);
    }
    private void InitialiseScene(int Width,int Height){
        this.scene = new Scene(mainPane,Width,Height);
    }
    private void InitialisePane(){
        this.mainPane = new BorderPane();
        this.TopPane = new HBox();
        this.LeftPane = new VBox();
        addTopBar();
        addLeftBar();
        mainPane.setPadding(new Insets(35,20,20,20));
        stylePane();

    }
    private void addTopBar(){
        Image logo = new Image(rl.getPath("Logo/logo.png"),100,100,false,false);
        ImageView logoView = new ImageView(logo);
        String FONT_PATH = "/assets/fonts/kenvector_future.ttf";
        Label projectName = new Label("   Snake and Ladders \n");
        projectName.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 50));
        projectName.setStyle("-fx-text-fill: #ffffff");
        TopPane.getChildren().add(logoView);
        TopPane.getChildren().add(projectName);
        TopPane.setAlignment(Pos.CENTER);
        mainPane.setTop(TopPane);
        TopPane.setPadding(new Insets(0,0,50,0));
    }
    private void addLeftBar(){
        menuButton Start = new menuButton("Start");
//        Button Start = new Button("Start");
        menuButton Info = new menuButton("Info");
        menuButton Credits = new menuButton("Credits");
        menuButton Exit = new menuButton("Exit");
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
        String path = rl.getPath("Background/pink.jpg");
        BackgroundImage bi = new BackgroundImage(new Image(path),BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,BackgroundPosition.CENTER,null);
        mainPane.setBackground(new Background(bi));
    }

    }
