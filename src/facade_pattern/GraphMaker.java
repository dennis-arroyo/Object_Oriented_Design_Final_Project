package facade_pattern;

public class GraphMaker
{
    private Graph bar;
    private Graph pie;

    public GraphMaker()
    {
        pie = new Pie();
    }

    public void drawPieChart()
    {
        pie.drawGraph();
    }
}
