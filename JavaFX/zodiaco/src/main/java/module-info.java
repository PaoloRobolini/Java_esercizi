module robolini.paolo.zodiaco {
    requires javafx.controls;
    requires javafx.fxml;


    opens robolini.paolo.zodiaco to javafx.fxml;
    exports robolini.paolo.zodiaco;
}