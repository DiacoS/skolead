module com.example.skolead {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.skolead to javafx.fxml;
    exports com.example.skolead;
    exports com.example.skolead.Controller;
    opens com.example.skolead.Controller to javafx.fxml;
}