package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class KitchenPageController {

    @FXML
    private ListView<String> orderListView;

    @FXML
    private Button finishTicketButton;

    @FXML
    private Button pullUpOrdersButton;

    @FXML
    private Button markItemsCompleteButton;

    @FXML
    public void initialize() {
        // Dummy data for testing
        orderListView.getItems().addAll("Order 1", "Order 2", "Order 3");
    }

    @FXML
    private void handleFinishTicket() {
        String selectedOrder = orderListView.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            System.out.println("Finishing ticket for " + selectedOrder);
            // TODO: Mark this order as finished
        } else {
            showAlert("No order selected", "Please select an order to finish.");
        }
    }

    @FXML
    private void handlePullUpOrders() {
        System.out.println("Pulling up past orders...");
        // TODO: Show past orders history (search and retrieve orders)
    }

    @FXML
    private void handleMarkItemsComplete() {
        String selectedOrder = orderListView.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            System.out.println("Marking items as complete for " + selectedOrder);
            // TODO: Mark items as complete on the selected order
        } else {
            showAlert("No order selected", "Please select an order to mark items complete.");
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
