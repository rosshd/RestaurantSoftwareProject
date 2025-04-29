package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginScreenController {

    @FXML
    private Label pinDisplay;

    private StringBuilder enteredPin = new StringBuilder();

    // Hardcoded pins: PIN -> Role
    private Map<String, String> employeePins = new HashMap<>();

    @FXML
    private void initialize() {
        // Initialize some sample employee pins
        employeePins.put("1234", "Host");
        employeePins.put("2345", "Busboy");
        employeePins.put("3456", "Server");
        employeePins.put("4567", "Cook");
        employeePins.put("5678", "Manager");
    }

    @FXML
    private void handleNumberButton(ActionEvent event) {
        if (enteredPin.length() < 4) {
            Button pressedButton = (Button) event.getSource();
            enteredPin.append(pressedButton.getText());
            updatePinDisplay();
        }
    }

    @FXML
    private void handleClearButton() {
        enteredPin.setLength(0);
        updatePinDisplay();
    }

    @FXML
    private void handleEnterButton() {
        String pin = enteredPin.toString();
        if (employeePins.containsKey(pin)) {
            String role = employeePins.get(pin);
            System.out.println("Login successful! Role: " + role);
            pinDisplay.setText("Welcome, " + role + "!");

            // Load the appropriate page based on the role
            loadRolePage(role);
        } else {
            System.out.println("Login failed!");
            pinDisplay.setText("Invalid PIN. Try again.");
        }
        enteredPin.setLength(0);
    }

    private void updatePinDisplay() {
        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < enteredPin.length(); i++) {
            masked.append("*");
        }
        pinDisplay.setText(masked.toString());
    }

    private void loadRolePage(String role) {
        try {
            // Determine the path of the FXML file based on the role
            String fxmlFile = "";
            if ("Host".equals(role)) {
                fxmlFile = "/Pages/TableViewPage.fxml"; // Path to Host's table view page
            } else if ("Busboy".equals(role)) {
                fxmlFile = "/Pages/BusboyPage.fxml"; // Example: Path to busboy's page
            } else if ("Server".equals(role)) {
                fxmlFile = "/Pages/ServerPage.fxml"; // Example: Path to server's page
            } else if ("Cook".equals(role)) {
                fxmlFile = "/Pages/KitchenPage.fxml"; // Example: Path to cook's page
            } else if ("Manager".equals(role)) {
                fxmlFile = "/Pages/ManagerPage.fxml"; // Example: Path to manager's page
            }

            // Load the corresponding page based on role
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());

            // Get the current stage and change the scene
            Stage stage = (Stage) pinDisplay.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Restaurant System - " + role);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            pinDisplay.setText("Error loading page.");
        }
    }
}
