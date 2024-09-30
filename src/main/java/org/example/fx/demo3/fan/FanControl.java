package org.example.fx.demo3.fan;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.util.Duration;

public class FanControl extends VBox {

    private Text controlOne = new Text("1");
    private Text controlTwo = new Text("2");
    private Text controlThree =  new Text("3");
    private Text controlFour =  new Text("4");
    private Text controlFive =  new Text("5");
    private Button controlStart = new Button("Start");
    private Button controlStop = new Button("Stop");
    private Button controlReverse = new Button("Reverse");
    private Circle numberControlCircle = new Circle(0, 0, 20);;
    private StackPane controlPane1 = new StackPane();
    private StackPane controlPane2 = new StackPane();
    private StackPane controlPane3 = new StackPane();
    private StackPane controlPane4 = new StackPane();
    private StackPane controlPane5 = new StackPane();
    private StackPane[] arrStack = {
            controlPane1,
            controlPane2,
            controlPane3,
            controlPane4,
            controlPane5};

    private Text[] arrNumberText = {
            controlOne,
            controlTwo,
            controlThree,
            controlFour,
            controlFive};

    private Timeline animation;
    private Timeline slowDownAnimation;

    private Fan fan;
    private double decrementAngle = 1;


    public FanControl(Fan fan) {

        this.fan = fan;

        controlOne.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
        controlTwo.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
        controlThree.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
        controlFour.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
        controlFive.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
        controlStart.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
        controlStop.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));
        controlReverse.setFont(Font.font("Sans-Serif", FontWeight.BOLD, FontPosture.ITALIC, 30));

        numberControlCircle.setFill(Color.BLACK);


        this.setPadding(new Insets(60, 40, 60, 40));
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.DOTTED,
                new CornerRadii(10),
                new BorderWidths(2)
        )));

        this.setBackground(new Background(new BackgroundFill(
                Color.GOLD,
                CornerRadii.EMPTY,
                new Insets(0)
        )));

        controlPane1.setPadding(new Insets(10));
        controlPane2.setPadding(new Insets(10));
        controlPane3.setPadding(new Insets(10));
        controlPane4.setPadding(new Insets(10));
        controlPane5.setPadding(new Insets(10));

        controlPane1.getChildren().add(controlOne);
        controlPane2.getChildren().add(controlTwo);
        controlPane3.getChildren().add(controlThree);
        controlPane4.getChildren().add(controlFour);
        controlPane5.getChildren().add(controlFive);

        this.getChildren().addAll(
                controlStart,
                controlPane1,
                controlPane2,
                controlPane3,
                controlPane4,
                controlPane5,
                controlReverse,
                controlStop);

        animation = new Timeline(new KeyFrame(
                Duration.millis(20),
                e -> {

                    fan.getFirstFanBlade().setStartAngle(
                            fan
                                    .getFirstFanBlade()
                                    .getStartAngle() + decrementAngle
                    );

                    fan.getSecondFanBlade().setStartAngle(
                            fan
                                    .getSecondFanBlade()
                                    .getStartAngle() + decrementAngle
                    );

                    fan.getThirdFanBlade().setStartAngle(
                            fan
                                    .getThirdFanBlade()
                                    .getStartAngle() + decrementAngle
                    );


                }
        ));
        animation.setRate(4);
        animation.setCycleCount(Timeline.INDEFINITE);

        slowDownAnimation = new Timeline(new KeyFrame(
                Duration.millis(100),
                e -> {

                    decrementAngle = decrementAngle - 0.0001;
                    System.out.println("Decrement: " + decrementAngle);

                }
        ));

        slowDownAnimation.setCycleCount(Timeline.INDEFINITE);
        slowDownAnimation.setRate(2);

        controlStart.setOnAction(e -> {
            changeClickColor();
            controlPane1.getChildren().remove(controlOne);
            controlOne.setFill(Color.WHITE);
            controlPane1.getChildren().addAll(numberControlCircle, controlOne);

            startFan();
        });

        controlStop.setOnAction(e -> {

            stopFan();
        });

        controlReverse.setOnAction(e -> {
            reverseFan();
        });


        this.setOnMouseClicked(e -> {

            if (e.getTarget().equals(controlOne)) {

                changeClickColor();

                if (!controlPane1.getChildren().contains(numberControlCircle)) {
                    controlPane1.getChildren().remove(controlOne);
                    controlOne.setFill(Color.WHITE);
                    controlPane1.getChildren().addAll(numberControlCircle, controlOne);
                    animation.setRate(4);
                }
            }
            else if (e.getTarget().equals(controlTwo)) {
                if (e.getTarget().equals(controlTwo)) {

                    changeClickColor();

                    if (!controlPane2.getChildren().contains(numberControlCircle)) {
                        controlPane2.getChildren().remove(controlTwo);
                        controlTwo.setFill(Color.WHITE);
                        controlPane2.getChildren().addAll(numberControlCircle, controlTwo);
                        animation.setRate(8);
                    }
                }
            }
            else if (e.getTarget().equals(controlThree)) {
                if (e.getTarget().equals(controlThree)) {

                    changeClickColor();

                    if (!controlPane3.getChildren().contains(numberControlCircle)) {
                        controlPane3.getChildren().remove(controlThree);
                        controlThree.setFill(Color.WHITE);
                        controlPane3.getChildren().addAll(numberControlCircle, controlThree);
                        animation.setRate(12);
                    }
                }
            }
            else if (e.getTarget().equals(controlFour)) {
                if (e.getTarget().equals(controlFour)) {

                    changeClickColor();

                    if (!controlPane4.getChildren().contains(numberControlCircle)) {
                        controlPane4.getChildren().remove(controlFour);
                        controlFour.setFill(Color.WHITE);
                        controlPane4.getChildren().addAll(numberControlCircle, controlFour);
                        animation.setRate(16);
                    }
                }
            }
            else if (e.getTarget().equals(controlFive)) {
                if (e.getTarget().equals(controlFive)) {

                    changeClickColor();

                    if (!controlPane5.getChildren().contains(numberControlCircle)) {
                        controlPane5.getChildren().remove(controlFive);
                        controlFive.setFill(Color.WHITE);
                        controlPane5.getChildren().addAll(numberControlCircle, controlFive);
                        animation.setRate(20);
                    }
                }
            }
            else {
                System.out.println("Invalid input");
            }
        });
    }

    private void changeClickColor() {
        for (int i = 0; i < arrStack.length; i++) {
            arrStack[i].getChildren().remove(numberControlCircle);
            arrNumberText[i].setFill(Color.BLACK);
        }
    }

    public Text getControlOne() {
        return controlOne;
    }

    public void setControlOne(Text controlOne) {
        this.controlOne = controlOne;
    }

    public Text getControlTwo() {
        return controlTwo;
    }

    public void setControlTwo(Text controlTwo) {
        this.controlTwo = controlTwo;
    }

    public Text getControlThree() {
        return controlThree;
    }

    public void setControlThree(Text controlThree) {
        this.controlThree = controlThree;
    }

    public Text getControlFour() {
        return controlFour;
    }

    public void setControlFour(Text controlFour) {
        this.controlFour = controlFour;
    }

    public Text getControlFive() {
        return controlFive;
    }

    public void setControlFive(Text controlFive) {
        this.controlFive = controlFive;
    }

    public Button getControlStart() {
        return controlStart;
    }

    public void setControlStart(Button controlStart) {
        this.controlStart = controlStart;
    }

    public Button getControlStop() {
        return controlStop;
    }

    public void setControlStop(Button controlStop) {
        this.controlStop = controlStop;
    }

    public Button getControlReverse() {
        return controlReverse;
    }

    public void setControlReverse(Button controlReverse) {
        this.controlReverse = controlReverse;
    }

    public void startFan() {
        animation.setRate(4);
        animation.play();
    }
    public void stopFan() {

        animation.stop();
//
//        Platform.runLater(() -> {
//            slowDownAnimation.play();
//        });
//
//        while (decrementAngle > 0.1) {
//
//        }
//
//        Platform.runLater(() -> {
//            slowDownAnimation.stop();
//            animation.stop();
//        });
//
//        decrementAngle = 1;
    }

    public void reverseFan() {

        double rate = animation.getRate();

        animation.stop();

        decrementAngle = -decrementAngle;

        animation.setRate(rate);
        animation.play();

    }
}
