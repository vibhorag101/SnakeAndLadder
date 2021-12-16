package Game;

import application.Main;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class gameStart {
    Scene scene;
    BorderPane root;
    dice d;
    public gameStart(){
        this.root = new BorderPane();
        this.scene = new Scene(root, 800,600);
        this.d = new dice();
        root.setTop(new Button("Start"));
        root.setCenter(d);

    }
    public Scene getScene(){
        return this.scene;
    }

}
