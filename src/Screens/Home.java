package Screens;

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
    private static Stage stage;
    private static final String  ARITHMETIC = "ARITHMETIC";
    private static final String  GRAPH = "GRAPH";
    private static final String  EMPLOYEE = "EMPLOYEE";
    private static final String  PATTERNS_INFO = "PATTERNS INFO";
    private static Scene scene;
    private static VBox rootFromHomeCopy;

    public static Stage getStage()
    {
        return stage;
    }

    public static VBox getRootFromHomeCopy()
    {
        return rootFromHomeCopy;
    }

    public static Scene getScene()
    {
        return scene;
    }

    public void start(Stage primaryStage)
    {
        createScreen(primaryStage);
    }

    public static void createScreen(Stage primaryStage)
    {
        stage = primaryStage;
        stage.setTitle("CECS 6150 Object-Oriented Design");

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        stage.setX(50);
        stage.setY(50);
        stage.setWidth(primaryScreenBounds.getWidth() - primaryScreenBounds.getWidth()/3);
        stage.setHeight(primaryScreenBounds.getHeight() - primaryScreenBounds.getHeight()/4);

        stage.initStyle(StageStyle.DECORATED);
        Label label = new Label();
        label.setText("Welcome ! The following system consists of 4 different programs. \nEach one is designed " +
                "with one or more Design Patterns. Click on any of the below buttons to start...");

        String style = Home.class.getResource("../css_styles/buttonStyle.css").toExternalForm();

        VBox root = new VBox();
        rootFromHomeCopy = root;
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        Button button1 = new Button(ARITHMETIC);
        button1.setId("homeButton");
        button1.setOnAction(actionEvent -> {
            validateScreenSelection(ARITHMETIC);
        });

        Button button2 = new Button(GRAPH);
        button2.setId("homeButton");
        button2.setOnAction(actionEvent -> {
            validateScreenSelection(GRAPH);
        });

        Button button3 = new Button(EMPLOYEE);
        button3.setId("homeButton");
        button3.setOnAction(actionEvent -> {
            validateScreenSelection(EMPLOYEE);
        });

        Button button4 = new Button(PATTERNS_INFO);
        button4.setId("homeButton");
        button4.setOnAction(actionEvent -> {
            validateScreenSelection(PATTERNS_INFO);
        });

        HBox labelLayout = new HBox(label);
        labelLayout.setAlignment(Pos.CENTER);

        HBox buttonsLayout = new HBox(20, button1, button2,  button3, button4);
        buttonsLayout.setAlignment(Pos.CENTER);
        scene = new Scene(root);
        scene.getStylesheets().add(style);

        root.getChildren().addAll(labelLayout, buttonsLayout);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private static void validateScreenSelection(String selectedScreen)
    {
        switch (selectedScreen) {
            case ARITHMETIC:
                ArithmeticScreen.setStageScene();
                break;
            case GRAPH:
                GraphScreen.setStageScene();
                break;
            case EMPLOYEE:
                EmployeeAppScreen.setStageScene();
                break;
            case PATTERNS_INFO:
                PatternsInfoScreen.setStageScene();
                break;
        }

    }

}
