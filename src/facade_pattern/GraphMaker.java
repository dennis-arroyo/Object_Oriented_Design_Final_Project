package facade_pattern;

import Screens.GraphScreen;
import facade_pattern.observer_pattern.GraphUpdate;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

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
        oldBar.getData().clear();
    }

    @Override
    public void addNewData(PieChart oldPie, BarChart oldBar)
    {
        Pie.getDataSeries(oldPie);
        Bar.getDataSeries(oldBar);
    }
}
