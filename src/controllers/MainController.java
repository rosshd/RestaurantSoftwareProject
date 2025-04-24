package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    public void handleButtonAction(ActionEvent event) {
        System.out.println("Button clicked!");
    }
}