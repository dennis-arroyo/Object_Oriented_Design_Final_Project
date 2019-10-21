package factory_pattern;

import Screens.EmployeeAppScreen;
import factory_pattern.visitor_pattern.Employee;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EmployeeTable implements SceneComponent
{
    @Override
    public void drawComponent()
    {
        TableView<Employee> table = new TableView<>();
        TableColumn firstNameColumn = new TableColumn("First Name");
        TableColumn lastNameColumn = new TableColumn("Last Name");
        TableColumn idColumn = new TableColumn("Id");
        TableColumn typeColumn = new TableColumn("Type");

        table.getColumns().addAll(firstNameColumn, lastNameColumn, idColumn, typeColumn);

        EmployeeAppScreen.setTableView(table);
    }
}
