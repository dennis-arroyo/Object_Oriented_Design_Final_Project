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
    private static TextField textField;
    private static TextArea textArea;
    private static CheckBox fibonacciButton;
    private static CheckBox factorialButton;
    private static CheckBox squareButton;
    private static CheckBox squareRootButton;

    public static void setStageScene()
    {
        handler1.setNextChain(handler2);
        handler2.setNextChain(handler3);
        handler3.setNextChain(handler4);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        Label label = new Label();
        label.setText("Enter an integer and choose programs to run...");

        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();

        textField = new TextField();
        textField.setPrefWidth(screenWidth/8);
        textField.setMaxWidth(screenWidth/8);
        textField.setPromptText("Ex: 7");
        textField.setFocusTraversable(false);

        fibonacciButton = new CheckBox("Fibonacci");
        fibonacciButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        factorialButton = new CheckBox("Factorial");
        factorialButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        squareButton = new CheckBox("Square");
        squareButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        squareRootButton = new CheckBox("Square Root");
        squareRootButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        textArea = new TextArea();
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
        textArea.clear();
        int number = Integer.parseInt(textField.getText());
        String[] results = new String[]{"", "", "", ""};

        if (fibonacciButton.isSelected())
            results[0] = "Fibonacci: " + handler1.calculate(number, fibonacciButton.getText()) + "\n\n";
        if (factorialButton.isSelected())
            results[1] = "Factorial: " + handler1.calculate(number, factorialButton.getText()) + "\n\n";
        if (squareButton.isSelected())
            results[2] = "Square: " + handler1.calculate(number, squareButton.getText()) + "\n\n";
        if (squareRootButton.isSelected())
            results[3] = "Square Root: " + handler1.calculate(number, squareRootButton.getText());

        for (String elem : results)
            textArea.appendText(elem);
    }
}
