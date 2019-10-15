package Controllers;

import application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Intro {

    @FXML
    private ImageView motoGPLogo;
    @FXML
    private Label opisProjektu;

    @FXML
    /**
     * Metoda wywolywana przy tworzeniu okna
     */
    public void initialize(){
        Image image = new Image(this.getClass().getResource("/images/motogp_logo.png").toString());
        motoGPLogo.setImage(image);

        opisProjektu.setText("Projekt 'Statystyka MotoGP'.\nAplikacja umozliwia statystyki zawodnikow oraz " +
                "czas do nastepnego wyscigu");
    }

    @FXML
    /**
     * Zwieksza wielkosc ikony
     */
    public void increaseSize(){
        opisProjektu.setVisible(false);
        motoGPLogo.setScaleX(1.5);
        motoGPLogo.setScaleY(1.5);
    }
    @FXML
    /**
     * Zmniejsza wielkosc ikony
     */
    public void decreaseSize(){
        opisProjektu.setVisible(true);
        motoGPLogo.setScaleX(1);
        motoGPLogo.setScaleY(1);
    }
    @FXML
    /**
     * Uruchomienie menu glownego
     */
    public void startApplication() throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/MainMenu.fxml"));
        MainApp.setRoot(parent);
    }

}
