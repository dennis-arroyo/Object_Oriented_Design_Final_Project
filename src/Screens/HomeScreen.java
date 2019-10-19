package Screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HomeScreen
{
    private static final String  ARITHMETIC = "ARITHMETIC";

    public static void setStageScene()
    {
        Label label = new Label();
        label.setText("Choose program to run...");

        String style = HomeScreen.class.getResource("../css_styles/buttonStyle.css").toExternalForm();

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
        Scene scene = new Scene(root);
        scene.getStylesheets().add(style);

        root.getChildren().addAll(labelLayout, buttonsLayout);
        Home.getStage().setScene(scene);
    }

    private static void validateScreenSelection(String selectedScreen)
    {
        if (selectedScreen.equals(ARITHMETIC))
            ArithmeticScreen.setStageScene();
    }
}
