package calculator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {
    @FXML
    private BorderPane calculatorBorderPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader tabLoader = new FXMLLoader(getClass().getResource("/calculator/tab/tab.fxml"));
        FXMLLoader displayLoader = new FXMLLoader(getClass().getResource("/calculator/display/display.fxml"));
        FXMLLoader buttonsLoader = new FXMLLoader(getClass().getResource("/calculator/buttons/buttons.fxml"));

        try {
            AnchorPane tabAnchorPane = tabLoader.load();
            tabAnchorPane.setPrefHeight(50);
            AnchorPane displayAnchorPane = displayLoader.load();
            AnchorPane buttonsAnchorPane = buttonsLoader.load();

            calculatorBorderPane.setTop(tabAnchorPane);
            VBox vBox = new VBox();
            vBox.getChildren().addAll(displayAnchorPane, buttonsAnchorPane);
            vBox.setAlignment(Pos.CENTER);
            calculatorBorderPane.setCenter(vBox);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
