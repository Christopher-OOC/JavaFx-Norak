package org.example.fx.demo3.fan;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class Fan extends Pane {

    private Circle fanWheel;
    private Arc firstFanBlade;
    private Arc secondFanBlade;
    private Arc thirdFanBlade;

    public Fan() {

        fanWheel = new Circle();

        fanWheel.centerXProperty().bind(this.widthProperty().divide(2));
        fanWheel.centerYProperty().bind(this.heightProperty().divide(2));
        fanWheel.radiusProperty().bind(this.widthProperty().divide(4));

        fanWheel.setFill(Color.WHITE);
        fanWheel.setStroke(Color.GOLD);
        fanWheel.setStrokeWidth(2);

        firstFanBlade = new Arc();

        firstFanBlade.centerXProperty().bind(fanWheel.centerXProperty());
        firstFanBlade.centerYProperty().bind(fanWheel.centerYProperty());
        firstFanBlade.radiusXProperty().bind(fanWheel.radiusProperty().subtract(10));
        firstFanBlade.radiusYProperty().bind(fanWheel.radiusProperty().subtract(10));
        firstFanBlade.setStartAngle(0.0);
        firstFanBlade.lengthProperty().bind(fanWheel.radiusProperty().multiply(Math.PI).divide(18));

        secondFanBlade = new Arc();

        secondFanBlade.centerXProperty().bind(fanWheel.centerXProperty());
        secondFanBlade.centerYProperty().bind(fanWheel.centerYProperty());
        secondFanBlade.radiusXProperty().bind(fanWheel.radiusProperty().subtract(10));
        secondFanBlade.radiusYProperty().bind(fanWheel.radiusProperty().subtract(10));
        secondFanBlade.setStartAngle(120.0);
        secondFanBlade.lengthProperty().bind(fanWheel.radiusProperty().multiply(Math.PI).divide(18));


        thirdFanBlade = new Arc();

        thirdFanBlade.centerXProperty().bind(fanWheel.centerXProperty());
        thirdFanBlade.centerYProperty().bind(fanWheel.centerYProperty());
        thirdFanBlade.radiusXProperty().bind(fanWheel.radiusProperty().subtract(10));
        thirdFanBlade.radiusYProperty().bind(fanWheel.radiusProperty().subtract(10));
        thirdFanBlade.setStartAngle(240.0);
        thirdFanBlade.lengthProperty().bind(fanWheel.radiusProperty().multiply(Math.PI).divide(18));


        firstFanBlade.setFill(Color.BLACK);
        firstFanBlade.setStroke(Color.GOLD);
        firstFanBlade.setType(ArcType.ROUND);
        secondFanBlade.setFill(Color.BLACK);
        secondFanBlade.setStroke(Color.GOLD);
        secondFanBlade.setType(ArcType.ROUND);
        thirdFanBlade.setFill(Color.BLACK);
        thirdFanBlade.setStroke(Color.GOLD);
        thirdFanBlade.setType(ArcType.ROUND);

        this.getChildren().addAll(fanWheel, firstFanBlade, secondFanBlade, thirdFanBlade);
    }

    public Circle getFanWheel() {
        return fanWheel;
    }

    public void setFanWheel(Circle fanWheel) {
        this.fanWheel = fanWheel;
    }

    public Arc getFirstFanBlade() {
        return firstFanBlade;
    }

    public void setFirstFanBlade(Arc firstFanBlade) {
        this.firstFanBlade = firstFanBlade;
    }

    public Arc getSecondFanBlade() {
        return secondFanBlade;
    }

    public void setSecondFanBlade(Arc secondFanBlade) {
        this.secondFanBlade = secondFanBlade;
    }

    public Arc getThirdFanBlade() {
        return thirdFanBlade;
    }

    public void setThirdFanBlade(Arc thirdFanBlade) {
        this.thirdFanBlade = thirdFanBlade;
    }
}
