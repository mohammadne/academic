package http_client.ui.login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import http_client.service.Auth;
import http_client.util.UtilityFunctions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private final static Logger LOGGER = LogManager.getLogger(LoginController.class.getName());

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Auth.instance.readConfigFromFile();
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent actionEvent) {
        Auth instance = Auth.instance;
        String uname = StringUtils.trimToEmpty(username.getText());
        String pword = DigestUtils.shaHex(password.getText());

        System.out.println(pword);
        System.out.println(instance.getPassword());

        if (uname.equals(instance.getUserName()) && pword.equals(instance.getPassword())) {
            ((Stage) username.getScene().getWindow()).close();
            loadMain();
            LOGGER.log(Level.INFO, "User successfully logged in {}", uname);
        }
        else {
            username.getStyleClass().add("wrong-credentials");
            password.getStyleClass().add("wrong-credentials");
        }
    }

    private void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/http_client/ui/main/main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Http Client");
            stage.setScene(new Scene(parent));
            stage.show();
            UtilityFunctions.setStageIcon(stage);
        }
        catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }
}
