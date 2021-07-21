package calculator.display.current;

import calculator.CalculatorState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentDisplay implements Initializable {
    @FXML
    private TextArea currentTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentTextArea.textProperty().bind(CalculatorState.value);
    }
}
