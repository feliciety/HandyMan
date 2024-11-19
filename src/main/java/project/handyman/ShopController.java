package project.handyman;

import javafx.fxml.FXML;
import javafx.scene.layout.*;

import java.util.List;

public class ShopController {

    @FXML
    private GridPane gridPane; // Linked to your GridPane in shop.fxml

    public void initialize() {
        // Initialize the product cards
        initializeProductCards();

        // Set the grid size for responsive layout
        setGridPaneSize();
    }

    private void initializeProductCards() {
        // Fixed number of columns
        final int maxColumns = 3; // Define the maximum columns
        int column = 0;
        int row = 0;

        // Product list with corrected file paths
        List<productCard> products = List.of(
                new productCard("Cordless Drill", "/project/handyman/Images/CordlessDrill.png", "$18.20 - $18.75"),
                new productCard("Hand Drill", "/project/handyman/Images/handdrill.png", "$15.00 - $16.50"),
                new productCard("Hand Saw", "/project/handyman/Images/handsaw.png", "$12.00 - $10.00"),
                new productCard("Hand Vacuum", "/project/handyman/Images/HandVacuum.png", "$15.50 - $16.30"),
                new productCard("Helmet", "/project/handyman/Images/helmet.png", "$12.85 - $12.70"),
                new productCard("Metal Hand Jigsaw", "/project/handyman/Images/metalhandjigsaw.png", "$20.00 - $21.50"),
                new productCard("Metal Shovel", "/project/handyman/Images/metalshovel.png", "$10.75 - $11.00"),
                new productCard("Pipe Wrench", "/project/handyman/Images/pipewrench.png", "$9.70 - $10.60"),
                new productCard("Rubber Hand Gloves", "/project/handyman/Images/ruberhandgloves.png", "$5.00 - $6.50"),
                new productCard("Steel Hammer", "/project/demo/handyman/steelhammer.png", "$7.50 - $8.20"),
                new productCard("Steel Plier", "/project/demo/handyman/steelplier.png", "$9.70 - $10.60"),
                new productCard("Toolbox", "/project/demo/handyman/toolbox.png", "$25.00 - $26.50")
        );

        // Ensure the GridPane has proper spacing between cells
        gridPane.setHgap(10); // Horizontal spacing between columns
        gridPane.setVgap(10); // Vertical spacing between rows

        // Add product cards to GridPane
        for (productCard product : products) {
            VBox productCardVBox = product.createProductCard();
            gridPane.add(productCardVBox, column, row);

            // Increment column and reset after max columns
            column++;
            if (column == maxColumns) {
                column = 0;
                row++;
            }
        }
    }

    private void setGridPaneSize() {
        // Get the number of rows dynamically based on the number of products
        int totalProducts = 12; // Adjust this to match your actual product list size
        int rowsRequired = (int) Math.ceil((double) totalProducts / 3); // Calculate rows based on 3 columns

        // Set column constraints dynamically
        gridPane.getColumnConstraints().clear(); // Clear any previous constraints
        for (int i = 0; i < 3; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(300);  // Set the preferred width for each column
            col.setHgrow(Priority.ALWAYS);  // Allow it to grow if necessary
            gridPane.getColumnConstraints().add(col);
        }

        // Set row constraints dynamically based on the calculated rows
        gridPane.getRowConstraints().clear(); // Clear any previous row constraints
        for (int i = 0; i < rowsRequired; i++) {
            RowConstraints row = new RowConstraints();
            row.setPrefHeight(300);  // Set the preferred height for each row
            row.setVgrow(Priority.ALWAYS);  // Allow it to grow if necessary
            gridPane.getRowConstraints().add(row);
        }
    }
}
