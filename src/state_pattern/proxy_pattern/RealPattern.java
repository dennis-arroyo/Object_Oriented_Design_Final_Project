package state_pattern.proxy_pattern;

public class RealPattern implements Pattern
{
    private static final String CHAIN_OF_RESPONSIBILITY_PATTERN = "Chain of Responsibility Pattern";
    private static final String FACADE_PATTERN = "Facade Pattern";
    private static final String OBSERVER_PATTERN = "Observer Pattern";
    private static final String FACTORY_PATTERN = "Factory Pattern";
    private static final String VISITOR_PATTERN = "Visitor Pattern";
    private static final String STATE_PATTERN = "State Pattern";
    private static final String PROXY_PATTERN = "Proxy Pattern";
    private String patternName;

    public RealPattern(String patternName)
    {
        this.patternName = patternName;
    }

    @Override
    public String getPatternInfo()
    {
        return patternName + ":\n\n" + loadPatternDescription();
    }

    private String loadPatternDescription()
    {
        String desc = "";
        if (patternName.equals(CHAIN_OF_RESPONSIBILITY_PATTERN))
            desc = loadChainDesc();
        if (patternName.equals(FACADE_PATTERN))
            desc =loadFacadeDesc();
        if (patternName.equals(OBSERVER_PATTERN))
            desc = loadObserverDesc();
        if (patternName.equals(FACTORY_PATTERN))
            desc = loadFactoryDesc();
        if (patternName.equals(VISITOR_PATTERN))
            desc = loadVisitorDesc();
        if (patternName.equals(STATE_PATTERN))
            desc = loadStateDesc();
        if (patternName.equals(PROXY_PATTERN))
            desc = loadProxyDesc();

        return desc;
    }

    private String loadChainDesc()
    {
        return "Creates a chain of receiver objects for a request. This pattern decouples sender and receiver" +
                " of a request based on type of request. This pattern comes under behavioral patterns.";
    }

    private String loadFacadeDesc()
    {
        return "Hides the complexities of the system and provides an interface to the client using which the client " +
                "can access the system. This type of design pattern comes under structural pattern as this pattern " +
                "adds an interface to existing system to hide its complexities.";
    }

    private String loadObserverDesc()
    {
        return "Used when there is one-to-many relationship between objects such as if one object is modified, its " +
                "dependent objects are to be notified automatically. Observer pattern falls under behavioral pattern " +
                "category.";
    }

    private String loadFactoryDesc()
    {
        return "Factory pattern is one of the most used design patterns in Java. This type of design pattern comes " +
                "under creational pattern as this pattern provides one of the best ways to create an object.";
    }

    private String loadVisitorDesc()
    {
        return "Use a visitor class which changes the executing algorithm of an element class. By this way, " +
                "execution algorithm of element can vary as and when visitor varies. This pattern comes under " +
                "behavior pattern category. As per the pattern, element object has to accept the visitor object so " +
                "that visitor object handles the operation on the element object.";
    }

    private String loadStateDesc()
    {
        return "In State pattern a class behavior changes based on its state. we create objects which represent " +
                "various states and a context object whose behavior varies as its state object changes.";
    }

        private String loadProxyDesc()
    {
        return "In proxy pattern, a class represents functionality of another class. we create object having " +
                "original object to interface its functionality to outer world. This type of design pattern " +
                "comes under structural pattern.";
    }
}
