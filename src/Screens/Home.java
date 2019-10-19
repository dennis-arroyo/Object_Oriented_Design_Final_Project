package Screens;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Home extends Application
{
    private static Stage stage;

    public static Stage getStage()
    {
        return stage;
    }

    public void start(Stage primaryStage)
    {
        stage = primaryStage;
        stage.setTitle("This is a test!");

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX(50);
        stage.setY(50);
        stage.setWidth(primaryScreenBounds.getWidth() - primaryScreenBounds.getWidth()/3);
        stage.setHeight(primaryScreenBounds.getHeight() - primaryScreenBounds.getHeight()/3);

        stage.initStyle(StageStyle.DECORATED);

        HomeScreen.setStageScene();
        stage.show();
    }

}
