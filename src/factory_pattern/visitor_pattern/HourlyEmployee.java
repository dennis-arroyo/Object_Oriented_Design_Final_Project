package factory_pattern.visitor_pattern;

import factory_pattern.visitor_pattern.Employee;

public class HourlyEmployee extends Employee implements EmployeeElement
{
    private double salary;
    private int hoursWorked;

    public HourlyEmployee(int firstName, int lastName, int id)
    {
        super(firstName, lastName, id);
    }

    public HourlyEmployee(int firstName, int lastName, int id, double salary, int hoursWorked)
    {
        super(firstName, lastName, id);
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

    public int getHoursWorked()
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
