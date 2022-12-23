module com.example.tasks {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.desktop;
    requires java.sql;

    opens com.example.tasks to javafx.fxml;
    exports com.example.tasks;
    exports task1;
    opens task1 to javafx.fxml;
    exports main;
    opens main to javafx.fxml;
}