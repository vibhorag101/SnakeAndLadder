package Winning_Menu;
import Game.gameStart;
import Menu_Items.Menu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import application.Main;
import javafx.event.ActionEvent;
import Game.gameButton;
import java.io.IOException;
import java.net.URISyntaxException;

public class WinningMenu {
    @FXML
    public Label LoserLabel;

    @FXML
    private Button Menubutton;

    @FXML
    private Button ReplayButton;

    @FXML
    public Label WinnerLabel;
    @FXML
    void OpenMenu(ActionEvent event) {
        Menu menu = new Menu(850, 600);
        Main.changeScene(menu.getScene());
    }

    @FXML
    void ReloadGame(ActionEvent event) {
        gameStart game = null;
        try {
            game = new gameStart();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        assert game != null;
        Main.changeScene(game.getScene());
    }
    @FXML
    public void initialize(){
        String Player1 = gameButton.Player1;
        String Player2 = gameButton.Player2;
        if(Player1.equals("Player1Won")){
            WinnerLabel.setText("Player 1");
            LoserLabel.setText("Player 2");
        }
        else if(Player2.equals("Player2Won")){
            WinnerLabel.setText("Player 2");
            LoserLabel.setText("Player 1");
        }
    }
}
