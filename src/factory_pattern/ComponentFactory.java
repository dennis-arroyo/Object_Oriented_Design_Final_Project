package factory_pattern;

public class ComponentFactory
{
    public SceneComponent getComponent(String component){
        if(component == null){
            return null;
        }
        if(component.equalsIgnoreCase("table")){
            new EmployeeTable().drawComponent();
        }
        else if (component.equalsIgnoreCase("add button"))
        {
            new AddEmployeeButton().drawComponent();
        }

        return null;
    }
}
