///Insert into Raiders (FirstName, LastName, Age, CountyOfOrigin, WinCount, Seasons) VALUES
package Controllers;

import Database.DBConnector;
import Model.Raider;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MainMenu {
    @FXML
    public Label timeTillRace;
    @FXML
    TableView<Raider> raiderTableView;
    @FXML
    TableColumn<Raider, String> firstName;
    @FXML
    TableColumn<Raider, String> lastName;
    @FXML
    TableColumn<Raider, String> age;
    @FXML
    TableColumn<Raider, String> countyOfOrigin;
    @FXML
    TableColumn<Raider, String> winCount;
    @FXML
    TableColumn<Raider, String> seasons;

    @FXML

    ImageView motoGPLogo;

    @FXML
    TextField searchBox;

    private ObservableList<Raider> data = FXCollections.observableArrayList();
    private ResultSet raiderRS;
    @FXML
    /**
     * Metoda wywolywana przy tworzeniu okna
     */
    public void initialize(){
        motoGPLogo.setImage(new Image(String.valueOf(this.getClass().getResource("/images/motogp_logo.png"))));
        //Ustawienie dnia nastepnego wyscigu
        try {
            ResultSet nextRace =  DBConnector.connect().createResultSet("Select * from race_dates");
            while(nextRace.next()){
                timeTillRace.setText(nextRace.getString("nextRace"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setDataTable(raiderRS);


    }

    /**
     * Metoda wszukująca danego uzytkownika na podstawie wartosci zapisanej w searchBox'ie
     * @throws SQLException wyrzucany podczas bledu z polaczeniem z baza
     */
    @FXML
    public void searchRaider() throws SQLException {
        data.clear();
        String raiderName = searchBox.getText();
        if(raiderName.equals("")){
            ResultSet defaultOption = DBConnector.connect().createResultSet("Select * from raiders");
            setDataTable(defaultOption);
        }else{
            ResultSet raider = DBConnector.connect().createResultSet("Select * from raiders where FirstName ='" + raiderName + "'");
            while(raider.next()){
                data.add(new Raider(raider));
            }
            //column name + value from the class
            firstName.setCellValueFactory(
                    new PropertyValueFactory<Raider, String>("firstName"));
            lastName.setCellValueFactory(
                    new PropertyValueFactory<Raider, String>("lastName"));
            age.setCellValueFactory(
                    new PropertyValueFactory<Raider, String>("age"));
            countyOfOrigin.setCellValueFactory(
                    new PropertyValueFactory<Raider, String>("countryOfOrigin"));
            winCount.setCellValueFactory(
                    new PropertyValueFactory<Raider, String>("wins"));
            seasons.setCellValueFactory(
                    new PropertyValueFactory<Raider, String>("seasons"));

            raiderTableView.setItems(data);
        }

    }

    /**
     * Metoda ktora analizuje zbior danych i na jej podstawie tworzy obiekty i przypisuje je do tablicy
     * @param raiderRS analizowany zbior danych
     */
    private void setDataTable(ResultSet raiderRS){
        try {
            //ustawienie wartosci zawodnikow

            raiderRS = DBConnector.connect().createResultSet("Select * From raiders");
            while(raiderRS.next()){
                data.add(new Raider(raiderRS));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //column name + value from the class
        firstName.setCellValueFactory(
                new PropertyValueFactory<Raider, String>("firstName"));
        lastName.setCellValueFactory(
                new PropertyValueFactory<Raider, String>("lastName"));
        age.setCellValueFactory(
                new PropertyValueFactory<Raider, String>("age"));
        countyOfOrigin.setCellValueFactory(
                new PropertyValueFactory<Raider, String>("countryOfOrigin"));
        winCount.setCellValueFactory(
                new PropertyValueFactory<Raider, String>("wins"));
        seasons.setCellValueFactory(
                new PropertyValueFactory<Raider, String>("seasons"));

        raiderTableView.setItems(data);

    }
}
