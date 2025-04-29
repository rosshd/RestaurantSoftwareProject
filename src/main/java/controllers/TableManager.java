package controllers;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


// Constructor to initialize tables and buttons
public class TableManager {

    private TableLayout[] tables;
    private Button[][] tableButtons;

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

    // Getters
    public TableLayout getTable(int index) {
        return tables[index];
    }

    public Button getButton(int row, int col) {
        return tableButtons[row][col];
    }
}


