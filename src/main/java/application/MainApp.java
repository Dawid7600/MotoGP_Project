package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

    private static Scene mainScene;

    public static void main(String[]args){
        launch();
    }

    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(this.getClass().getResource("/fxml/Intro.fxml"));
        mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    /**
     * Metoda ktora zwraca glowny Scene dla Stage'a. Dzieki niej mozemy zmieniac wartosci Scene dla Stage
     * @param root zwraca uzywany Scene
     *
     */
    public static void setRoot(Parent root) {
        MainApp.mainScene.setRoot(root);
    }
}
