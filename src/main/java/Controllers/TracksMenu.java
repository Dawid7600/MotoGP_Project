package Controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class TracksMenu {

    private static String currentTrack;

    @FXML
    public ImageView returnButton;
    @FXML
    public ImageView quatarTrack;
    @FXML
    public ImageView redbullTrack;
    @FXML
    public ImageView argentynaTrack;
    @FXML
    public ImageView hiszpaniaTrack;
    @FXML
    public ImageView japoniaTrack;


    public void initialize(){
        Image image = new Image(this.getClass().getResource("/images/Quatar/Quatar.png").toString());
        quatarTrack.setImage(image);

        image = new Image(this.getClass().getResource("/images/Austria/Austria.png").toString());
        redbullTrack.setImage(image);

        image = new Image(this.getClass().getResource("/images/Hiszpania/Hiszpania.png").toString());
        hiszpaniaTrack.setImage(image);

        image = new Image(this.getClass().getResource("/images/Japonia/Japonia.png").toString());
        japoniaTrack.setImage(image);

        image = new Image(this.getClass().getResource("/images/Argentyna/Argentyna2.png").toString());
        argentynaTrack.setImage(image);


        image = new Image(this.getClass().getResource("/images/returnIcon.png").toString());
        returnButton.setImage(image);
    }

    /**
     * Wraca do menu glownego
     * @throws IOException jezeli nie znajdzie pliku
     */
    public void returnToMenu() throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/MainMenu.fxml"));
        MainApp.setRoot(parent);
    }

    /**
     * Otwiera odpowiednie okno w zaleznosci od wcisnietego przycisku
     * @param imagePressed wartosc przycisku
     * @throws IOException jezeli nie znajdzie pliku
     */
    public void tourDetails(MouseEvent imagePressed) throws IOException {
        String chosenTrack = imagePressed.getPickResult().getIntersectedNode().getId();
        switch(chosenTrack){
            case("quatarTrack"):
                setCurrentTrack("Quatar");
                Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/TrackDetails.fxml"));
                MainApp.setRoot(parent);
                break;
            case("redbullTrack"):
                setCurrentTrack("Austria");
                Parent parent2 = FXMLLoader.load(this.getClass().getResource("/fxml/TrackDetails.fxml"));
                MainApp.setRoot(parent2);
                break;
            case("hiszpaniaTrack"):
                setCurrentTrack("Hiszpania");
                Parent parent3 = FXMLLoader.load(this.getClass().getResource("/fxml/TrackDetails.fxml"));
                MainApp.setRoot(parent3);
                break;
            case("japoniaTrack"):
                setCurrentTrack("Japonia");
                Parent parent4 = FXMLLoader.load(this.getClass().getResource("/fxml/TrackDetails.fxml"));
                MainApp.setRoot(parent4);
                break;
            case("argentynaTrack"):
                setCurrentTrack("Argentyna");
                Parent parent5 = FXMLLoader.load(this.getClass().getResource("/fxml/TrackDetails.fxml"));
                MainApp.setRoot(parent5);
                break;
        }

    }

    public static String getCurrentTrack(){
        return currentTrack;
    }
    public static void setCurrentTrack(String currentTrack){
        TracksMenu.currentTrack = currentTrack;
    }

}
