package Screens;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class ArithmeticScreen
{
    public static Scene getArithmeticScreen()
    {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        Label label = new Label();
        label.setText("This is the Arithmetic Screen !");

        Button button1 = new Button("Arithmetic");

        Button button2 = new Button("Graph");

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        HBox labelLayout = new HBox(label);
        labelLayout.setAlignment(Pos.CENTER);

        HBox buttonsLayout = new HBox(20, button1, button2);
        buttonsLayout.setAlignment(Pos.CENTER);

        root.getChildren().addAll(labelLayout, buttonsLayout);

        return new Scene(root);
    }
}
