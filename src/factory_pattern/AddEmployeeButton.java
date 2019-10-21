package factory_pattern;

import Screens.EmployeeAppScreen;
import factory_pattern.visitor_pattern.*;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AddEmployeeButton implements SceneComponent
{
    private static final String HOURLY  = "Hourly";
    private static final String SALES  = "Sales";
    @Override
    public void drawComponent()
    {
        Button btn = new Button("Add");
        btn.setOnAction(ActionEvent -> {
            addEmployeeData(EmployeeAppScreen.getEmpTypeChoiceBox().getValue());
        });
        EmployeeAppScreen.setAddButton(btn);
    }

    private static void addEmployeeData(String empType)
    {
        String firstName = EmployeeAppScreen.getFirstNameInput().getText();
        String secondName = EmployeeAppScreen.getSecondNameInput().getText();
        double salaryOrSales = Double.parseDouble(EmployeeAppScreen.getSalaryOrSalesInput().getText());
        double hoursOrCommission = Double.parseDouble(EmployeeAppScreen.getHoursOrCommissionInput().getText());

        if (empType.equals(HOURLY)) {
            HourlyEmployee emp = new HourlyEmployee(firstName, secondName, salaryOrSales, hoursOrCommission);
            EmployeeVisitor employeeVisitor = new EmployeeVisitorImpl();

            double profit = emp.accept(employeeVisitor);

            EmployeeAppScreen.getTableView().getItems().add(new EmployeeCollection(emp.getFirstName(),
                    emp.getLastName(), emp.getTypeOfEmployee(), emp.getSalary(), emp.getHoursWorked(), profit));
        }
        else
        {
            SalesEmployee emp = new SalesEmployee(firstName, secondName, salaryOrSales, hoursOrCommission);
            EmployeeVisitor employeeVisitor = new EmployeeVisitorImpl();

            double profit = emp.accept(employeeVisitor);

            EmployeeAppScreen.getTableView().getItems().add(new EmployeeCollection(emp.getFirstName(),
                    emp.getLastName(), emp.getTypeOfEmployee(), emp.getTotalSales(), emp.getCommissionPercentage(), profit));
        }

    }
}
