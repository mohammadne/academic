package http_client.ui.main.center_panel.header.single_header;

import http_client.ui.main.center_panel.header.HeaderController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SingleHeaderController implements Initializable {
    private int headerIndex;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    private void onTapDelete() {
        FXMLLoader headerFiledLoader = new FXMLLoader(getClass().getResource("/http_client/ui/main/center_panel/header/header.fxml"));
        try {
            headerFiledLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HeaderController controller = headerFiledLoader.getController();
        controller.deleteHeaderField(headerIndex);
    }

    public void setHeaderIndex(int index) {
        headerIndex = index;
    }
}
