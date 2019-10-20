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
        getDataSeries(barChart);

        GraphScreen.setBarChart(barChart);

    }

    static void getDataSeries(BarChart<String, Number> barChart) {
        XYChart.Series<String, Number> data1 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> data2 = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> data3 = new XYChart.Series<String, Number>();

        data1.getData().add(new XYChart.Data<>("Number #1",
                Integer.parseInt(GraphScreen.getTextField1().getText())));
        data2.getData().add(new XYChart.Data<>("Number #2",
                Integer.parseInt(GraphScreen.getTextField2().getText())));
        data3.getData().add(new XYChart.Data<>("Number #3",
                Integer.parseInt(GraphScreen.getTextField3().getText())));

        barChart.getData().add(data1);
        barChart.getData().add(data2);
        barChart.getData().add(data3);
    }
}
