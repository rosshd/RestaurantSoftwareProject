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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        loadServersFromFile();


        // Initialize TableManager with gridPane and number of rows/columns
        tableManager = new TableManager(gridPane, 5, 6);  // 5 rows, 6 columns
        // Attach click events manually
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 6; col++) {
                Button btn = tableManager.getButton(row, col);
                if (btn != null) {
                    final int r = row;
                    final int c = col;
                    btn.setOnAction(e -> handleTableClick(r, c, btn));
                }
            }
        }
    }
    private void loadServersFromFile() {
        ObservableList<String> servers = FXCollections.observableArrayList();
        //imports servers from .txt file to display in dropdown
        try (InputStream is = getClass().getResourceAsStream("/Pages/waitstaff.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String pin = parts[1];
                    String role = parts[2];

                    if (role.trim().equalsIgnoreCase("Server")) {
                        servers.add(name);  // Only add servers!
                    }
                }
            }
            serverComboBox.setItems(servers);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
