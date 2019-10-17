import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        stage.setTitle("This is a test!");

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX(50);
        stage.setY(50);
        stage.setWidth(primaryScreenBounds.getWidth()/2);
        stage.setHeight(primaryScreenBounds.getHeight()/2);

        stage.initStyle(StageStyle.DECORATED);

        Label label = new Label();
        label.setText("Here there will be a short explanation on how to program works !");

//        String buttonCssStyle = "-fx-border: none; -xf-background: #404040; -fx-color: #ffffff !important; " +
//                "-fx-font-weight: 100; -fx-padding: 20px; -fx-text-transform: uppercase; -fx-border-radius: 6px; " +
//                "-fx-display: inline-block; -fx-transition: all 0.3s ease 0s;";
//        String buttonOnHovered = "-fx-color: #404040 !important; -fx-font-weight: 700 !important; -fx-letter-spacing: 3px; " +
//                "-fx-background: none; -webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57); " +
//                "-moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57); transition: all 0.3s ease 0s;";

//        String buttonCssStyle = "-fx-box-shadow: 0px 10px 14px -7px #276873; " +
//                "-fx-background:linear-gradient(to bottom, #599bb3 5%, #408c99 100%); -fx-background-color:#599bb3; " +
//                "-fx-border-radius:8px; -fx-display:inline-block; -fx-cursor:pointer; -fx-color:#ffffff; " +
//                "-fx-font-family:Arial; -fx-font-size:20px; -fx-font-weight:bold; -fx-padding:13px 32px; " +
//                "-fx-text-decoration:none; -fx-text-shadow:0px 1px 0px #3d768a;";
//
//        String buttonOnHovered = "-fx-background:linear-gradient(to bottom, #408c99 5%, #599bb3 100%); " +
//                "-fx-background-color:#408c99;;";

        Button button1 = new Button("Arithmetic");
//        button1.setStyle(buttonCssStyle);
//        button1.setOnMouseEntered(e -> button1.setStyle(buttonOnHovered));
//        button1.setOnMouseExited(e -> button1.setStyle(buttonCssStyle));

        Button button2 = new Button("Graph");

        Button button3 = new Button("Employee App");

        Button button4 = new Button("Something else");

        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        HBox labelLayout = new HBox(label);
        labelLayout.setAlignment(Pos.CENTER);

        HBox buttonsLayout = new HBox(20, button1, button2,  button3, button4);
        buttonsLayout.setAlignment(Pos.CENTER);

        root.getChildren().addAll(labelLayout, buttonsLayout);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
