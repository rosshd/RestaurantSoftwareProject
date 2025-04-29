package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ServerPageController {

    @FXML
    private ListView<String> serverTablesListView;

    @FXML
    private Button startOrderButton;

    @FXML
    private Button editOrderButton;

    @FXML
    private Button sendOrderButton;

    @FXML
    private Button splitCheckButton;

    @FXML
    private Button transferTableButton;

    @FXML
    private Button refundItemButton;

    @FXML
    private Button enterTipsButton;

    @FXML
    private Button trackSalesButton;

    @FXML
    public void initialize() {
        // Dummy data for testing
        serverTablesListView.getItems().addAll("Table 1", "Table 2", "Table 3");
    }

    @FXML
    private void handleStartOrder() {
        String selectedTable = serverTablesListView.getSelectionModel().getSelectedItem();
        if (selectedTable != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pages/OrderPage.fxml"));
                Scene scene = new Scene(loader.load());

                Stage stage = (Stage) startOrderButton.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Order Page - " + selectedTable);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace(); // so you see errors if it fails
            }
        } else {
            showAlert("No table selected", "Please select a table to start an order.");
        }
    }


    @FXML
    private void handleEditOrder() {
        String selectedTable = serverTablesListView.getSelectionModel().getSelectedItem();
        if (selectedTable != null) {
            System.out.println("Editing order for " + selectedTable);
            // TODO: Open existing order to edit
        } else {
            showAlert("No table selected", "Please select a table to edit the order.");
        }
    }

    @FXML
    private void handleSendOrder() {
        System.out.println("Order sent to kitchen!");
        // TODO: Send current order to kitchen system
    }

    @FXML
    private void handleSplitCheck() {
        System.out.println("Splitting check...");
        // TODO: Logic for splitting a check
    }

    @FXML
    private void handleTransferTable() {
        System.out.println("Transferring table...");
        // TODO: Transfer table to another server
    }

    @FXML
    private void handleRefundItem() {
        System.out.println("Refunding/discounting item...");
        // TODO: Manager approval -> Refund or discount
    }

    @FXML
    private void handleEnterTips() {
        System.out.println("Entering tips...");
        // TODO: Open tips entry popup
    }

    @FXML
    private void handleTrackSales() {
        System.out.println("Tracking sales...");
        // TODO: Show sales for this server
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
