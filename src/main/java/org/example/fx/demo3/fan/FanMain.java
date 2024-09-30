package org.example.fx.demo3.fan;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FanMain extends Application {

    @Override
    public void start(Stage primaryStage) {

        StackPane stackPane = new StackPane();

        Fan fan = new Fan();

        FanControl fanControl = new FanControl(fan);

        stackPane.getChildren().add(fan);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(stackPane);
        borderPane.setLeft(fanControl);

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotating Fan");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
