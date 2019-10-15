package chain_of_responsability;

public class Fibonacci implements ArithmeticChain
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
        if (req.getArithmeticToPerform().equals("fibonacci"))
            System.out.println("The position " + num + " in the fibonacci sequence is: "
                    + calculateFibonacci(num));
        else
            nextInChain.calculate(req);
    }

    private int calculateFibonacci(int number)
    {
        if (number == 0 || number == 1)
            return 0;
        else
        {
            int pos1 = 0;
            int pos2 = 1;
            int sumOfPos = 0;

            for (int i = 1; i < number; i++)
            {
                sumOfPos = pos1 + pos2;
                pos1 = pos2;
                pos2 = sumOfPos;
            }

            return sumOfPos;
        }
    }
}
