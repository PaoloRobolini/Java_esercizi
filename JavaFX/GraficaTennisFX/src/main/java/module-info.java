module org.example.graficatennisfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.graficatennisfx to javafx.fxml;
    exports org.example.graficatennisfx;
}