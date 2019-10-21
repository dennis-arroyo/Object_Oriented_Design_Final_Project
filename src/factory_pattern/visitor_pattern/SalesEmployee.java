package factory_pattern.visitor_pattern;

public class SalesEmployee extends Employee implements EmployeeElement
{
    private double totalSales;
    private double commissionPercentage;


    public SalesEmployee(String firstName, String lastName)
    {
        super(firstName, lastName);
    }

    public SalesEmployee(String firstName, String lastName, double totalSales, double commissionPercentage)
    {
        super(firstName, lastName);
        this.totalSales = totalSales;
        this.commissionPercentage = commissionPercentage;
    }

    public double getTotalSales()
    {
        return totalSales;
    }

    public void setTotalSales(double totalSales)
    {
        this.totalSales = totalSales;
    }

    public double getCommissionPercentage()
    {
        return commissionPercentage;
    }

    public void setCommissionPercentage(double commissionPercentage)
    {
        this.commissionPercentage = commissionPercentage;
    }

    public String getTypeOfEmployee()
    {
        return "Sales";
    }

    @Override
    public double accept(EmployeeVisitor visitor)
    {
        return visitor.visit(this);
    }
}
