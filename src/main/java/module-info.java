module com.example.dsavisualizer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.dsavisualizer to javafx.fxml;
    exports com.example.dsavisualizer;
}