package org.easyfx.core;

import io.micronaut.context.ApplicationContext;
import jakarta.inject.Singleton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class FXLoader {

    private Logger log = LoggerFactory.getLogger(FXLoader.class);
    private Map<String, FXMLLoader> loaders = new HashMap<>();

    private ApplicationContext context;

    public FXLoader(ApplicationContext context) {
        this.context = context;
    }


    public Parent load(String fxmlFileName) {
        var path = resolve(fxmlFileName);
        var loader = loaders.containsKey(fxmlFileName) ? loaders.get(fxmlFileName) : new FXMLLoader(path);
        loader.setControllerFactory(beanType -> context.getBean(beanType));
        try {
            Parent parent = loader.load();
            loaders.put(fxmlFileName, loader);
            return parent;
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return null;
    }

    private URL resolve(final String fileName){
        return FXLoader.class.getResource("/views/" + fileName + ".fxml");
    }
}
