package facade_pattern;

import Screens.GraphScreen;
import facade_pattern.observer_pattern.GraphUpdate;
import javafx.scene.chart.PieChart;

public class Pie implements Graph
{
    private PieChart pieChart;
    private PieChart.Data firstNumber;
    private PieChart.Data secondNumber;
    private PieChart.Data thirdNumber;

    @Override
    public void drawGraph()
    {
        pieChart = new PieChart();

        firstNumber = new PieChart.Data("Number #1",
                Integer.parseInt(GraphScreen.getTextField1().getText()));
        secondNumber = new PieChart.Data("Number #2",
                Integer.parseInt(GraphScreen.getTextField2().getText()));
        thirdNumber = new PieChart.Data("Number #3",
                Integer.parseInt(GraphScreen.getTextField3().getText()));

        pieChart.getData().add(firstNumber);
        pieChart.getData().add(secondNumber);
        pieChart.getData().add(thirdNumber);

        GraphScreen.setPieChart(pieChart);
    }
}
