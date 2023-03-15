module com.example.ce26projecttest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ce26projecttest to javafx.fxml;
    exports com.example.ce26projecttest;
}