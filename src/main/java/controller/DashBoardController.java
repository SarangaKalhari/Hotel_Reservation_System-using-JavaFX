package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardController {
    Stage stage = new Stage();

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customer_info.fxml"))));
            stage.setTitle("Customer Info");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.show();
    }

    @FXML
    void btnRoomInfoOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/room_info.fxml"))));
            stage.setTitle("Room Info");
            stage.setResizable(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/employee_info.fxml"))));
            stage.setTitle("Employee Info");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.show();
    }
}
