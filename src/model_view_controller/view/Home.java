package model_view_controller.view;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Home extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    public void start(Stage stage)
    {
        stage = new Stage();
        stage.setTitle("This is the title of the Application");

//        Prevents the user from interacting with other windows while this one is active
//        stage.initModality(Modality.APPLICATION_MODAL);

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX(50);
        stage.setY(50);
        stage.setWidth(primaryScreenBounds.getWidth()/2);
        stage.setHeight(primaryScreenBounds.getHeight()/2);

        stage.initStyle(StageStyle.DECORATED);
//      stage.initStyle(StageStyle.UNDECORATED);
//      stage.initStyle(StageStyle.TRANSPARENT);
//      stage.initStyle(StageStyle.UNIFIED);
//      stage.initStyle(StageStyle.UTILITY);

        Button button1 = new Button("Button 1");
        button1.setMnemonicParsing(true);

        button1.setText("_Click");
//        String styles =
//                "-fx-background-color: #0000ff;" + "-fx-border-color: #ff0000;" ;
//        button1.setStyle(styles);
        Button button2 = new Button("Button 2");
        button2.setOnAction(actionEvent -> {
            System.out.println("You clicked button 2");
        });

        Hyperlink hyperlink = new Hyperlink("Print Hello");
        hyperlink.setOnAction(e -> {
            System.out.println("Hello !");
        });

        VBox vBoxLayout = new VBox(button1, button2, hyperlink);
        Scene scene = new Scene(vBoxLayout);
//        scene.setCursor(Cursor.OPEN_HAND);
//        scene.setCursor(Cursor.WAIT);
//        scene.setCursor(Cursor.CROSSHAIR);

        stage.setScene(scene);
//        stage.setFullScreen(true);
        stage.show();
    }
}
