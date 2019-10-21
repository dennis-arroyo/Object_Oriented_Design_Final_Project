package factory_pattern;

import Screens.EmployeeAppScreen;
import factory_pattern.visitor_pattern.Employee;
import factory_pattern.visitor_pattern.EmployeeCollection;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeTable implements SceneComponent
{
    @Override
    public void drawComponent()
    {
        TableView<EmployeeCollection> table = new TableView<>();
        TableColumn<EmployeeCollection, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setPrefWidth(100);

        TableColumn<EmployeeCollection, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setPrefWidth(100);

        TableColumn<EmployeeCollection, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        typeColumn.setPrefWidth(100);

        TableColumn<EmployeeCollection, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionColumn.setPrefWidth(300);

        table.getColumns().addAll(firstNameColumn, lastNameColumn, typeColumn, descriptionColumn);

        EmployeeAppScreen.setTableView(table);
    }
}
