package facade_pattern.observer_pattern;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;

public interface GraphUpdate
{
    void removeOldData(PieChart pie, BarChart bar);
    void addNewData(PieChart pie, BarChart bar);
}
