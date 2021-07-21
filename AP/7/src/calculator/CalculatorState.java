package calculator;

import javafx.beans.property.*;

public abstract class CalculatorState {
    public static ObjectProperty<CalculatorType> calculatorType = new SimpleObjectProperty<>(CalculatorType.Simple);
    public static StringProperty value = new SimpleStringProperty("");
    public static StringProperty PerValue = new SimpleStringProperty("");
    public static ObjectProperty<Operator> operator = new SimpleObjectProperty<>();
    public static BooleanProperty enabledDot = new SimpleBooleanProperty(false);
}
