module com.niki.conteo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.niki.conteo to javafx.fxml;
    exports com.niki.conteo;
}
