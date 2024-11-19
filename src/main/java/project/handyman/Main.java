package project.handyman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the main structure (MainPageStructure.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/handyman/FXML/MainPageStructure.fxml"));
            Scene scene = new Scene(loader.load());

            // Set the stage
            primaryStage.setTitle("HandyMan Service");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load MainPageStructure.fxml");
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
