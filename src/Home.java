import Screens.ArithmeticScreen;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Home extends Application
{
    private static final String  ARITHMETIC = "ARITHMETIC";
    private static Stage stage;

    public static void main(String[] args)
    {
        launch(args);
    }

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

        Label label = new Label();
        label.setText("Choose program to run...");

        String style = getClass().getResource("css_styles/buttonStyle.css").toExternalForm();

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        Button button1 = new Button(ARITHMETIC);
        button1.setId("homeButton");
        button1.setOnAction(actionEvent -> {
            validateScreenSelection(ARITHMETIC);
        });

        Button button2 = new Button("Graph");
        button2.setId("homeButton");

        Button button3 = new Button("Employee App");
        button3.setId("homeButton");

        Button button4 = new Button("Something else");
        button4.setId("homeButton");

        HBox labelLayout = new HBox(label);
        labelLayout.setAlignment(Pos.CENTER);

        HBox buttonsLayout = new HBox(20, button1, button2,  button3, button4);
        buttonsLayout.setAlignment(Pos.CENTER);

        root.getChildren().addAll(labelLayout, buttonsLayout);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(style);

        stage.setScene(scene);
        stage.show();
    }

    private void validateScreenSelection(String selectedScreen)
    {
        if (selectedScreen.equals(ARITHMETIC))
            stage.setScene(ArithmeticScreen.getArithmeticScreen());
    }
}
