package facade_pattern;

import Screens.GraphScreen;
import facade_pattern.observer_pattern.GraphUpdate;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

public class GraphMaker implements GraphUpdate
{
    private Graph bar;
    private Graph pie;

    public GraphMaker()
    {
        pie = new Pie();
        bar = new Bar();
    }

    public void drawPieChart()
    {
        pie.drawGraph();
    }

    public void drawBarChart()
    {
        bar.drawGraph();
    }

    @Override
    public void removeOldData(PieChart oldPie, BarChart oldBar)
    {
        oldPie.getData().clear();
    }

    @Override
    public void addNewData(PieChart oldPie, BarChart oldBar)
    {
        PieChart.Data firstNumber = new PieChart.Data("Number #1",
                Integer.parseInt(GraphScreen.getTextField1().getText()));
        PieChart.Data secondNumber = new PieChart.Data("Number #2",
                Integer.parseInt(GraphScreen.getTextField2().getText()));
        PieChart.Data thirdNumber = new PieChart.Data("Number #3",
                Integer.parseInt(GraphScreen.getTextField3().getText()));

        oldPie.getData().add(firstNumber);
        oldPie.getData().add(secondNumber);
        oldPie.getData().add(thirdNumber);
    }
}
