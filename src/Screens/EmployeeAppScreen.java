package Screens;

import factory_pattern.ComponentFactory;
import factory_pattern.visitor_pattern.Employee;
import factory_pattern.visitor_pattern.EmployeeCollection;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EmployeeAppScreen
{
    private static final String HOURLY = "Hourly";
    private static final String SALES = "Sales";
    private static TableView<EmployeeCollection> tableView;
    private static ArrayList<Employee> employeeArray = new ArrayList<>();
    private static GridPane informationToAddLayout;
    private static double stageWidth;
    private static double stageHeight;
    private static Label salaryOrSalesLabel;
    private static Label hoursOrCommissionLabel;
    private static Button addButton;

    private static TextField firstNameInput;
    private static TextField lastName;
    private static TextField salaryOrSalesInput;
    private static TextField hoursOrCommissionInput;
    private static ChoiceBox<String> empTypeChoiceBox;

    public static void setTableView(TableView<EmployeeCollection> tableView)
    {
        EmployeeAppScreen.tableView = tableView;
    }

    public static TableView<EmployeeCollection> getTableView()
    {
        return tableView;
    }

    public static void setAddButton(Button addButton)
    {
        EmployeeAppScreen.addButton = addButton;
    }

    public static ArrayList<Employee> getEmployeeArray()
    {
        return employeeArray;
    }

    public static void setEmployeeArray(ArrayList<Employee> employeeArray)
    {
        EmployeeAppScreen.employeeArray = employeeArray;
    }

    public static TextField getFirstNameInput()
    {
        return firstNameInput;
    }

    public static void setFirstNameInput(TextField firstNameInput)
    {
        EmployeeAppScreen.firstNameInput = firstNameInput;
    }

    public static TextField getLastName()
    {
        return lastName;
    }

    public static void setLastName(TextField lastName)
    {
        EmployeeAppScreen.lastName = lastName;
    }

    public static TextField getSalaryOrSalesInput()
    {
        return salaryOrSalesInput;
    }

    public static void setSalaryOrSalesInput(TextField salaryOrSalesInput)
    {
        EmployeeAppScreen.salaryOrSalesInput = salaryOrSalesInput;
    }

    public static TextField getHoursOrCommissionInput() {
        return hoursOrCommissionInput;
    }

    public static void setHoursOrCommissionInput(TextField hoursOrCommissionInput)
    {
        EmployeeAppScreen.hoursOrCommissionInput = hoursOrCommissionInput;
    }

    public static ChoiceBox<String> getEmpTypeChoiceBox()
    {
        return empTypeChoiceBox;
    }

    public static void setEmpTypeChoiceBox(ChoiceBox<String> empTypeChoiceBox)
    {
        EmployeeAppScreen.empTypeChoiceBox = empTypeChoiceBox;
    }

    public static void setStageScene()
    {
        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        stageWidth = Home.getStage().getWidth();
        stageHeight = Home.getStage().getHeight();

        ComponentFactory tableViewComponent = new ComponentFactory();
        tableViewComponent.getComponent("table");

        tableView.setPrefWidth(stageWidth - stageWidth/4);
        tableView.setMaxWidth(stageWidth - stageWidth/4);

        HBox tableLayout = new HBox(tableView);
        tableLayout.setAlignment(Pos.CENTER);

        informationToAddLayout = new GridPane();

        Label empFirstName = new Label("First Name: ");

        firstNameInput = new TextField();
        firstNameInput.setPromptText("Ex: Jane");
        commonTextFieldProperties(firstNameInput);

        Label empLastName = new Label("Last Name: ");

        lastName = new TextField();
        lastName.setPromptText("Ex: Doe");
        commonTextFieldProperties(lastName);

        Label empType = new Label("Type: ");

        empTypeChoiceBox = new ChoiceBox<String>();
        empTypeChoiceBox.setValue(HOURLY);
        empTypeChoiceBox.getItems().add(HOURLY);
        empTypeChoiceBox.getItems().add(SALES);
        addEmployeeInputFieldComponents(empTypeChoiceBox.getValue(), false);
        empTypeChoiceBox.getSelectionModel().selectFirst();
        empTypeChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            addEmployeeInputFieldComponents(newValue, true);
        });

        informationToAddLayout.add(empFirstName, 0, 0, 1, 1);
        informationToAddLayout.add(empLastName, 1, 0, 1, 1);
        informationToAddLayout.add(empType, 2, 0, 1, 1);
        informationToAddLayout.add(firstNameInput, 0, 1, 1, 1);
        informationToAddLayout.add(lastName, 1, 1, 1, 1);
        informationToAddLayout.add(empTypeChoiceBox, 2, 1, 1, 1);

        ComponentFactory addButtonComponent = new ComponentFactory();
        addButtonComponent.getComponent("add button");

        informationToAddLayout.add(addButton, 5, 1, 1, 1);

        informationToAddLayout.setAlignment(Pos.CENTER);
        informationToAddLayout.setHgap(10);
        informationToAddLayout.setVgap(10);

        Label fillLabel = new Label("* Fill all fields *");

        String style = HomeScreen.class.getResource("../css_styles/buttonStyle.css").toExternalForm();
        Button returnButton = new Button("HOME");
        returnButton.setId("homeButton");
        returnButton.setOnAction(actionEvent -> {
            HomeScreen.setStageScene();
        });

        root.getChildren().addAll(tableLayout, informationToAddLayout, fillLabel, returnButton);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(style);
        Home.getStage().setScene(scene);
    }

    private static void addEmployeeInputFieldComponents(String typeOfEmp, boolean chageEvent)
    {
        if (chageEvent)
        {
            informationToAddLayout.getChildren().remove(salaryOrSalesLabel);
            informationToAddLayout.getChildren().remove(salaryOrSalesInput);
            informationToAddLayout.getChildren().remove(hoursOrCommissionLabel);
            informationToAddLayout.getChildren().remove(hoursOrCommissionInput);
        }

        if (typeOfEmp.equals(HOURLY))
        {
            additionalComponents("Salary:", "Hours Worked:", HOURLY);
        }
        else
        {
            additionalComponents("Total Sales:", "Commission Rate (Decimal Format):", SALES);
        }
    }

    private static void additionalComponents(String str1, String str2, String type) {
        salaryOrSalesLabel = new Label(str1);

        salaryOrSalesInput = new TextField();
        salaryOrSalesInput.setPromptText(type.equals(HOURLY) ? "Ex: 7.25" : "Ex: 2550");
        commonTextFieldProperties(salaryOrSalesInput);

        hoursOrCommissionLabel = new Label(str2);

        hoursOrCommissionInput = new TextField();
        hoursOrCommissionInput.setPromptText(type.equals(HOURLY) ? "Ex: 40" : "Ex: 0.25");
        commonTextFieldProperties(hoursOrCommissionInput);

        informationToAddLayout.add(salaryOrSalesLabel, 3, 0, 1, 1);
        informationToAddLayout.add(hoursOrCommissionLabel, 4, 0, 1, 1);
        informationToAddLayout.add(salaryOrSalesInput, 3, 1, 1, 1);
        informationToAddLayout.add(hoursOrCommissionInput, 4, 1, 1, 1);
    }

    private static void commonTextFieldProperties(TextField textField)
    {
        textField.setFocusTraversable(false);
        textField.setPrefWidth(stageWidth/4);
        textField.setMaxWidth(stageHeight/6);
    }
}
