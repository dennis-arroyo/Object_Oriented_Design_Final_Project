package chain_of_responsability;

public interface ArithmeticChain
{
    void setNextChain(ArithmeticChain nextChain);
    void calculate(Requirements req);
}
