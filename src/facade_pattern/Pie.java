package facade_pattern;

import Screens.GraphScreen;
import javafx.scene.chart.PieChart;

public class Pie implements Graph
{
    @Override
    public void drawGraph()
    {
        PieChart pieChart = new PieChart();

        PieChart.Data firstNumber = new PieChart.Data("Number #1",
                Integer.parseInt(GraphScreen.getTextField1().getText()));
        PieChart.Data secondNumber = new PieChart.Data("Number #2",
                Integer.parseInt(GraphScreen.getTextField2().getText()));
        PieChart.Data thirdNumber = new PieChart.Data("Number #3",
                Integer.parseInt(GraphScreen.getTextField3().getText()));

        pieChart.getData().add(firstNumber);
        pieChart.getData().add(secondNumber);
        pieChart.getData().add(thirdNumber);

        GraphScreen.setPieChart(pieChart);
    }
}
