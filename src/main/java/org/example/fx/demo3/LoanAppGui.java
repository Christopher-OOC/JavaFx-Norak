package org.example.fx.demo3;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoanAppGui extends Application {

    private int count = 0;

    @Override
    public void start(Stage primaryStage)  {

        Text company = new Text("Chris Loan Services");

        StackPane circlePane = new StackPane();

        Text circleText = new Text("This is a Circle");

        Circle circle = new Circle(0, 0, 50);
        circle.setFill(Color.GOLD);
        circle.setStroke(Color.BLACK);

        circlePane.getChildren().addAll(circle, circleText);

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(10),
                e -> {

            count += 2;
            circlePane.setRotate(count);

                }));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        company.setFill(Color.BLUE);
        company.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));


        Label amountLb = new Label("Amount");
        TextField amountTf = new TextField();

        Label yearsLb = new Label("Years");
        TextField yearsTf = new TextField();

        Label rateLb = new Label("Interest rate");
        TextField rateTf = new TextField();
        rateTf.setEditable(false);
        rateTf.setText("5.0");

        Label monthlyPayLb = new Label("Monthly Payment");
        TextField monthlyPayTf = new TextField();
        monthlyPayTf.setEditable(false);

        Label totalPayLb = new Label("Total Payment");
        TextField totalPayTf = new TextField();
        totalPayTf.setEditable(false);

        Button calculateBtn = new Button("Calculate");

        Button clearBtn = new Button("Clear");

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20));


        pane.add(amountLb, 0, 0);
        pane.add(amountTf, 1, 0);

        pane.add(yearsLb, 0, 1);
        pane.add(yearsTf, 1, 1);

        pane.add(rateLb, 0, 2);
        pane.add(rateTf, 1, 2);

        pane.add(monthlyPayLb, 0, 3);
        pane.add(monthlyPayTf, 1, 3);

        pane.add(totalPayLb, 0, 4);
        pane.add(totalPayTf, 1, 4);

        pane.add(calculateBtn, 0, 5);
        pane.add(clearBtn, 1, 5);

        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);


        container.getChildren().add(company);
        container.getChildren().add(pane);

        // events
        calculateBtn.setOnAction(event -> {
            double amount = Double.parseDouble(amountTf.getText());
            int years = Integer.parseInt(yearsTf.getText());
            double rate = Double.parseDouble(rateTf.getText());

            double monthlyPayment;
            double totalPayment;

            totalPayment = amount +  (amount * rate * years) / 100;
            monthlyPayment = totalPayment / (12 * years);

            monthlyPayTf.setText(String.format("%.2f", monthlyPayment));
            totalPayTf.setText(String.format("%.2f", totalPayment));
        });

        clearBtn.setOnAction(e -> {
            amountTf.setText("");
            yearsTf.setText("");
            monthlyPayTf.setText("");
            totalPayTf.setText("");
        });

        container.getChildren().add(circlePane);

        Scene scene = new Scene(container, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Loan App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
