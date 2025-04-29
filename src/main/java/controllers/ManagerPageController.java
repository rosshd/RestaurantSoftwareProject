package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManagerPageController {

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Button createEmployeeButton;

    @FXML
    private Button changeLayoutButton;

    @FXML
    private Button trackEmployeeButton;

    @FXML
    private Button trackSalesButton;

    @FXML
    private Button trackInventoryButton;

    @FXML
    private ListView<String> employeeActivityList;

    @FXML
    private ListView<String> salesList;

    @FXML
    private ListView<String> inventoryList;

    @FXML
    public void initialize() {
        // Populate tabs with dummy data for testing
        employeeActivityList.getItems().addAll("Employee 1: Logged in", "Employee 2: Clocked out");
        salesList.getItems().addAll("Sale 1: $100", "Sale 2: $200");
        inventoryList.getItems().addAll("Item 1: 10 left", "Item 2: 5 left");
    }

    @FXML
    private void handleCreateEmployee() {
        System.out.println("Creating new employee...");
        // TODO: Logic to create new employee (form, assign role, etc.)
        showAlert("Create Employee", "This will allow you to create a new employee.");
    }

    @FXML
    private void handleChangeLayout() {
        System.out.println("Changing table layout...");
        // TODO: Logic to change the restaurant’s table layout
        showAlert("Change Table Layout", "You can change the restaurant's table layout.");
    }

    @FXML
    private void handleTrackEmployeeActivity() {
        System.out.println("Tracking employee activity...");
        // TODO: Logic to track employee activity (e.g., hours worked, tasks completed)
        showAlert("Track Employee Activity", "This will allow you to track employee activities.");
    }

    @FXML
    private void handleTrackSales() {
        System.out.println("Tracking sales...");
        // TODO: Logic to track sales (e.g., total sales, sales by item)
        showAlert("Track Sales", "You can track sales and performance.");
    }

    @FXML
    private void handleTrackInventory() {
        System.out.println("Tracking inventory...");
        // TODO: Logic to track inventory (e.g., current stock, reorder levels)
        showAlert("Track Inventory", "This will allow you to track the inventory.");
    }

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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
