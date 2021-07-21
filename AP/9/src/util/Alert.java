package util;

import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.Note;
import note.NoteState;

public abstract class Alert {
    public static void show() {
        TextField textField = new TextField();
        textField.setPromptText("Enter File Name");
        textField.setAlignment(Pos.CENTER_LEFT);

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION, "", ButtonType.OK, ButtonType.CANCEL);
        alert.setTitle("Adding New Note");
        alert.setHeaderText(null);
        alert.setGraphic(textField);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            String fileName = textField.getText();
            if (!fileName.isEmpty()) {
                Note note = new Note(fileName, "", "");
                NoteState.notes.add(note);
            }
        }
    }

}
