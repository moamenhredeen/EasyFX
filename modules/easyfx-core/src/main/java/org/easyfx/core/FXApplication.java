package org.easyfx.core;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;
import javafx.application.Application;
import javafx.stage.Stage;


public abstract class FXApplication extends Application {

    protected ApplicationContext context;
    protected FXRouter router;

    @Override
    public void init(){
        context = Micronaut.run(getClass());
    }

    @Override
    public void start(Stage stage){
                context.registerSingleton(Stage.class, stage);
                router = context.getBean(FXRouter.class);
                doStart(stage);
    }

    public abstract void doStart(Stage stage);
}
