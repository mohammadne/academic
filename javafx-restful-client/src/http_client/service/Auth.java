package http_client.service;

import org.apache.commons.codec.digest.DigestUtils;

public class Auth {
    private Auth() {
        this.userName = "admin";
        setSH1Password("admin");
        this.theme = 0;
    }

    public static Auth instance = new Auth();
    public static final String CONFIG_FILE = "auth_config.txt";
    String userName;
    String password;
    int theme;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSH1Password(String password) {
        if (password.length() < 16) {
            this.password = DigestUtils.shaHex(password);
        } else
            this.password = password;
    }

    public void setTheme(Integer theme) {
        this.theme = theme;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getTheme() {
        return this.theme;
    }

    public void readConfigFromFile() {
        Preferences.readPreferenceFromFile(CONFIG_FILE, this);
    }

    public void writeConfigToFile() {
        Preferences.writePreferenceToFile(CONFIG_FILE, this);
    }


}