module com.example.testfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testfx to javafx.fxml;
    exports com.example.testfx;
}