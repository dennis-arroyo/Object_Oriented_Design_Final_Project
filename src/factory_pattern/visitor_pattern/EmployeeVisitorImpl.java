package factory_pattern.visitor_pattern;

public class EmployeeVisitorImpl implements EmployeeVisitor
{

    @Override
    public double visit(HourlyEmployee hourlyEmployee)
    {
        double hours = hourlyEmployee.getHoursWorked();
        double salary = hourlyEmployee.getSalary();

        if (hours <= 40)
            return salary * hours;
        else
            return salary * 40 * (salary*1.5) * (hours - 40);
    }

    @Override
    public double visit(SalesEmployee salesEmployee)
    {
        double sales = salesEmployee.getTotalSales();
        double commission = salesEmployee.getCommissionPercentage();
        return sales * commission;
    }
}
