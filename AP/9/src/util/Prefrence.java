package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Note;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public abstract class Prefrence {
    private static final String NOTES_PATH = "notes.txt";

    private static void initWriter() {
        writer(new HashMap<String, Note>());
    }

    public static HashMap<String, Note> reader() {
        Type typeOfHashMap = new TypeToken<HashMap<String, Note>>() {}.getType();
        HashMap<String, Note> notes = new HashMap<String, Note>();
        Gson gson = new GsonBuilder().create();
        try {
            notes = gson.fromJson(new FileReader(NOTES_PATH), typeOfHashMap);
        } catch (FileNotFoundException e) {
            initWriter();
        }
        if (notes == null) {
            return new HashMap<String, Note>();
        }
        return notes;
    }

    public static void writer(HashMap<String, Note> notes) {
        Writer writer = null;
        try {
            Gson gson = new GsonBuilder().create();
            writer = new FileWriter(NOTES_PATH);
            gson.toJson(notes , writer);
        } catch (IOException e) {
            System.out.print("can not write");
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
