import chain_of_responsability.*;

public class ChainResponsibilityApp
{
    public static void main(String[] args)
    {
        ArithmeticChain chain1 = new Fibonacci();
        ArithmeticChain chain2 = new Factorial();
        ArithmeticChain chain3 = new Square();
        ArithmeticChain chain4 = new SquaredRoot();

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        chain3.setNextChain(chain4);

        System.out.println("Calculating fibonacci sequence...");
        chain1.calculate(new Requirements(7, "fibonacci"));

        System.out.println("-------");

        System.out.println("Calculating factorial of 5...");
        chain1.calculate(new Requirements(5, "factorial"));

        System.out.println("-------");

        System.out.println("Calculating the square of 10...");
        chain1.calculate(new Requirements(10, "square"));

        System.out.println("-------");

        System.out.println("Calculating the squared root of 256...");
        chain1.calculate(new Requirements(256, "squared root"));

        System.out.println("-------");

        System.out.println("Performing unknown operation...");
        chain1.calculate(new Requirements(9, "unknown"));

        System.out.println("\nFinished code execution...");
        System.exit(0);
    }
}
