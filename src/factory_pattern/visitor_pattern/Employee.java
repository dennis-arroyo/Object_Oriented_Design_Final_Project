package factory_pattern.visitor_pattern;

public class Employee
{
    private int firstName;
    private int lastName;
    private int id;

    public Employee(int firstName, int lastName, int id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public int getFirstName()
    {
        return firstName;
    }

    public void setFirstName(int firstName)
    {
        this.firstName = firstName;
    }

    public int getLastName()
    {
        return lastName;
    }

    public void setLastName(int lastName)
    {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
