module com.fx.market {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.graphics;

    opens com.fx.market to javafx.fxml;
    exports com.fx.market;
    exports com.fx.market.controller;
    opens com.fx.market.controller to javafx.fxml;
}