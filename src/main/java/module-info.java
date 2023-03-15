module com.example.ce26projecttest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ce216project to javafx.fxml;
    exports com.example.ce216project;
}