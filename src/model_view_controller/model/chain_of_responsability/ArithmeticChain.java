/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Handler Class for Chain of Responsibility Pattern
 */
package model_view_controller.model.chain_of_responsability;

// Interface to be implemented in concrete handler classes
public interface ArithmeticChain
{
    void setNextChain(ArithmeticChain nextChain);
    void calculate(Requirements req);

}