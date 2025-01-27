module robolini.paolo.radiobutton {
    requires javafx.controls;
    requires javafx.fxml;


    opens robolini.paolo.radiobutton to javafx.fxml;
    exports robolini.paolo.radiobutton;
}