package http_client.ui.main.center_panel.header;

import com.jfoenix.controls.JFXListView;
import http_client.ui.main.center_panel.header.single_header.SingleHeaderController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController implements Initializable {
    Integer headerCounts = 0;
    private ObservableList<HBox> headerFields = FXCollections.observableArrayList();

    @FXML
    private JFXListView<HBox> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addHeaderFiled();
    }

    @FXML
    private void onTapAddNewHeader(MouseEvent mouseEvent) {
        addHeaderFiled();
    }

    @FXML
    private void removeHeaderFiled(MouseEvent mouseEvent) {
        headerFields.remove(headerCounts - 1);
        headerCounts--;
        listView.setItems(headerFields);
    }

    private void addHeaderFiled() {
        FXMLLoader headerFiledLoader = new FXMLLoader(getClass().getResource("/http_client/ui/main/center_panel/header/single_header/single_header.fxml"));
        try {
            HBox headerFiled = headerFiledLoader.load();
            headerFields.add(headerFiled);
            headerCounts++;
            listView.setItems(headerFields);
            SingleHeaderController controller = headerFiledLoader.getController();
            controller.setHeaderIndex(headerCounts - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteHeaderField(int index) {
        System.out.println(index);
        Platform.runLater(() -> {
            headerFields.remove(index);
            headerCounts--;
            listView.setItems(headerFields);
        });
    }
}
