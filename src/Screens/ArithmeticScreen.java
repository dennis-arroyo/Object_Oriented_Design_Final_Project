package Screens;

import chain_of_responsability.*;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

import javax.swing.*;

public class ArithmeticScreen
{
    private static ArithmeticChain handler1 = new Fibonacci();
    private static ArithmeticChain handler2 = new Factorial();
    private static ArithmeticChain handler3 = new Square();
    private static ArithmeticChain handler4 = new SquaredRoot();

    public static void setStageScene()
    {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Label label = new Label();
        label.setText("Enter an integer and choose programs to run...");

        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        TextField textField = new TextField();
        textField.setPrefWidth(screenWidth/8);
        textField.setMaxWidth(screenWidth/8);
        textField.setPromptText("Ex: 7");
        textField.setFocusTraversable(false);

        CheckBox fibonacciButton = new CheckBox("Fibonacci");
        fibonacciButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        CheckBox factorialButton = new CheckBox("Factorial");

        CheckBox squareButton = new CheckBox("Square");

        CheckBox squareRootButton = new CheckBox("Square Root");

        TextArea textArea = new TextArea();
        textArea.setPrefWidth(screenWidth/8);
        textArea.setPrefHeight(screenHeight/4);

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        HBox labelLayout = new HBox(label);
        labelLayout.setAlignment(Pos.CENTER);

        HBox buttonsLayout = new HBox(20, fibonacciButton, factorialButton,  squareButton, squareRootButton);
        buttonsLayout.setAlignment(Pos.CENTER);

        Button returnButton = new Button("Screens.Home Screen");
        returnButton.setOnAction(actionEvent -> {
            HomeScreen.setStageScene();
        });

        root.getChildren().addAll(labelLayout, textField, buttonsLayout, textArea, returnButton);

        Home.getStage().setScene(new Scene(root));
    }

    private static void performChainEvent()
    {
        handler1.setNextChain(handler2);
        handler2.setNextChain(handler3);
        handler3.setNextChain(handler4);

    }
}
