/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Concrete Handler class
 * Calculates the square root of the specified number
 */

package model_view_controller.model.chain_of_responsability;

public class SquaredRoot implements ArithmeticChain
{
    @Override
    public void setNextChain(ArithmeticChain nextChain) {}

    @Override
    public void calculate(Requirements req)
    {
        int num = req.getNumber();
        if (req.getArithmeticToPerform().equals("squared root"))
            System.out.println("The square root of " + num + " is: "
                    + calculateSquaredRoot(num));
        else
            System.out.println("The arithmetic chain only accepts Fibonacci, Factorial, " +
                    "Square, or Squared Root " +
                    "operations");;
    }

    private double calculateSquaredRoot(int num)
    {
        return Math.sqrt(num);
    }
}
