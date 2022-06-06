package com.jsltd.corsser;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jsltd.corsser.dataBase.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField signUpUsername;

    @FXML
    private TextField signUpName;

    @FXML
    private PasswordField signUpPassword;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        signUpButton.setOnAction(event -> {

            signUpNewUser();

        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstname = signUpName.getText();
        String username = signUpUsername.getText();
        String password = signUpPassword.getText();
        String role = "user";

        User user = new User(firstname,username,password,role);

        dbHandler.signUpUser(user);
    }
}
