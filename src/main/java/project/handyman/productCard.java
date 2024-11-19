package project.handyman;

import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class productCard {

    private final String name;
    private final String imagePath;
    private final String price;

    public productCard(String name, String imagePath, String price) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getPrice() {
        return price;
    }

    // Creates a VBox (product card) dynamically without FXML
    public VBox createProductCard() {
        // Create VBox for product card layout
        VBox productCard = new VBox(10); // 10px spacing
        productCard.setStyle("-fx-padding: 10px; -fx-background-color: #f0f0f0; -fx-border-radius: 5px;");

        // Create ImageView for product image
        Image image = loadImage(imagePath);
        ImageView productImage = new ImageView(image);
        productImage.setFitHeight(100);  // Set the size of the image
        productImage.setFitWidth(100);
        productImage.setPreserveRatio(true);  // Keep aspect ratio

        // Create Labels for product name and price
        Label productName = new Label(name);
        productName.setFont(new Font("Arial", 14));  // Set font size and style

        Label productPrice = new Label(price);
        productPrice.setFont(new Font("Arial", 12));  // Set font size and style

        // Add Image and Labels to VBox
        productCard.getChildren().addAll(productImage, productName, productPrice);

        return productCard;
    }

    // Method to load image with error handling
    private Image loadImage(String imagePath) {
        try {
            return new Image(getClass().getResource(imagePath).toExternalForm());
        } catch (NullPointerException e) {
            // Handle error (image not found)
            System.err.println("Error loading image: " + imagePath);
            return new Image(getClass().getResource("default-image.jpg").toExternalForm());  // Use a default image if error occurs
        }
    }
}
