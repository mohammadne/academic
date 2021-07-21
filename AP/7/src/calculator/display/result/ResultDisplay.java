package calculator.display.result;

import calculator.CalculatorState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultDisplay implements Initializable {
    @FXML
    private TextArea resultTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resultTextArea.textProperty().bindBidirectional(CalculatorState.PerValue);
    }
}
