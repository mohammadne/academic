package note;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Note;

public abstract class NoteState {
    public static ObservableList<Note> notes = FXCollections.observableArrayList();
    public static StringProperty titleProperty = new SimpleStringProperty("");
    public static StringProperty dateProperty = new SimpleStringProperty("");
    public static StringProperty contentProperty = new SimpleStringProperty("");
}
