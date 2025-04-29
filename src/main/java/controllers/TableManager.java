package controllers;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TableManager {

    private TableLayout[] tables;
    private Button[][] tableButtons;

    // Constructor to initialize tables and buttons
    public TableManager(GridPane gridPane, int rows, int cols) {
        tables = new TableLayout[rows * cols];
        tableButtons = new Button[rows][cols];
        initializeTablesAndButtons(gridPane, rows, cols);
    }

    // Initialize the table buttons and their associated TableLayout
    private void initializeTablesAndButtons(GridPane gridPane, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int tableIndex = row * cols + col;

                Button tableButton = new Button("Table " + (tableIndex + 1));
                tableButton.setMinWidth(100);
                tableButton.setMinHeight(100);
                tableButton.setStyle("-fx-base: lightgray;");
                final int finalRow = row;
                final int finalCol = col;

                tableButton.setOnAction(e -> handleTableClick(finalRow, finalCol, tableButton));

                tableButtons[row][col] = tableButton;
                tables[tableIndex] = new TableLayout(
                        "Table " + (tableIndex + 1),
                        "clean",
                        "",
                        false,
                        0,
                        ""
                );

                gridPane.add(tableButton, col, row);
            }
        }
    }

    // Handle table selection and update status
    private void handleTableClick(int row, int col, Button tableButton) {
        TableLayout table = tables[row * tableButtons[0].length + col];
        String currentStatus = table.getStatus();

        if ("clean".equals(currentStatus)) {
            // Set back to original appearance for "clean" state
            tableButton.setStyle("-fx-base: lightgray;");
            table.setStatus("clean");
        } else if ("seated".equals(currentStatus)) {
            tableButton.setStyle("-fx-background-color: yellow;");
            table.setStatus("seated");
        } else if ("dirty".equals(currentStatus)) {
            tableButton.setStyle("-fx-background-color: red;");
            table.setStatus("dirty");
        }
    }


    // Getters and Setters for the tables
    public TableLayout getTable(int index) {
        return tables[index];
    }

    public void setTable(int index, TableLayout table) {
        tables[index] = table;
    }
}
