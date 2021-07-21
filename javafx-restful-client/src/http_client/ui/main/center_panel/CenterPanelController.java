package http_client.ui.main.center_panel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CenterPanelController implements Initializable {
    @FXML
    private Tab bodyTab;
    @FXML
    private Tab headerTab;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTabContents();
    }

    private void loadTabContents() {
        FXMLLoader bodyTabLoader = new FXMLLoader(getClass().getResource("/http_client/ui/main/center_panel/body/body.fxml"));
        FXMLLoader headerTabLoader = new FXMLLoader(getClass().getResource("/http_client/ui/main/center_panel/header/header.fxml"));
        try {
            AnchorPane bodyTabContent = bodyTabLoader.load();
            bodyTab.setContent(bodyTabContent);
            BorderPane headerTabContent = headerTabLoader.load();
            headerTab.setContent(headerTabContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}