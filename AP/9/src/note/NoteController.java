package note;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import models.Note;
import util.Alert;
import util.Prefrence;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class NoteController implements Initializable {
    @FXML
    private ListView<Note> listView;
    @FXML
    private TextArea titleTextArea;
    @FXML
    private TextArea dateTextArea;
    @FXML
    private TextArea contentTextArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HashMap<String, Note> notes = Prefrence.reader();
        for (Map.Entry<String, Note> note : notes.entrySet())
            NoteState.notes.add(note.getValue());

        listView.setItems(NoteState.notes);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Note>() {
            @Override
            public void changed(ObservableValue<? extends Note> observable, Note oldValue, Note newValue) {
                if (oldValue != null) {
                    String oldTitle = oldValue.getTitle();
                    String oldContent = oldValue.getContent();

                    String newTitle = titleTextArea.getText();
                    String newContent = contentTextArea.getText();

                    if (!oldTitle.equals(newTitle) || !oldContent.equals(newContent)) {
                        oldValue.setDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()));
                    }

                    oldValue.setTitle(titleTextArea.getText());
                    oldValue.setContent(contentTextArea.getText());
                }

                titleTextArea.textProperty().setValue(newValue.getTitle());
                dateTextArea.textProperty().setValue(newValue.getDate());
                contentTextArea.textProperty().setValue(newValue.getContent());
            }
        });
    }

    @FXML
    private void addNewNote(MouseEvent mouseEvent) {
        Alert.show();
    }

    @FXML
    private void saveNote(MouseEvent mouseEvent) {
        HashMap<String, Note> notesMap = new HashMap<>();
        List<Note> notesList = new ArrayList<>(NoteState.notes);
        for (Note note : notesList) {
            notesMap.put(note.getTitle(), note);
        }
        Prefrence.writer(notesMap);
    }
}
