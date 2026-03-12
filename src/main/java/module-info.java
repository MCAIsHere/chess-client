module com.example.chessclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.chessclient to javafx.fxml;
    exports com.example.chessclient;
}