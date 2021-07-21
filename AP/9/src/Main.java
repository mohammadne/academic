import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        var loader = getClass().getResource("/note/note.fxml");
        Parent root = FXMLLoader.load(loader);
        primaryStage.setTitle("Note Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
