module com.niki.fabula {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.niki.fabula to javafx.fxml;
    exports com.niki.fabula;
}
