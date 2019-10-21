package Screens;

import factory_pattern.ComponentFactory;
import factory_pattern.visitor_pattern.Employee;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class EmployeeAppScreen
{
    private static TableView<Employee> tableView;

    public static void setTableView(TableView<Employee> tableView)
    {
        EmployeeAppScreen.tableView = tableView;
    }

    public static TableView<Employee> getTableView()
    {
        return tableView;
    }

    public static void setStageScene()
    {
        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        double stageWidth = Home.getStage().getWidth();
        double stageHeight = Home.getStage().getHeight();

        ComponentFactory tableViewComponent = new ComponentFactory();
        tableViewComponent.getComponent("table");

        tableView.setPrefWidth(stageWidth - stageWidth/2);
        tableView.setMaxWidth(stageWidth - stageWidth/2);
        VBox tableLayout = new VBox(tableView);
        tableLayout.setAlignment(Pos.CENTER);

        root.getChildren().addAll(tableLayout);

        Scene scene = new Scene(root);
        Home.getStage().setScene(scene);
    }
}
