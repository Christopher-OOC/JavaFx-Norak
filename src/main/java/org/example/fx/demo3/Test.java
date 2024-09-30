package org.example.fx.demo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("This is Christopher");

        StackPane pane = new StackPane();

        GridPane pane1 = new GridPane();
        pane1.add(new Button("hj"), 4, 4);

        Circle circle = new Circle();

        Label label = new Label("Hello");



        Scene scene = new Scene(button, 400, 400);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}
