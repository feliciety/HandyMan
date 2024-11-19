module project.handyman {
    requires javafx.controls;
    requires javafx.fxml;


    opens project.handyman to javafx.fxml;
    exports project.handyman;
}