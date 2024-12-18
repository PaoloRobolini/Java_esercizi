module robolini.paolo.pallavolo {
    requires javafx.controls;
    requires javafx.fxml;


    opens robolini.paolo.pallavolo to javafx.fxml;
    exports robolini.paolo.pallavolo;
}