package org.example.fx.demo3.fan;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FanMain extends Application {

    @Override
    public void start(Stage primaryStage) {

        StackPane stackPane = new StackPane();

        Fan fan = new Fan();

        FanControl fanControl = new FanControl(fan);

        stackPane.getChildren().add(fan);

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(
                Color.GOLD,
                CornerRadii.EMPTY,
                new Insets(0)
        )));

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
