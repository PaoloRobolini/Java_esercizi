module robolini.paolo.testivari {
    requires javafx.controls;
    requires javafx.fxml;


    opens robolini.paolo.testivari to javafx.fxml;
    exports robolini.paolo.testivari;
}