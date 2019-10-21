package state_pattern.proxy_pattern;

public class ProxyPattern implements Pattern
{
    private RealPattern realPattern;
    private String patternName;

    public ProxyPattern(String patternName)
    {
        this.patternName = patternName;
    }

    @Override
    public String getPatternInfo()
    {
        if (realPattern == null)
            realPattern = new RealPattern(patternName);
        return realPattern.getPatternInfo();
    }
}
