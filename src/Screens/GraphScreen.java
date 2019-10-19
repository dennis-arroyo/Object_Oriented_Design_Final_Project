package Screens;

import facade_pattern.GraphMaker;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
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

    public static void setStageScene()
    {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        String instructions = "Some instructions...";
        Label instructionsLabel = new Label(instructions);

        HBox instructionLabelLayout = new HBox(instructionsLabel);

        double stageWidth = Home.getStage().getWidth();
        double stageHeight = Home.getStage().getHeight();

        textField1 = new TextField();
        textField1.setPrefWidth(stageWidth/4);
        textField1.setMaxWidth(stageHeight/6);
        textField1.setPromptText("Ex: 7");
        textField1.setFocusTraversable(false);
        textField1.setText("5");

        textField2 = new TextField();
        textField2.setPrefWidth(stageWidth/4);
        textField2.setMaxWidth(stageHeight/6);
        textField2.setPromptText("Ex: 7");
        textField2.setFocusTraversable(false);
        textField2.setText("10");

        textField3 = new TextField();
        textField3.setPrefWidth(stageWidth/4);
        textField3.setMaxWidth(stageHeight/6);
        textField3.setPromptText("Ex: 7");
        textField3.setFocusTraversable(false);
        textField3.setText("12");

        HBox textFieldsLayout = new HBox(textField1, textField2, textField3);
        textFieldsLayout.setSpacing(5);
        textFieldsLayout.setAlignment(Pos.CENTER);

        GraphMaker graphs = new GraphMaker();
        graphs.drawPieChart();

        VBox chartLayout = new VBox(pieChart);

        root.getChildren().addAll(instructionLabelLayout, textFieldsLayout, chartLayout);

        Home.getStage().setScene(new Scene(root));
    }
}
