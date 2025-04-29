package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderPageController {

    @FXML private ListView<MenuItem> orderListView;
    @FXML private Button addItemButton;
    @FXML private Button editItemButton;
    @FXML private Button removeItemButton;
    @FXML private Button clearOrderButton;
    @FXML private Button ServerBackButton;
    @FXML private Label totalLabel;
    @FXML private ListView<MenuItem> menuListView;
    @FXML private ComboBox<String> categoryComboBox;

    private ObservableList<MenuItem> orderItems = FXCollections.observableArrayList();
    private ObservableList<MenuItem> menuItems = FXCollections.observableArrayList();
    private Map<String, List<MenuItem>> categorizedMenu = new HashMap<>();

    @FXML
    public void initialize() {
        // Define categories with 4+ items each
        categorizedMenu.put("Appetizers", List.of(
                new MenuItem("Fries", 3.49),
                new MenuItem("Mozzarella Sticks", 5.99),
                new MenuItem("Wings", 7.99),
                new MenuItem("Nachos", 6.25)
        ));
        categorizedMenu.put("Entrees", List.of(
                new MenuItem("Burger", 8.99),
                new MenuItem("Breakfast Sampler", 11.69),
                new MenuItem("Steak", 14.99),
                new MenuItem("Pasta", 11.49)
        ));
        categorizedMenu.put("Desserts", List.of(
                new MenuItem("Cake", 4.50),
                new MenuItem("Ice Cream", 3.99),
                new MenuItem("Pie", 4.25),
                new MenuItem("Brownie", 3.75)
        ));
        categorizedMenu.put("Drinks", List.of(
                new MenuItem("Soda", 1.99),
                new MenuItem("Water", 1.00),
                new MenuItem("Coffee", 2.49),
                new MenuItem("Juice", 2.99)
        ));
        categorizedMenu.put("Specials", List.of(
                new MenuItem("Lunch Combo", 9.99),
                new MenuItem("Family Meal", 29.99),
                new MenuItem("Vegan Platter", 12.49),
                new MenuItem("Kids Meal", 6.49)
        ));

        categoryComboBox.setItems(FXCollections.observableArrayList(categorizedMenu.keySet()));
        categoryComboBox.getSelectionModel().selectFirst();
        loadMenuItems(categoryComboBox.getValue());

        orderListView.setItems(orderItems);
        updateTotal();
    }

    private void loadMenuItems(String category) {
        menuItems.setAll(categorizedMenu.getOrDefault(category, List.of()));
        menuListView.setItems(menuItems);
    }

    @FXML
    private void handleCategoryChange() {
        String selectedCategory = categoryComboBox.getValue();
        loadMenuItems(selectedCategory);
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
            TextInputDialog dialog = new TextInputDialog(String.valueOf(selectedItem.getPrice()));
            dialog.setTitle("Edit Item Price");
            dialog.setHeaderText("Edit price for: " + selectedItem.getName());
            dialog.setContentText("Enter new price:");

            dialog.showAndWait().ifPresent(input -> {
                try {
                    double newPrice = Double.parseDouble(input);
                    if (newPrice < 0) {
                        showError("Price cannot be negative.");
                    } else {
                        selectedItem.setPrice(newPrice);
                        orderListView.refresh();
                        updateTotal();
                    }
                } catch (NumberFormatException e) {
                    showError("Invalid price entered.");
                }
            });
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
    private double calculateTotal() {
        return orderItems.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    @FXML
    private void handleSendOrder() {
        if (orderItems.isEmpty()) {
            showError("Cannot send an empty order.");
            return;
        }

        System.out.println("===== ORDER SENT TO KITCHEN =====");
        for (MenuItem item : orderItems) {
            System.out.printf("- %s: $%.2f%n", item.getName(), item.getPrice());
        }
        System.out.printf("TOTAL: $%.2f%n", calculateTotal());
        System.out.println("==================================");

        orderItems.clear();
        updateTotal();
    }


    @FXML
    private void backToServerPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Pages/ServerPage.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ServerBackButton.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Restaurant System - Server");
            stage.show();
        } catch (Exception e) {
            showError("Could not load Server Page.");
        }
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
