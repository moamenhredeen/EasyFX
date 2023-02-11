package org.easyfx.core;

import jakarta.inject.Singleton;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Singleton
class FXRouterImpl implements FXRouter {

    private final Map<String, Parent> views = new HashMap<>();
    private final Stack<String> history = new Stack<>();
    private String activeView;

    private final FXLoader loader;
    private final Stage primaryStage;
    private Scene primaryScene;

    public FXRouterImpl(Stage stage, FXLoader fxLoader) {
        primaryStage = stage;
        loader = fxLoader;
        primaryScene = new Scene(new Pane(), 800, 400);
        primaryStage.setScene(primaryScene);
    }


    @Override
    public void navigate(final String view){
        history.push(view);
        if(!views.containsKey(view)){
            views.put(view, loader.load(view));
        }

        activeView = view;
        primaryScene.setRoot(views.get(view));
    }

    @Override
    public void back(){
        this.navigate(this.history.pop());
    }
}
