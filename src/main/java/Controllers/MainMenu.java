package Controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainMenu {

    private String currentButton = "";

    @FXML
    public ImageView raidersButton;
    @FXML
    public Label raidersLabel;

    @FXML
    public ImageView tracksButton;
    @FXML
    public Label tracksLabel;

    @FXML
    public ImageView closeButton;


    @FXML
    public Label closeLabel;

    @FXML
    public void initialize() {
        Image image = new Image(this.getClass().getResource("/images/motocycle_icon.png").toString());
        raidersButton.setImage(image);

        image = new Image(this.getClass().getResource("/images/track_icon.png").toString());
        tracksButton.setImage(image);

        image = new Image(this.getClass().getResource("/images/close_icon.png").toString());
        closeButton.setImage(image);


    }

    public void changeScene(MouseEvent event) throws IOException {
        String buttonPressed = event.getPickResult().getIntersectedNode().getId();
        Parent parent;
        switch (buttonPressed){
            case("raidersButton"):
                parent = FXMLLoader.load(this.getClass().getResource("/fxml/RaidersTable.fxml"));
                break;
            case("tracksButton"):
                parent = FXMLLoader.load(this.getClass().getResource("/fxml/TracksMenu.fxml"));
                break;
            default:
                parent = null;
                break;
        }
        MainApp.setRoot(parent);
    }


    public void increaseRaidersSize(MouseEvent event) {
        event.getPickResult().getIntersectedNode().setScaleX(1.5);
        event.getPickResult().getIntersectedNode().setScaleY(1.5);
        currentButton = event.getPickResult().getIntersectedNode().getId();
        switch (currentButton){
            case ("raidersButton"):
                raidersLabel.setVisible(false);
                break;
            case ("tracksButton"):
                tracksLabel.setVisible(false);
                break;
            case ("closeButton"):
                closeLabel.setVisible(false);
                break;
        }
    }

    public void decreaseRaidersSize() {
        switch(currentButton){
            case("raidersButton"):
                raidersButton.setScaleX(1);
                raidersButton.setScaleY(1);
                currentButton = "";
                raidersLabel.setVisible(true);
                break;
            case("tracksButton"):
                tracksButton.setScaleY(1);
                tracksButton.setScaleX(1);
                currentButton = "";
                tracksLabel.setVisible(true);
                break;

            case("closeButton"):
                closeButton.setScaleX(1);
                closeButton.setScaleY(1);
                currentButton = "";
                closeLabel.setVisible(true);
                break;

        }
    }

    public void closeApplication() {
        System.exit(0);
    }


}
