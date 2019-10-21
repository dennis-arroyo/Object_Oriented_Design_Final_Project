package factory_pattern.visitor_pattern;

public interface EmployeeVisitor
{
    double visit(HourlyEmployee hourlyEmployee);
    double visit(SalesEmployee salesEmployee);
}
