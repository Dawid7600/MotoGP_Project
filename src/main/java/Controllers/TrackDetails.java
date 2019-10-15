package Controllers;

import Database.DBConnector;
import Model.Track;
import application.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Okno odpowiedzialne za wyswietlanie szczegolow o torze
 */
public class TrackDetails {

    @FXML
    ImageView nextImage;
    @FXML
    ImageView previousImage;
    @FXML
    ImageView trackImage;
    @FXML
    ImageView returnButton;

    @FXML
    Label trackCountry;
    @FXML
    Label trackCity;
    @FXML
    Label trackLenght;
    @FXML
    Label trackData;
    @FXML
    Label trackRecord;
    @FXML
    Label trackDesc;



    private int currentPictureIndex;

    private String currentTrack;

    public void initialize(){
        currentTrack = TracksMenu.getCurrentTrack();
        Track track;
        try {
            track = findTrack(currentTrack);
            trackCity.setText(track.getLocation());
            trackCountry.setText(track.getCountry());
            trackData.setText(track.getOpenDate());
            trackLenght.setText(track.getDistance());
            trackDesc.setText(track.getDescription());
            trackRecord.setText(track.getTrackRecord());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //default image
        currentPictureIndex = 0;
        changePicture();
        nextImage.setImage(new Image(String.valueOf(this.getClass().getResource("/images/nextImage.png"))));
        previousImage.setImage(new Image(String.valueOf(this.getClass().getResource("/images/previousImage.png"))));
        returnButton.setImage(new Image(String.valueOf(this.getClass().getResource("/images/returnIcon.png"))));
    }

    /**
     * Wraca do menu glownego
     * @throws IOException Jezeli plik xml nie zostanie znaleziony
     */
    public void returnToMenu() throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/fxml/TracksMenu.fxml"));
        MainApp.setRoot(parent);
    }

    /**
     * Metoda ladujaca zdjecia
     */
    private void changePicture(){
        Image image; 
        switch(currentPictureIndex){
            case 0:
                image = new Image(String.valueOf(this.getClass().getResource("/images/"+currentTrack+"/"+currentTrack+".png")));
                break;
            case 1:
                image = new Image(String.valueOf(this.getClass().getResource("/images/"+currentTrack+"/"+currentTrack+"1.png")));
                break;
            case 2:
                image = new Image(String.valueOf(this.getClass().getResource("/images/"+currentTrack+"/"+currentTrack+"2.png")));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currentPictureIndex);
        }
        trackImage.setImage(image);
    }

    /**
     * Metoda do zmiany zdjecia w tyl
     */
    public void previousPicture() {
        if(currentPictureIndex == 0){
            //TODO add more pictures
            currentPictureIndex = 2;
            changePicture();
        }else{
            currentPictureIndex--;
            changePicture();
        }
    }
    /**
     * Metoda do zmiany zdjecia w przod
     */
    public void nextPicture() {
        if(currentPictureIndex == 2){
            currentPictureIndex = 0;
            changePicture();
        } else {
            currentPictureIndex++;
            changePicture();
        }
    }

    /**
     * @param trackLocation
     * Metoda pobierajaca dane z bazy
     * @return Obiekt klasy Tracks na podstawie wynikow w bazie danych
     * @throws SQLException jezeli wystapi problem z baza
     */
    private Track findTrack(String trackLocation) throws SQLException {
        Track track = null;
        ResultSet set = DBConnector.connect().createResultSet("Select * FROM tracks WHERE country ='"+trackLocation+"'");
        while(set.next()){
            track = new Track(
                    set.getString("location"),
                    set.getString("country"),
                    set.getString("distance"),
                    set.getString("openDate"),
                    set.getString("trackRecord"),
                    set.getString("description"));
        }

        return track;
    }
}
