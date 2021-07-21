package http_client.service;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

import http_client.util.AlertMaker;

public class Preferences {

    private static <T> void initConfig(String path, T baseObj, Gson gson) {
        Writer writer = null;
        try {
            writer = new FileWriter(path);
            gson.toJson(baseObj, writer);
        } catch (IOException ex) {
            Logger.getLogger(baseObj.getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(baseObj.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static <T> T readPreferenceFromFile(String path, T baseObj ) {
        T actualObj = baseObj;
        Gson gson = new Gson();
        try {
            actualObj = gson.fromJson(new FileReader(path), (Type) baseObj.getClass());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(baseObj.getClass().getName()).info("Config file is missing. Creating new one with default config");
            initConfig(path, baseObj, gson);
        }
        return actualObj;
    }

    public static <T> void writePreferenceToFile(String path, T actObj) {
        Writer writer = null;
        try {
            Gson gson = new Gson();
            writer = new FileWriter(path);
            gson.toJson(actObj, writer);

            AlertMaker.showSimpleAlert("Success", "Settings updated");
        } catch (IOException ex) {
            Logger.getLogger(actObj.getClass().getName()).log(Level.SEVERE, null, ex);
            AlertMaker.showErrorMessage(ex, "Failed", "Cant save configuration file");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(actObj.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
