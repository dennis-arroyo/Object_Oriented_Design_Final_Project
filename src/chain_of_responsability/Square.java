/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Concrete Handler class
 * Calculates the square of the specified number
 */

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
    public String calculate(int number, String arithmeticToPerform)
    {
        if (arithmeticToPerform.equals("Square"))
            return Integer.toString(calculateSquared(number));
        else
            return nextInChain.calculate(number, arithmeticToPerform);
    }

    private int calculateSquared(int num)
    {
        return (int) Math.pow(num, 2);
    }
}
