package com.jsltd.corsser;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jsltd.corsser.animatin.Shake;
import com.jsltd.corsser.dataBase.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_f;

    @FXML
    private PasswordField password_f;

    @FXML
    void initialize() {
        authSignButton.setOnAction(event ->{
            String loginText = login_f.getText().trim();
            String loginPassword = password_f.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
            {
                loginUser(loginText,loginPassword);
                loginAdmin(loginText,loginPassword);
            }
            else
                System.out.println("Error! Login and password is empty");
        });

        loginSignUpButton.setOnAction(event ->{
            openNewScene("xml/enter-view.fxml");
        });
    }

    private void loginAdmin(String loginText,String loginPassword) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword("1234");
        ResultSet result = databaseHandler.getUser(user);

        int counter = 0;

        while(true)
        {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }

        if(counter>=1)
        {
                System.out.println("Admin");
                openNewScene("xml/admin-page.fxml");
        }
        else
        {
            Shake userLogin = new Shake(login_f);
            Shake userPass = new Shake(password_f);
            userLogin.playAnimation();
            userPass.playAnimation();
        }
    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(loginText);
        if (loginPassword=="1234") {
            return;
        } else
        {
            user.setPassword(loginPassword);
        }
        ResultSet result = databaseHandler.getUser(user);

        int counter = 0;

        while(true)
        {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }

        if(counter>=1)
        {
            System.out.println("User");
            openNewScene("xml/user-page.fxml");
        }
        else
        {
            Shake userLogin = new Shake(login_f);
            Shake userPass = new Shake(password_f);
            userLogin.playAnimation();
            userPass.playAnimation();
        }
    }

    public void openNewScene(String window)
    {
        loginSignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
