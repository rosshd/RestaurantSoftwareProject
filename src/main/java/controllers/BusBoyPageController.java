package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BusBoyPageController {
    @FXML
    private GridPane gridPane;

    private Button selectedTable;
    private TableManager tableManager;

    @FXML
    public void initialize() {
        // Initialize TableManager with gridPane and number of rows/columns
        tableManager = new TableManager(gridPane, 5, 6);  // 5 rows, 6 columns
    }

    // Mark selected table as Clean
    @FXML
    private void handleMarkClean() {
        if (selectedTable != null) {
            int tableIndex = Integer.parseInt(selectedTable.getText().split(" ")[1]) - 1;
            TableLayout table = tableManager.getTable(tableIndex);
            table.setStatus("clean");
            selectedTable.setStyle("-fx-base: lightgreen;");
            System.out.println(selectedTable.getText() + " marked as Clean");
        }
    }

    // Mark selected table as Dirty
    @FXML
    private void handleMarkDirty() {
        if (selectedTable != null) {
            int tableIndex = Integer.parseInt(selectedTable.getText().split(" ")[1]) - 1;
            TableLayout table = tableManager.getTable(tableIndex);
            table.setStatus("dirty");
            selectedTable.setStyle("-fx-base: lightcoral;");
            System.out.println(selectedTable.getText() + " marked as Dirty");
        }
    }

    // Mark selected table as Seated
    @FXML
    private void handleMarkSeated() {
        if (selectedTable != null) {
            int tableIndex = Integer.parseInt(selectedTable.getText().split(" ")[1]) - 1;
            TableLayout table = tableManager.getTable(tableIndex);
            table.setStatus("seated");
            selectedTable.setStyle("-fx-base: lightyellow;");
            System.out.println(selectedTable.getText() + " marked as Seated");
        }
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
}


