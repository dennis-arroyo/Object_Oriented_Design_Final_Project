package factory_pattern.visitor_pattern;

public interface EmployeeElement
{
    double accept(EmployeeVisitor visitor);
}
