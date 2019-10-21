package factory_pattern.visitor_pattern;

import factory_pattern.visitor_pattern.Employee;

public class HourlyEmployee extends Employee implements EmployeeElement
{
    private double salary;
    private double hoursWorked;

    public HourlyEmployee(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

    public HourlyEmployee(String firstName, String lastName, double salary, double hoursWorked)
    {
        super(firstName, lastName);
        this.salary = salary;
        this.hoursWorked = hoursWorked;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public String getTypeOfEmployee()
    {
        return "Hourly";
    }
    @Override
    public double accept(EmployeeVisitor visitor) {
        return visitor.visit(this);
    }
}
