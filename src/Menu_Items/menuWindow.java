package Menu_Items;
import assets.resourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class menuWindow extends SubScene {
    resourceLoader rl;
    StackPane root;

    public menuWindow(double width, double height,resourceLoader rl) {
        super(new StackPane(), width, height);
        this.rl = rl;
        this.root = (StackPane) this.getRoot();
        prefHeight(height);
        prefWidth(width);
        stylePane();
    }
    private void stylePane(){
        setPosition();
        root.setBackground(createBackground(("Background/yellow.jpg")));
        addText("Welcome to the game!");
    }
    private void addText(String text){
        Text t = new Text(text);
        root.getChildren().add(t);
        StackPane.setAlignment(t, Pos.CENTER);
    }
    private Background createBackground(String pathString){
        Image backgroundImage = new Image(rl.getPath(pathString));
        BackgroundImage bi = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,null);
        return new Background(bi);
    }
    private void setPosition(){
        // Border pane is a static method to add margin to the specified child of the pane.
        BorderPane.setMargin(this,new Insets(0,0,160,0));
    }


}
