/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Handler Class for Chain of Responsibility Pattern
 */
package chain_of_responsability;

// Interface to be implemented in concrete handler classes
public interface ArithmeticChain
{
    void setNextChain(ArithmeticChain nextChain);
    String calculate(int number, String arithmeticToPerform);

}