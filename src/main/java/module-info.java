module com.example.testgaming {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testgaming to javafx.fxml;
    exports com.example.testgaming;
}