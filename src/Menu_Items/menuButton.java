package Menu_Items;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class menuButton extends Button {

    public menuButton(String text) {
        setText(text);
        setPrefWidth(190);
        setPrefHeight(49);
        String BUTTON_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/assets/button/red_button.png');";
        setStyle(BUTTON_FREE_STYLE);
        mouseEventHandler();
        String FONT_PATH = "/assets/fonts/kenvector_future.ttf";
        setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));
    }
    private void mouseEventHandler() {

        setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());

            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setEffect(null);

            }
        });

    }

}