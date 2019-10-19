/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Concrete Handler class
 * Calculates the factorial value of the specified number
 */

package chain_of_responsability;

import java.math.BigInteger;

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
            return calculateFactorial(number);
        else
            return nextInChain.calculate(number, arithmeticToPerform);
    }

    private String calculateFactorial(int number)
    {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= number; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
        }
        return String.format("%,d", fact);
    }
}
