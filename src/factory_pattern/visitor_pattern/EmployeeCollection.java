package factory_pattern.visitor_pattern;

public class EmployeeCollection
{
    private String firstName;
    private String lastName;
    private String type;
    private double salOrSales;
    private double hoursOrCom;
    private double totalGain;

    public EmployeeCollection(String firstName, String lastName, String type,
                              double salOrSales, double hoursOrCom, double totalGain)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.salOrSales = salOrSales;
        this.hoursOrCom = hoursOrCom;
        this.totalGain = totalGain;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getSalOrSales()
    {
        return salOrSales;
    }

    public void setSalOrSales(double salOrSales)
    {
        this.salOrSales = salOrSales;
    }

    public double getHoursOrCom()
    {
        return hoursOrCom;
    }

    public void setHoursOrCom(double hoursOrCom)
    {
        this.hoursOrCom = hoursOrCom;
    }

    public double getTotalGain()
    {
        return totalGain;
    }

    public void setTotalGain(double totalGain)
    {
        this.totalGain = totalGain;
    }
}
