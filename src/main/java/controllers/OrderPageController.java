package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderPageController {

    @FXML
    private ListView<MenuItem> orderListView;

    @FXML
    private Button addItemButton;

    @FXML
    private Button editItemButton;

    @FXML
    private Button removeItemButton;

    @FXML
    private Button clearOrderButton;

    @FXML
    private Label totalLabel;

    @FXML
    private ListView<MenuItem> menuListView;

    private ObservableList<MenuItem> orderItems = FXCollections.observableArrayList();
    private ObservableList<MenuItem> menuItems = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Example menu items - you'd load these from your database/file in reality
        menuItems.addAll(
                new MenuItem("Burger", 8.99),
                new MenuItem("Fries", 3.49),
                new MenuItem("Soda", 1.99),
                new MenuItem("Salad", 5.99)
        );

        menuListView.setItems(menuItems);
        orderListView.setItems(orderItems);

        updateTotal();
    }

    @FXML
    private void handleAddItem() {
        MenuItem selectedItem = menuListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            orderItems.add(new MenuItem(selectedItem.getName(), selectedItem.getPrice()));
            updateTotal();
        } else {
            showError("Please select an item to add.");
        }
    }

    @FXML
    private void handleEditItem() {
        MenuItem selectedItem = orderListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Example: Increase price slightly (you would make this a proper editor popup later)
            selectedItem.setPrice(selectedItem.getPrice() + 1.00);
            orderListView.refresh();
            updateTotal();
        } else {
            showError("Please select an order item to edit.");
        }
    }

    @FXML
    private void handleRemoveItem() {
        MenuItem selectedItem = orderListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            orderItems.remove(selectedItem);
            updateTotal();
        } else {
            showError("Please select an item to remove.");
        }
    }

    @FXML
    private void handleClearOrder() {
        orderItems.clear();
        updateTotal();
    }

    private void updateTotal() {
        double total = 0;
        for (MenuItem item : orderItems) {
            total += item.getPrice();
        }
        totalLabel.setText(String.format("Total: $%.2f", total));
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
