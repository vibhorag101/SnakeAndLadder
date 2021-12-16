package application;

import Menu_Items.Menu;
import assets.resourceLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    private static Stage stage;
    public static resourceLoader rl = new resourceLoader();
    public static Scene scene;
    public static void changeScene(Scene scene){
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        Image logo = new Image(rl.getPath("Background/Menu_Background.jpg"));
        Menu menu = new Menu(850, 600);
        scene = menu.getScene();
        stage.setTitle("Snake and Ladder Game");
        stage.getIcons().add(logo);
        changeScene(scene);
    }
    /*
    TODO add method to change the scene as per choice from the start menu
     */

    public static void main(String[] args) {
        launch(args);
    }
}
