package org.easyfx.core;

import io.micronaut.context.ApplicationContext;
import jakarta.inject.Singleton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

@Singleton
public class FXLoader {

    private Logger log = LoggerFactory.getLogger(FXLoader.class);

    private ApplicationContext context;

    public FXLoader(ApplicationContext context) {
        this.context = context;
    }


    public Parent load(String fxmlFileName) {
        var path = resolve(fxmlFileName);
        var loader = new FXMLLoader(path);
        loader.setControllerFactory(beanType -> context.getBean(beanType));
        try {
            return loader.load();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return null;
    }

    private URL resolve(final String fileName){
        return FXLoader.class.getResource("/views/" + fileName + ".fxml");
    }
}
