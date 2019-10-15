package Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * Klasa laczaca sie z baza danych
 */
public class DBConnector {

    private static DBConnector DBConnectorSingleton = null;

    private static Properties properties;
    private InputStream inputStream;
    private static String serverURL;
    private static String serverUser;
    private static String serverPassword;

    private static Connection connection;
    private static Statement statement;
    private ResultSet resultSet;

    private DBConnector() throws SQLException {
        try {
            loadConfig();
            loadServer();
        } catch (IOException configFileNotFound) {
            configFileNotFound.printStackTrace();
        }
    }

    /**
     * Metoda dostepu do instancji klasy DBConnector
     * @return instancje klasy DBConnector
     * @throws SQLException wyrzuca blad jezeli polaczenie nie bedzie poprawne
     */
    public static synchronized DBConnector connect() throws SQLException {
        if (DBConnectorSingleton == null) {
            DBConnectorSingleton = new DBConnector();
            return DBConnectorSingleton;
        }
        return DBConnectorSingleton;
    }

    /**
     * Tworzy ResultSet na podstawie pytania oraz wynikow w bazie danych
     * @param query Zapytanie SQL
     * @return tablice wynikow
     * @throws SQLException wyrzuca blad jezeli polaczenie nie bedzie poprawne
     */
    public ResultSet createResultSet(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    /**
     * Metoda do walidacji czy polaczenie z baza danych jest nadal aktywne
     * @return status polaczenia
     * @throws SQLException wyrzuca blad jezeli polaczenie nie bedzie poprawne
     */
    public static boolean isOnline() throws SQLException {

        if(connection != null) {
            return true;
        }
        else
            return false;
    }

    /**
     * Laduje dane dotyczace serwera (nazwe hosta, nazwe uzytkownika, haslo)
     * @throws IOException wyrzuca blad jezeli plik config.properties
     */
    private void loadConfig() throws IOException {
        properties = new Properties();
        String propFileName = "config.properties";

        inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            properties.load(inputStream);
            inputStream.close();
        } else {
            throw new FileNotFoundException("property file not found");
        }
        serverURL = properties.getProperty("serverURL");
        serverUser = properties.getProperty("user");
        serverPassword = properties.getProperty("password");
    }

    /**
     * tworzy stale polaczenie z serwerem
     * @throws SQLException wyrzuca blad jezeli polaczenie nie bedzie poprawne
     */
    public static void loadServer() throws SQLException {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + serverURL
                            +"?useUnicode=true&useJDBCCompliantTimezoneShift" +
                            "=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    serverUser, serverPassword);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}