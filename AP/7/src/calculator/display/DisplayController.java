package calculator.display;

import calculator.CalculatorState;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayController implements Initializable {
    @FXML
    private VBox vBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader resultLoader = new FXMLLoader(getClass().getResource("/calculator/display/result/result_display.fxml"));
        FXMLLoader operatorLoader = new FXMLLoader(getClass().getResource("/calculator/display/operator/operator_display.fxml"));
        FXMLLoader currentLoader = new FXMLLoader(getClass().getResource("/calculator/display/current/current_display.fxml"));

        try {
            AnchorPane resultAnchorPane = resultLoader.load();
            AnchorPane operatorAnchorPane = operatorLoader.load();
            AnchorPane currentAnchorPane = currentLoader.load();

            vBox.getChildren().addAll(resultAnchorPane, operatorAnchorPane, currentAnchorPane);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
