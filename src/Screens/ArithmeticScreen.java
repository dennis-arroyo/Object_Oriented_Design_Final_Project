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
    private static final String FIBONACCI = "Fibonacci";
    private static final String FACTORIAL = "Factorial";
    private static final String SQUARE = "Square";
    private static final String SQUARE_ROOT = "Square Root";

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

        double stageWidth = Home.getStage().getWidth();
        double stageHeight = Home.getStage().getHeight();

        textField = new TextField();
        textField.setPrefWidth(stageWidth/4);
        textField.setMaxWidth(stageWidth/4);
        textField.setPromptText("Ex: 7");
        textField.setFocusTraversable(false);
        textField.setText("");
        textField.textProperty().addListener((Observable) -> {
            performChainEvent();
        });

        fibonacciButton = new CheckBox(FIBONACCI);
        fibonacciButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        factorialButton = new CheckBox(FACTORIAL);
        factorialButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        squareButton = new CheckBox(SQUARE);
        squareButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        squareRootButton = new CheckBox(SQUARE_ROOT);
        squareRootButton.setOnAction(actionEvent -> {
            performChainEvent();
        });

        textArea = new TextArea();
        textArea.setPrefWidth(stageWidth/2);
        textArea.setMaxWidth(stageWidth/2);
        textArea.setPrefHeight(stageHeight/2);
        textArea.setMaxHeight(stageHeight/2);

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        HBox labelLayout = new HBox(label);
        labelLayout.setAlignment(Pos.CENTER);

        HBox buttonsLayout = new HBox(20, fibonacciButton, factorialButton,  squareButton, squareRootButton);
        buttonsLayout.setAlignment(Pos.CENTER);

        String style = HomeScreen.class.getResource("../css_styles/buttonStyle.css").toExternalForm();
        Button returnButton = new Button("HOME");
        returnButton.setId("homeButton");
        returnButton.setOnAction(actionEvent -> {
            HomeScreen.setStageScene();
        });

        root.getChildren().addAll(labelLayout, textField, buttonsLayout, textArea, returnButton);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(style);

        Home.getStage().setScene(scene);
    }

    private static void performChainEvent()
    {
        textArea.clear();
        String inputText = textField.getText();
        boolean isThereUserInput = validateTextFieldContent(inputText);
        int number = 0;
        if (isThereUserInput)
            number = Integer.parseInt(inputText);
        String[] results = new String[]{"", "", "", ""};

        if (fibonacciButton.isSelected() && isThereUserInput)
            results[0] = FIBONACCI + ": " + handler1.calculate(number, fibonacciButton.getText()) + "\n\n";
        if (factorialButton.isSelected() && isThereUserInput)
            results[1] = FACTORIAL + ": " + handler1.calculate(number, factorialButton.getText()) + "\n\n";
        if (squareButton.isSelected() && isThereUserInput)
            results[2] = SQUARE + ": " + handler1.calculate(number, squareButton.getText()) + "\n\n";
        if (squareRootButton.isSelected() && isThereUserInput)
            results[3] = SQUARE_ROOT + ": " + handler1.calculate(number, squareRootButton.getText());

        for (String elem : results)
            textArea.appendText(elem);
    }

    private static boolean validateTextFieldContent(String inputText)
    {
        if (inputText != null && !inputText.isEmpty() && inputText.matches("^\\d+$"))
            return true;
        else
            return false;
    }
}
