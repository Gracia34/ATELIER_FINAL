module org.example.apk {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.apk to javafx.fxml;
    exports org.example.apk;
}