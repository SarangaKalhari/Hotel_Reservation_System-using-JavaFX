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

    }

    @FXML
    void btnRoomInfoOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/room_info.fxml"))));
            stage.setTitle("Room Info");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

}
