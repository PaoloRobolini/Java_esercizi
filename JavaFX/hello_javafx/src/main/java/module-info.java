module robolini.paolo.hello_javafx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens robolini.paolo.hello_javafx to javafx.fxml;
    exports robolini.paolo.hello_javafx;
}