package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.RoomInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class Room_Info implements Initializable {

    ObservableList<RoomInfoDTO> roomInfoDTOS = FXCollections.observableArrayList(
            new RoomInfoDTO("R001", "Single", "A room assistant", 1000.00),
            new RoomInfoDTO("R002", "Double", "A room assistant", 2000.00),
            new RoomInfoDTO("R003", "Single", "A room assistant", 1500.00)
    );

    @FXML
    private TableColumn<?, ?> columnDescription;

    @FXML
    private TableColumn<?, ?> columnPrice;

    @FXML
    private TableColumn<?, ?> columnRoomId;

    @FXML
    private TableColumn<?, ?> columnType;

    @FXML
    private TableView<RoomInfoDTO> tblRoomInfo;

    @FXML
    private TextField txtRoomId;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtType;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        roomInfoDTOS.add(new RoomInfoDTO(txtRoomId.getText(), txtType.getText(), txtDesc.getText(), Double.parseDouble(txtPrice.getText())));
        tblRoomInfo.refresh();

        txtRoomId.setText("");
        txtType.setText("");
        txtDesc.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtRoomId.clear();
        txtType.clear();
        txtDesc.clear();
        txtPrice.clear();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        RoomInfoDTO selectedItem = tblRoomInfo.getSelectionModel().getSelectedItem();
        roomInfoDTOS.remove(selectedItem);
        tblRoomInfo.refresh();
    }



    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        RoomInfoDTO selectedItem = tblRoomInfo.getSelectionModel().getSelectedItem();

        selectedItem.setRoomID(txtRoomId.getText());
        selectedItem.setType(txtType.getText());
        selectedItem.setDescription(txtDesc.getText());
        selectedItem.setPrice(Double.parseDouble(txtPrice.getText()));

        tblRoomInfo.refresh();

        txtRoomId.setText("");
        txtType.setText("");
        txtDesc.setText("");
        txtPrice.setText("");
    }




@FXML
    void btnReloadOnAction(ActionEvent event) {
        txtRoomId.setText("");
        txtType.setText("");
        txtDesc.setText("");
        txtPrice.setText("");

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnRoomId.setCellValueFactory(new PropertyValueFactory<>("roomID"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tblRoomInfo.setItems(roomInfoDTOS);

        tblRoomInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, roomInfoDTO, t1) ->{
                if(t1 != null){
                   txtRoomId.setText(t1.getRoomID());
                   txtType.setText(t1.getType());
                   txtDesc.setText(t1.getDescription());
                   txtPrice.setText(String.valueOf(t1.getPrice()));
                 }
         });


    }




}
