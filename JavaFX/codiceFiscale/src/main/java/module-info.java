module robolini.paolo.codicefiscale {
    requires javafx.controls;
    requires javafx.fxml;


    opens robolini.paolo.codicefiscale to javafx.fxml;
    exports robolini.paolo.codicefiscale;
}