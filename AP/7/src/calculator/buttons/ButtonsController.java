package calculator.buttons;

import calculator.CalculatorState;
import calculator.Operator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ButtonsController implements Initializable {
    /*
     *Numbers
     */
    @FXML
    private void num0(MouseEvent mouseEvent) {
        onPressedNum(0);
    }

    @FXML
    private void num1(MouseEvent mouseEvent) {
        onPressedNum(1);
    }

    @FXML
    private void num2(MouseEvent mouseEvent) {
        onPressedNum(2);
    }

    @FXML
    private void num3(MouseEvent mouseEvent) {
        onPressedNum(3);
    }

    @FXML
    private void num4(MouseEvent mouseEvent) {
        onPressedNum(4);
    }

    @FXML
    private void num5(MouseEvent mouseEvent) {
        onPressedNum(5);
    }

    @FXML
    private void num6(MouseEvent mouseEvent) {
        onPressedNum(6);
    }

    @FXML
    private void num7(MouseEvent mouseEvent) {
        onPressedNum(7);
    }

    @FXML
    private void num8(MouseEvent mouseEvent) {
        onPressedNum(8);
    }

    @FXML
    private void num9(MouseEvent mouseEvent) {
        onPressedNum(9);
    }

    void onPressedNum(int number) {
        Operator operator = CalculatorState.operator.get();
        if (operator == null) {
            String val = CalculatorState.PerValue.get();
            CalculatorState.PerValue.setValue(val + String.valueOf(number));
        } else {
            String val = CalculatorState.value.get();
            CalculatorState.value.setValue(val + String.valueOf(number));
        }
    }

    /*
     *operators
     */
    @FXML
    private void operatorMultiple(MouseEvent mouseEvent) {
        CalculatorState.operator.setValue(Operator.Multiple);
    }

    @FXML
    private void operationDivide(MouseEvent mouseEvent) {
        CalculatorState.operator.setValue(Operator.Divide);
    }

    @FXML
    private void operationPlus(MouseEvent mouseEvent) {
        CalculatorState.operator.setValue(Operator.Plus);
    }

    @FXML
    private void operationMinus(MouseEvent mouseEvent) {
        CalculatorState.operator.setValue(Operator.Minus);
    }

    @FXML
    private void operationEqual(MouseEvent mouseEvent) {
        String perVal = CalculatorState.PerValue.get();
        Operator operator = CalculatorState.operator.get();
        String val = CalculatorState.value.get();
        if (!val.isEmpty()) {
            switch (operator) {
                case Multiple:
                    perVal = String.valueOf(Double.parseDouble(perVal) * Double.parseDouble(val));
                    break;
                case Divide:
                    if (Double.parseDouble(val) == 0) {
                        break;
                    }
                    perVal = String.valueOf(Double.parseDouble(perVal) / Double.parseDouble(val));
                    break;
                case Plus:
                    perVal = String.valueOf(Double.parseDouble(perVal) + Double.parseDouble(val));
                    break;
                case Minus:
                    perVal = String.valueOf(Double.parseDouble(perVal) - Double.parseDouble(val));
                    break;
            }
            CalculatorState.PerValue.setValue(perVal);
            CalculatorState.operator.setValue(null);
            CalculatorState.value.setValue("");
        }

    }

    @FXML
    private void Dot(MouseEvent mouseEvent) {
        CalculatorState.enabledDot.setValue(true);
        Operator operator = CalculatorState.operator.get();
        if (operator == null) {
            CalculatorState.PerValue.setValue(CalculatorState.PerValue.get() + ".");
        } else {
            CalculatorState.value.setValue(CalculatorState.value.get() + ".");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
