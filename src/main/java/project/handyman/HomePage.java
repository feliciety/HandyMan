package project.handyman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomePage extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/handyman/FXML/MainpageStructure.fxml"));
            AnchorPane root = loader.load(); // Match the type of the FXML root element

            // Create the Scene
            Scene scene = new Scene(root, 1352, 764);

            // Configure the Stage
            primaryStage.setTitle("Home Page");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
