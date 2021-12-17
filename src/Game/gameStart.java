package Game;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class gameStart {
    Scene scene;
    BorderPane root;
    dice d;

    public gameStart() throws IOException, URISyntaxException {
//        System.out.println(Main.rl.getPath("FXML/Game.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.rl.getURL("FXML/Game.fxml"));
        Parent fxmlRoot = fxmlLoader.load();
//        this.root = new BorderPane();
        this.scene = new Scene(fxmlRoot, 800, 600);
//        root.setTop(new Button("Start"));
//        root.setCenter(d.getDiceImage());

    }

    public Scene getScene() {
        return this.scene;
    }

}
