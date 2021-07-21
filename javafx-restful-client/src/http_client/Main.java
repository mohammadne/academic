package http_client;

import http_client.util.UtilityFunctions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        var loader = getClass().getResource("/http_client/ui/login/login.fxml");
        Parent root = FXMLLoader.load(loader);
        primaryStage.setTitle("Http Client Login");
        UtilityFunctions.setStageIcon(primaryStage);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}