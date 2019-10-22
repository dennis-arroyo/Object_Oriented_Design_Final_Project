package Screens;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import state_pattern.ClearState;
import state_pattern.Context;
import state_pattern.DrawState;

public class PatternsInfoScreen
{
    private static final String CHAIN_OF_RESPONSIBILITY_PATTERN = "Chain of Responsibility Pattern";
    private static final String FACADE_PATTERN = "Facade Pattern";
    private static final String OBSERVER_PATTERN = "Observer Pattern";
    private static final String FACTORY_PATTERN = "Factory Pattern";
    private static final String VISITOR_PATTERN = "Visitor Pattern";
    private static final String STATE_PATTERN = "State Pattern";
    private static final String PROXY_PATTERN = "Proxy Pattern";
    private static RadioButton chain;
    private static RadioButton facade;
    private static RadioButton observer;
    private static RadioButton factory;
    private static RadioButton visitor;
    private static RadioButton state;
    private static RadioButton proxy;
    private static TextArea textArea;
    private static Context context;
    private static ClearState clearState;
    private static DrawState drawState;

    public static RadioButton getChain()
    {
        return chain;
    }

    public static RadioButton getFacade()
    {
        return facade;
    }

    public static RadioButton getObserver()
    {
        return observer;
    }

    public static RadioButton getFactory()
    {
        return factory;
    }

    public static RadioButton getVisitor()
    {
        return visitor;
    }

    public static RadioButton getState()
    {
        return state;
    }

    public static RadioButton getProxy()
    {
        return proxy;
    }

    public static TextArea getTextArea()
    {
        return textArea;
    }

    public static void setStageScene()
    {
        VBox root = new VBox();
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);

        Label label = new Label();
        label.setText("Below you'll find all design patterns used for the creation of this program. " +
                "If you wish to learn their definitions, click on the checkbox.");

        double stageWidth = Home.getStage().getWidth();
        double stageHeight = Home.getStage().getHeight();

        ToggleGroup radioGroup = new ToggleGroup();

        chain = new RadioButton(CHAIN_OF_RESPONSIBILITY_PATTERN);
        chain.setOnAction(actionEvent -> {
            loadPatternData();
        });

        facade = new RadioButton(FACADE_PATTERN);
        facade.setOnAction(actionEvent -> {
            loadPatternData();
        });

        observer = new RadioButton(OBSERVER_PATTERN);
        observer.setOnAction(actionEvent -> {
            loadPatternData();
        });

        factory = new RadioButton(FACTORY_PATTERN);
        factory.setOnAction(actionEvent -> {
            loadPatternData();
        });

        visitor = new RadioButton(VISITOR_PATTERN);
        visitor.setOnAction(actionEvent -> {
            loadPatternData();
        });

        state = new RadioButton(STATE_PATTERN);
        state.setOnAction(actionEvent -> {
            loadPatternData();
        });

        proxy = new RadioButton(PROXY_PATTERN);
        proxy.setOnAction(actionEvent -> {
            loadPatternData();
        });

        chain.setToggleGroup(radioGroup);
        facade.setToggleGroup(radioGroup);
        observer.setToggleGroup(radioGroup);
        factory.setToggleGroup(radioGroup);
        visitor.setToggleGroup(radioGroup);
        state.setToggleGroup(radioGroup);
        proxy.setToggleGroup(radioGroup);

        HBox checkBoxLayout = new HBox(20, chain, facade, observer, factory, visitor, state, proxy);
        checkBoxLayout.setAlignment(Pos.CENTER);

        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setPrefWidth(stageWidth/2);
        textArea.setMaxWidth(stageWidth/2);
        textArea.setPrefHeight(stageHeight/2);
        textArea.setMaxHeight(stageHeight/2);

        Button returnButton = new Button("HOME");
        returnButton.setId("homeButton");
        returnButton.setOnAction(actionEvent -> {
            Home.getScene().setRoot(Home.getRootFromHomeCopy());
        });

        root.getChildren().addAll(label, checkBoxLayout, textArea, returnButton);;

        Home.getScene().setRoot(root);
    }

    private static void loadPatternData()
    {
        context = new Context();
        clearState = new ClearState();
        drawState = new DrawState();
        clearState.doAction(context);
        drawState.doAction(context);

    }
}
