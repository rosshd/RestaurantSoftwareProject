package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
            System.out.println("Starting order for " + selectedTable);
            // TODO: Open OrderPage for this table
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
