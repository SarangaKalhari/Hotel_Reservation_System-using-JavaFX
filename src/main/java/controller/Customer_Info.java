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
import model.dto.CustomerInfoDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class Customer_Info implements Initializable {

    ObservableList<CustomerInfoDTO> customerInfoDTOS = FXCollections.observableArrayList(
            new CustomerInfoDTO("C001","Amal", "01234567789", "Colombo", 20),
            new CustomerInfoDTO("C001", "Alice Johnson", "555-1234", "New York", 28),
            new CustomerInfoDTO("C002", "Brian Smith", "555-5678", "Los Angeles", 35),
            new CustomerInfoDTO("C003", "Catherine Lee", "555-8765", "Chicago", 42),
            new CustomerInfoDTO("C004", "David Kim", "555-3456", "Houston", 31),
            new CustomerInfoDTO("C005", "Emma Brown", "555-7890", "Miami", 25)
    );

    @FXML
    private TableColumn<?, ?> colCustAge;

    @FXML
    private TableColumn<?, ?> colCustCity;

    @FXML
    private TableColumn<?, ?> colCustID;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colCustPhoneNo;

    @FXML
    private TableView<CustomerInfoDTO> tblCustomeInfo;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        customerInfoDTOS.add(new CustomerInfoDTO(txtCustID.getText(), txtName.getText(), txtPhoneNumber.getText(), txtCity.getText(), Integer.parseInt(txtAge.getText())));
        tblCustomeInfo.refresh();

        txtCustID.setText("");
        txtName.setText("");
        txtPhoneNumber.setText("");
        txtCity.setText("");
        txtAge.setText("");


    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCustAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colCustPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colCustCity.setCellValueFactory(new PropertyValueFactory<>("city"));

        tblCustomeInfo.setItems(customerInfoDTOS);

        tblCustomeInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, customerInfoDTO, t1) -> {
            if(t1 != null){
                txtCustID.setText(t1.getId());
                txtName.setText(t1.getName());
                txtAge.setText(String.valueOf(t1.getAge()));
                txtPhoneNumber.setText(t1.getPhoneNo());
                txtCity.setText(t1.getCity());

            }
        });
    }
}
