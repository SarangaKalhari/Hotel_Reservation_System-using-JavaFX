package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginFormController {

    Stage stage = new Stage();
    public String[] userName = {"Admin", "Saman", "kamal"};
    public String[] password = {"1234", "0000", "1111"};

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;


    @FXML
    void btnLoginOnAction(ActionEvent event) {

        boolean loginSuccess = false;
        for (int i=0; i<userName.length; i++) {
            if (txtUserName.getText().equals(userName[i]) && txtPassword.getText().equals(password[i])) {
                System.out.println("Login Success ");
                try {

                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
                    stage.setTitle("Dashboard");
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            }
        if(loginSuccess) {
            System.out.println("Login Failed");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid User");
            alert.setContentText("Please Enter valid username and password");
            alert.showAndWait();

            txtUserName.clear();
            txtPassword.clear();

    ;    }
        }


    }


