/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Concrete Handler class
 * Calculates the factorial value of the specified number
 */

package chain_of_responsability;

public class Factorial implements ArithmeticChain
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
        if (arithmeticToPerform.equals("Factorial"))
            return Integer.toString(calculateFactorial(number));
        else
            return nextInChain.calculate(number, arithmeticToPerform);
    }

    private int calculateFactorial(int number)
    {
        if (number == 0 || number == 1)
            return 1;
        else
        {
            int pos = 1;

            for (int i = 1; i <= number; i++)
                pos *= i;

            return pos;
        }
    }
}
