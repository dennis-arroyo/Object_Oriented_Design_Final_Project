package state_pattern;

import Screens.PatternsInfoScreen;
import state_pattern.proxy_pattern.Pattern;
import state_pattern.proxy_pattern.ProxyPattern;

public class DrawState implements State
{
    private static final String CHAIN_OF_RESPONSIBILITY_PATTERN = "Chain of Responsibility Pattern";
    private static final String FACADE_PATTERN = "Facade Pattern";
    private static final String OBSERVER_PATTERN = "Observer Pattern";
    private static final String FACTORY_PATTERN = "Factory Pattern";
    private static final String VISITOR_PATTERN = "Visitor Pattern";
    private static final String STATE_PATTERN = "State Pattern";
    private static final String PROXY_PATTERN = "Proxy Pattern";

    @Override
    public void doAction(Context context)
    {
        context.setState(this);
        String str = "";
        if (PatternsInfoScreen.getChain().isSelected())
            str = CHAIN_OF_RESPONSIBILITY_PATTERN;
        else if (PatternsInfoScreen.getFacade().isSelected())
            str = FACADE_PATTERN;
        else if (PatternsInfoScreen.getObserver().isSelected())
            str = OBSERVER_PATTERN;
        else if (PatternsInfoScreen.getFactory().isSelected())
            str = FACTORY_PATTERN;
        else if (PatternsInfoScreen.getVisitor().isSelected())
            str = VISITOR_PATTERN;
        else if (PatternsInfoScreen.getState().isSelected())
            str = STATE_PATTERN;
        else if (PatternsInfoScreen.getProxy().isSelected())
            str = PROXY_PATTERN;

        Pattern pattern = new ProxyPattern(str);
        str = pattern.getPatternInfo();
        PatternsInfoScreen.getTextArea().appendText(str);
    }
}
