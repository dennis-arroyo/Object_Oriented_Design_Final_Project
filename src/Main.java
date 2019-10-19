/**
 * Author: Dennis O. Arroyo Rivera
 *
 * Description:
 * Main application. Initializes Menu screen from the view package on MVC.
 * */
import Screens.Home;
import javafx.application.Application;

public class Main
{
    public static void main(String[] args)
    {
        // Launches javaFx app from the MVC Pattern view package
        Application.launch(Home.class, args);
    }
}
