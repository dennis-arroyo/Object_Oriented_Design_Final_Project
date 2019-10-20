package facade_pattern;

import Screens.GraphScreen;
import facade_pattern.observer_pattern.GraphUpdate;
import javafx.scene.chart.PieChart;

public class Pie implements Graph
{
    private PieChart pieChart;

    @Override
    public void drawGraph()
    {
        pieChart = new PieChart();

        getDataSeries(pieChart);

        GraphScreen.setPieChart(pieChart);
    }

    static void getDataSeries(PieChart pieChart) {
        PieChart.Data firstNumber = new PieChart.Data("Number #1",
                Integer.parseInt(GraphScreen.getTextField1().getText()));
        PieChart.Data secondNumber = new PieChart.Data("Number #2",
                Integer.parseInt(GraphScreen.getTextField2().getText()));
        PieChart.Data thirdNumber = new PieChart.Data("Number #3",
                Integer.parseInt(GraphScreen.getTextField3().getText()));

        pieChart.getData().add(firstNumber);
        pieChart.getData().add(secondNumber);
        pieChart.getData().add(thirdNumber);
    }
}
