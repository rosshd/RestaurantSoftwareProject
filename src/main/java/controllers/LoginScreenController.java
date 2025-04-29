package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class LoginScreenController {

    @FXML
    private Label pinDisplay;

    private StringBuilder enteredPin = new StringBuilder();

    // Hardcoded pins: PIN -> Role
    private Map<String, StaffMember> pinToStaff = new HashMap<>();

    @FXML
    private void initialize() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/Pages/waitstaff.txt")))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String pin = parts[1].trim();
                    String role = parts[2].trim();
                    pinToStaff.put(pin, new StaffMember(name, pin, role));
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            System.out.println("Could not load waitstaff.txt");
        }
    }

        // Initialize some sample employee pins
        //employeePins.put("1234", "Host");
        //employeePins.put("2345", "Busboy");
       //employeePins.put("3456", "Server");
        //employeePins.put("4567", "Cook");
        //employeePins.put("5678", "Manager");




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
        StaffMember staff = pinToStaff.get(pin);

        if (staff != null) {
            String name = staff.getName();
            String role = staff.getRole();
            System.out.println("Login successful! Welcome " + name + " (" + role + ")");
            pinDisplay.setText("Welcome, " + name + "!");

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
                fxmlFile = "/Pages/BusBoyPage.fxml"; // Path to busboy's page
            } else if ("Server".equals(role)) {
                fxmlFile = "/Pages/ServerPage.fxml"; // Path to server's page
            } else if ("Cook".equals(role)) {
                fxmlFile = "/Pages/KitchenPage.fxml"; // Path to cook's page
            } else if ("Manager".equals(role)) {
                fxmlFile = "/Pages/ManagerPage.fxml"; // Path to manager's page
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
