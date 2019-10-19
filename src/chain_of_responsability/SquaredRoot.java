/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Concrete Handler class
 * Calculates the square root of the specified number
 */

package chain_of_responsability;

public class SquaredRoot implements ArithmeticChain
{
    @Override
    public void setNextChain(ArithmeticChain nextChain) {}

    @Override
    public String calculate(int number, String arithmeticToPerform)
    {
        if (arithmeticToPerform.equals("Square Root"))
            return String.format("%.2f", calculateSquaredRoot(number));
        else
            return "The arithmetic chain only accepts Fibonacci, Factorial, Square, or Square Root operations";
    }

    private double calculateSquaredRoot(int num)
    {
        return Math.sqrt(num);
    }
}
