module com.ce216.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;




    opens com.ce216.dictionary to javafx.fxml;
    exports com.ce216.dictionary;
}