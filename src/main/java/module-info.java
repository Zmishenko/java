module com.example.tasks {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.tasks to javafx.fxml;
    exports com.example.tasks;
    exports task1;
    opens task1 to javafx.fxml;
    exports main;
    opens main to javafx.fxml;
}