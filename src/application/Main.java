package application;

import Menu_Items.Menu;
import assets.resourceLoader;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        resourceLoader rl = new resourceLoader();
        Image logo = new Image(rl.getPath("Background/Menu_Background.jpg"));
        Menu menu = new Menu(800,600,rl);
        stage.setScene(menu.getScene());
        stage.setTitle("Snake and Ladder Game");
        stage.getIcons().add(logo);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
