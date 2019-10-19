/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Concrete Handler class
 * Calculates the value of the Fibonacci sequence specified
 */

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
    public String calculate(int number, String arithmeticToPerform)
    {
        if (arithmeticToPerform.equals("Fibonacci"))
            return String.format("%,d", calculateFibonacci(number));
        else
            return nextInChain.calculate(number, arithmeticToPerform);
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
