package application;

import Menu_Items.Menu;
import assets.resourceLoader;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static resourceLoader rl = new resourceLoader();
    @Override
    public void start(Stage stage) throws Exception {
//        resourceLoader rl = new resourceLoader();
        Image logo = new Image(rl.getPath("Background/Menu_Background.jpg"));
        Menu menu = new Menu(850,600);
        stage.setScene(menu.getScene());
        stage.setTitle("Snake and Ladder Game");
        stage.getIcons().add(logo);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
