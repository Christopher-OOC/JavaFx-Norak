module org.example.fx.demo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jdk.compiler;

    opens org.example.fx.demo3 to javafx.fxml;
    exports org.example.fx.demo3;
    exports org.example.fx.demo3.fan;
}