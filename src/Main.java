import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application
{
    public void start(Stage stage)
    {
        stage = new Stage();
        stage.setTitle("This is the title of the Application");

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth()/2);
        stage.setHeight(primaryScreenBounds.getHeight()/2);

        VBox vBoxLayout = new VBox();
        Scene scene = new Scene(vBoxLayout);

        stage.setScene(scene);
        stage.showAndWait();
    }
}
