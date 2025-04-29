package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class TableViewController {
    @FXML private Button table1, table2, table3, table4, table5;
    @FXML private Button table6, table7, table8, table9, table10;
    @FXML private Button table11, table12, table13, table14, table15;
    @FXML private Button table16, table17, table18, table19, table20;
    @FXML private Button table21, table22, table23, table24, table25;
    @FXML private Button table26, table27, table28, table29, table30;

    @FXML private ComboBox<String> serverComboBox;
    @FXML private GridPane gridPane;

    private TableManager tableManager;

    @FXML
    public void initialize() {
        ObservableList<String> servers = FXCollections.observableArrayList("Server 1", "Server 2", "Server 3");
        serverComboBox.setItems(servers);

        // Initialize TableManager with gridPane and number of rows/columns
        tableManager = new TableManager(gridPane, 5, 6);  // 5 rows, 6 columns
    }

    // Handling table click (marking tables as sat/dirty/empty)
    @FXML
    private void handleTableClick(int row, int col, Button tableButton) {
        TableLayout table = tableManager.getTable(row * 6 + col);
        String currentStatus = table.getStatus();

        if ("clean".equals(currentStatus)) {
            tableButton.setStyle("-fx-background-color: yellow;"); // Seated
            table.setStatus("seated");
        } else if ("seated".equals(currentStatus)) {
            tableButton.setStyle("-fx-background-color: red;"); // Dirty
            table.setStatus("dirty");
        } else {
            tableButton.setStyle("-fx-background-color: green;"); // Clean
            table.setStatus("clean");
        }
    }

    // Handling server assignment
    @FXML
    private void handleAssignServer() {
        String selectedServer = serverComboBox.getValue();
        System.out.println("Assigned server: " + selectedServer);
    }

    // Handling reservation actions
    @FXML
    private void handleTakeReservation() {
        showAlert("Reservation", "Reservation has been taken.");
    }

    @FXML
    private void handleCancelReservation() {
        showAlert("Reservation", "Reservation has been canceled.");
    }

    @FXML
    private void handleEditReservation() {
        showAlert("Reservation", "Reservation has been edited.");
    }

    // Handling call-in orders
    @FXML
    private void handleCallInOrder() {
        showAlert("Order", "Call-in order has been placed.");
    }

    // Handling logout functionality
    @FXML
    private Button logoutButton;  // Declare the logoutButton

    @FXML
    private void handleLogout() {
        try {
            // Load the LoginPage FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pages/LoginPage.fxml"));
            Scene scene = new Scene(loader.load());

            // Get the current stage and set the new scene
            Stage stage = (Stage) logoutButton.getScene().getWindow();  // Get the current window
            stage.setScene(scene);
            stage.setTitle("Login - Restaurant System");
            stage.show();
        } catch(Exception e) {

            // Handle the error if the FXML file cannot be loaded
        }
    }



    // Utility method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
