package factory_pattern;

import Screens.EmployeeAppScreen;
import factory_pattern.visitor_pattern.*;
import javafx.scene.control.Button;

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
        String lastName = EmployeeAppScreen.getLastName().getText();
        double salaryOrSales = 0.0;
        boolean validNumberInput = validateNumbersInput(EmployeeAppScreen.getSalaryOrSalesInput().getText());
        if (validNumberInput)
            salaryOrSales = Double.parseDouble(EmployeeAppScreen.getSalaryOrSalesInput().getText());
        double hoursOrCommission = 0.0;
        boolean validNumberInput2 = validateNumbersInput(EmployeeAppScreen.getHoursOrCommissionInput().getText());
        if (validNumberInput2)
            hoursOrCommission = Double.parseDouble(EmployeeAppScreen.getHoursOrCommissionInput().getText());

        if (validateNameInput(firstName, lastName) && validNumberInput && validNumberInput2) {


            if (empType.equals(HOURLY)) {
                HourlyEmployee emp = new HourlyEmployee(firstName, lastName, salaryOrSales, hoursOrCommission);
                EmployeeVisitor employeeVisitor = new EmployeeVisitorImpl();

                double profit = emp.accept(employeeVisitor);

                EmployeeAppScreen.getTableView().getItems().add(new EmployeeCollection(emp.getFirstName(),
                        emp.getLastName(), emp.getTypeOfEmployee(), emp.getSalary(), emp.getHoursWorked(), profit));
            } else {
                SalesEmployee emp = new SalesEmployee(firstName, lastName, salaryOrSales, hoursOrCommission);
                EmployeeVisitor employeeVisitor = new EmployeeVisitorImpl();

                double profit = emp.accept(employeeVisitor);

                EmployeeAppScreen.getTableView().getItems().add(new EmployeeCollection(emp.getFirstName(),
                        emp.getLastName(), emp.getTypeOfEmployee(), emp.getTotalSales(), emp.getCommissionPercentage(), profit));
            }
        }

    }

    private static boolean validateNameInput(String first, String second)
    {
        return first != null && !first.isEmpty() && second != null && !second.isEmpty();
    }

    private static boolean validateNumbersInput(String number)
    {
        return number != null && !number.isEmpty() && number.matches("-?\\d+(\\.\\d+)?");
    }
}
