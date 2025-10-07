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
import model.dto.EmployeeDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    ObservableList<EmployeeDTO> employeeDTOS = FXCollections.observableArrayList(new EmployeeDTO("S001",  "Receptionist", "Alice Johnson", "alice.johnson@hotel.com", "555-1234", 45000.00),
            new EmployeeDTO("S002", "Brian Smith", "Manager", "555-5678", "brian.smith@hotel.com",  75000.00),
            new EmployeeDTO("S003", "Catherine Lee", "Housekeeping", "555-8765", "catherine.lee@hotel.com",  40000.00),
            new EmployeeDTO("S004", "David Kim", "Receptionist", "555-3456", "david.kim@hotel.com",  46000.00),
            new EmployeeDTO("S005", "Emma Brown", "Manager", "555-7890","emma.brown@hotel.com",  78000.00)
    );


    @FXML
    private TableColumn<?, ?> colEmpEmail;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colEmpName;

    @FXML
    private TableColumn<?, ?> colEmpPhoneNo;

    @FXML
    private TableColumn<?, ?> colEmpRole;

    @FXML
    private TableColumn<?, ?> colEmpSalary;

    @FXML
    private TableView<EmployeeDTO> tblEmpInfo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmpID;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtRole;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        employeeDTOS.add(new EmployeeDTO(txtEmpID.getText(), txtEmpName.getText(), txtRole.getText(), txtPhoneNumber.getText(), txtEmail.getText(), Double.parseDouble(txtSalary.getText())));
        tblEmpInfo.refresh();

        txtEmpID.setText("");
        txtEmpName.setText("");
        txtPhoneNumber.setText("");
        txtRole.setText("");
        txtEmail.setText("");
        txtSalary.setText("");

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtEmpID.clear();
        txtEmpName.clear();
        txtRole.clear();
        txtPhoneNumber.clear();
        txtEmail.clear();
        txtSalary.clear();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        EmployeeDTO selectedItem = tblEmpInfo.getSelectionModel().getSelectedItem();

        selectedItem.setEmpID(txtEmpID.getText());
        selectedItem.setName(txtEmpName.getText());
        selectedItem.setRole(txtRole.getText());
        selectedItem.setPhoneNo(txtPhoneNumber.getText());
        selectedItem.setEmail(txtEmail.getText());
        selectedItem.setSalary(Double.parseDouble(txtSalary.getText()));

        tblEmpInfo.refresh();

        txtEmpID.setText("");
        txtEmpName.setText("");
        txtRole.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtSalary.setText("");

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        txtEmpID.setText("");
        txtEmpName.setText("");
        txtRole.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtSalary.setText("");

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmpID.setCellValueFactory(new PropertyValueFactory<>("empID"));
        colEmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmpRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmpPhoneNo.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colEmpEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEmpSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tblEmpInfo.setItems(employeeDTOS);

        tblEmpInfo.getSelectionModel().selectedItemProperty().addListener((observableValue, employeeDTO, t1) -> {
            if(t1 != null) {
                txtEmpID.setText(t1.getEmpID());
                txtEmpName.setText(t1.getName());
                txtRole.setText(t1.getRole());
                txtPhoneNumber.setText(t1.getPhoneNo());
                txtEmail.setText(t1.getEmail());
                txtSalary.setText(String.valueOf(t1.getSalary()));

            }
        });
    }
}