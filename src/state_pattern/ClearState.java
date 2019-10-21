package state_pattern;

import Screens.PatternsInfoScreen;

public class ClearState implements State
{

    @Override
    public void doAction(Context context)
    {
        context.setState(this);
        PatternsInfoScreen.getTextArea().clear();
    }
}
