package chain_of_responsability;

public class Square implements ArithmeticChain
{
    private ArithmeticChain nextInChain;

    @Override
    public void setNextChain(ArithmeticChain nextChain)
    {
        this.nextInChain = nextChain;
    }

    @Override
    public void calculate(Requirements req)
    {
        int num = req.getNumber();
        if (req.getArithmeticToPerform().equals("square"))
            System.out.println("The square of " + num + " is: " + calculateSquared(num));
        else
            nextInChain.calculate(req);
    }

    private int calculateSquared(int num)
    {
        return (int) Math.pow(num, 2);
    }
}
