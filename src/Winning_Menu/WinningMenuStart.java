package Winning_Menu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URISyntaxException;
public class WinningMenuStart {
    Scene scene;
    public WinningMenuStart() throws IOException, URISyntaxException {
        Parent root = FXMLLoader.load(getClass().getResource("Winning_Menu.fxml"));
        this.scene = new Scene(root,800,600);
    }
    public Scene getScene() {
        return this.scene;
    }
}
