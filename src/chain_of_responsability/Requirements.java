package chain_of_responsability;

public class Requirements
{
    private int number;
    private String arithmeticToPerform;

    public Requirements(int number, String arithmeticToPerform)
    {
        this.number = number;
        this.arithmeticToPerform = arithmeticToPerform;
    }

    public int getNumber()
    {
        return number;
    }

    public String getArithmeticToPerform()
    {
        return arithmeticToPerform;
    }

    @Override
    public String toString()
    {
        return "Number: " + number +
                "\nArithmetic to Perform: " + arithmeticToPerform;
    }
}
