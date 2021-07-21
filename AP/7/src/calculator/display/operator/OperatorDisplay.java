package calculator.display.operator;

import calculator.CalculatorState;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class OperatorDisplay implements Initializable {
    @FXML
    private TextArea operatorTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operatorTextArea.textProperty().bind(CalculatorState.operator.asString());
    }
}
