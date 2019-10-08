package Model;

import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Klasa encja dla zawodnika
 */

public class Raider {

    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty age;
    private SimpleStringProperty countryOfOrigin;
    private SimpleStringProperty wins;
    private SimpleStringProperty seasons;

    public Raider(ResultSet raiderRS) throws SQLException {
        firstName = new SimpleStringProperty(raiderRS.getString("FirstName"));
        lastName = new SimpleStringProperty(raiderRS.getString("LastName"));
        age = new SimpleStringProperty(raiderRS.getString("Age"));
        countryOfOrigin = new SimpleStringProperty(raiderRS.getString("CountryOfOrigin"));
        wins = new SimpleStringProperty(raiderRS.getString("WinCount"));
        seasons = new SimpleStringProperty(raiderRS.getString("seasons"));
    }

    public String getSeasons() {
        return seasons.get();
    }

    public SimpleStringProperty seasonsProperty() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons.set(seasons);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin.get();
    }

    public SimpleStringProperty countryOfOriginProperty() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin.set(countryOfOrigin);
    }

    public String getWins() {
        return wins.get();
    }

    public SimpleStringProperty winsProperty() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins.set(wins);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }
}
