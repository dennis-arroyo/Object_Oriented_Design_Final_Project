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
//        else if(shapeType.equalsIgnoreCase("RECTANGLE")){
//            return new Rectangle();
//
//        } else if(shapeType.equalsIgnoreCase("SQUARE")){
//            return new Square();
//        }

        return null;
    }
}
