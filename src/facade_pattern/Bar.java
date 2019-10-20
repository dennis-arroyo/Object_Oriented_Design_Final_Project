package facade_pattern;

import Screens.GraphScreen;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Bar implements Graph
{
    @Override
    public void drawGraph()
    {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Numbers");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("");

        // Create a BarChart
        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

        // Series 1 - Data of 2014
        XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();

        data.getData().add(new XYChart.Data<>("Number #1",
                Integer.parseInt(GraphScreen.getTextField1().getText())));
        data.getData().add(new XYChart.Data<>("Number #2",
                Integer.parseInt(GraphScreen.getTextField2().getText())));
        data.getData().add(new XYChart.Data<>("Number #3",
                Integer.parseInt(GraphScreen.getTextField3().getText())));

        barChart.getData().add(data);

        GraphScreen.setBarChart(barChart);

    }
}
