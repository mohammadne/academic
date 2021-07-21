package http_client.ui.main;

import http_client.ui.main.left_panel.LeftPanelController;
import http_client.ui.main.menu.MenuController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuBar menuBar;
    @FXML
    private SplitPane splitPane;
    @FXML
    private AnchorPane leftAnchorPane;
    @FXML
    private AnchorPane centerAnchorPane;
    @FXML
    private AnchorPane rightAnchorPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadMenuBar();
        loadSplitPaneItems();
    }

    private void loadSplitPaneItems() {
        FXMLLoader leftLoader = new FXMLLoader(getClass().getResource("/http_client/ui/main/left_panel/left_panel.fxml"));
        FXMLLoader centerLoader = new FXMLLoader(getClass().getResource("/http_client/ui/main/center_panel/center_panel.fxml"));
        FXMLLoader rightLoader = new FXMLLoader(getClass().getResource("/http_client/ui/main/right_panel/right_panel.fxml"));


        try {
            leftAnchorPane = leftLoader.load();
            centerAnchorPane = centerLoader.load();
            rightAnchorPane = rightLoader.load();
            splitPane.getItems().addAll(leftAnchorPane, centerAnchorPane, rightAnchorPane);
            borderPane.setCenter(splitPane);
            LeftPanelController controller = leftLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMenuBar() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/http_client/ui/main/menu/menu.fxml"));
        try {
            menuBar = loader.load();
            borderPane.setTop(menuBar);
            MenuController controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
