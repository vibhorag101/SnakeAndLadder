package Menu_Items;

import assets.resourceLoader;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import application.Main;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class Menu {
    static menuWindow toBeHidden = null;
    resourceLoader rl;
    Scene scene;
    BorderPane mainPane;
    HBox TopPane;
    VBox LeftPane;
    ArrayList<menuWindow> subSceneList;

    public Menu(int Width, int Height) {
        this.rl = Main.rl;
        this.subSceneList = new ArrayList<>();
        InitialisePane();
        InitialiseScene(Width, Height);

    }

    private void makeAllSubScenes() {
        menuWindow infoSubScene = initialiseSubScene(500, 300);
        menuWindow creditSubScene = initialiseSubScene(500, 300);
        infoSubScene.addText("Info Scene");
        creditSubScene.addText("Credits Scene");
        subSceneList.add(infoSubScene);
        subSceneList.add(creditSubScene);

        /*
        creating a container to add all the subscenes to and
        then adding the container to the center of the borderpane and positioning
        container using setMargin.
        */
        StackPane menuContainer = new StackPane();
        menuContainer.getChildren().addAll(creditSubScene, infoSubScene);
        mainPane.setCenter(menuContainer);
        BorderPane.setMargin(menuContainer, new Insets(0, 0, 160, 0));
    }

    private menuWindow initialiseSubScene(int width, int height) {
        return (new menuWindow(width, height));
    }

    private void InitialiseScene(int Width, int Height) {
        this.scene = new Scene(mainPane, Width, Height);
    }

    private void InitialisePane() {
        this.mainPane = new BorderPane();
        this.TopPane = new HBox();
        this.LeftPane = new VBox();
        makeAllSubScenes();
        addTopBar();
        addLeftBar();
        mainPane.setPadding(new Insets(35, 20, 20, 20));
        stylePane();

    }

    private void addTopBar() {
        Image logo = new Image(rl.getPath("Logo/logo.png"), 100, 100, false, false);
        ImageView logoView = new ImageView(logo);
        String FONT_PATH = "/assets/fonts/kenvector_future.ttf";
        Label projectName = new Label("   Snake and Ladders \n");
        projectName.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 50));
        projectName.setStyle("-fx-text-fill: #ffffff");
        TopPane.getChildren().add(logoView);
        TopPane.getChildren().add(projectName);
        TopPane.setAlignment(Pos.CENTER);
        mainPane.setTop(TopPane);
        TopPane.setPadding(new Insets(0, 0, 50, 0));
    }

    private void addLeftBar() {
        menuButton Start = new menuButton("Start","Start", null);
        menuButton Info = new menuButton("Info","Info", subSceneList.get(0));
        menuButton Credits = new menuButton("Credits","Credits", subSceneList.get(1));
        menuButton Exit = new menuButton("Exit","Exit", null);
        LeftPane.getChildren().addAll(Start, Info, Credits, Exit);
        LeftPane.setSpacing(15);
        mainPane.setLeft(LeftPane);
    }

    private void stylePane() {
        String path = rl.getPath("Background/pink.jpg");
        BackgroundImage bi = new BackgroundImage(new Image(path), BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, null);
        mainPane.setBackground(new Background(bi));
        BorderPane.setMargin(LeftPane, new Insets(25, 0, 0, 0));
    }

    //getters and setters function
    public BorderPane getMenu() {
        return mainPane;
    }

    public Scene getScene() {
        return scene;
    }

}
