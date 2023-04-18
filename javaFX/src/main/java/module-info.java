module at.technikum.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens at.technikum.javafx to javafx.fxml;
    exports at.technikum.javafx;
}