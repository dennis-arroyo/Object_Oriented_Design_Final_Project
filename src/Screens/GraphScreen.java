package Screens;

import facade_pattern.GraphMaker;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class GraphScreen
{
    private static TextField textField1;
    private static TextField textField2;
    private static TextField textField3;
    private static PieChart pieChart;
    private static BarChart barChart;
    private static GraphMaker graphs;
    private static HBox chartLayout;

    public static TextField getTextField1()
    {
        return textField1;
    }

    public static TextField getTextField2()
    {
        return textField2;
    }

    public static TextField getTextField3()
    {
        return textField3;
    }

    public static PieChart getPieChart()
    {
        return pieChart;
    }

    public static void setPieChart(PieChart pieChart)
    {
        GraphScreen.pieChart = pieChart;
    }

    public static BarChart getBarChart()
    {
        return barChart;
    }

    public static void setBarChart(BarChart barChart)
    {
        GraphScreen.barChart = barChart;
    }

    public static HBox getChartLayout()
    {
        return chartLayout;
    }

    public static void setStageScene()
    {
        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        String instructions = "Some instructions...";
        Label instructionsLabel = new Label(instructions);

        HBox instructionLabelLayout = new HBox(instructionsLabel);

        double stageWidth = Home.getStage().getWidth();
        double stageHeight = Home.getStage().getHeight();

        graphs = new GraphMaker();

        Label firstInputLabel = new Label("Number #1: ");

        textField1 = new TextField();
        textField1.setPrefWidth(stageWidth/4);
        textField1.setMaxWidth(stageHeight/6);
        textField1.setPromptText("Ex: 7");
        textField1.setFocusTraversable(false);
        textField1.setText("5");
        textField1.textProperty().addListener((Observable) -> {
            performGraphDrawing();
        });

        Label secondInputLabel = new Label("Number #2: ");

        textField2 = new TextField();
        textField2.setPrefWidth(stageWidth/4);
        textField2.setMaxWidth(stageHeight/6);
        textField2.setPromptText("Ex: 7");
        textField2.setFocusTraversable(false);
        textField2.setText("10");
        textField2.textProperty().addListener((Observable) -> {
            performGraphDrawing();
        });

        Label thirdInputLabel = new Label("Number #3: ");

        textField3 = new TextField();
        textField3.setPrefWidth(stageWidth/4);
        textField3.setMaxWidth(stageHeight/6);
        textField3.setPromptText("Ex: 7");
        textField3.setFocusTraversable(false);
        textField3.setText("12");
        textField3.textProperty().addListener((Observable) -> {
            performGraphDrawing();
        });

        HBox textFieldsLayout = new HBox(firstInputLabel, textField1,
                secondInputLabel, textField2, thirdInputLabel, textField3);
        textFieldsLayout.setSpacing(5);
        textFieldsLayout.setAlignment(Pos.CENTER);

        graphs.drawPieChart();
        graphs.drawBarChart();

        chartLayout = new HBox(pieChart, barChart);

        Button returnButton = new Button("HOME");
        returnButton.setId("homeButton");
        returnButton.setOnAction(actionEvent -> {
            Home.getScene().setRoot(Home.getRootFromHomeCopy());
        });

        root.getChildren().addAll(instructionLabelLayout, textFieldsLayout, chartLayout, returnButton);

        Home.getScene().setRoot(root);
    }

    private static void performGraphDrawing()
    {
        boolean input1 = validateTextFieldContent(textField1.getText());
        boolean input2 = validateTextFieldContent(textField2.getText());
        boolean input3 = validateTextFieldContent(textField3.getText());

        if (input1 && input2 && input3)
        {
            graphs.removeOldData(pieChart, barChart);
            graphs.addNewData(pieChart, barChart);
        }
    }

    private static boolean validateTextFieldContent(String inputText)
    {
        return inputText != null && !inputText.isEmpty() && inputText.matches("^\\d+$");
    }
}
