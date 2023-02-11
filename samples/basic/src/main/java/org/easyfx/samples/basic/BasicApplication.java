package org.easyfx.samples.basic;

import javafx.stage.Stage;
import org.easyfx.core.FXApplication;

public class BasicApplication extends FXApplication {

    @Override
    public void doStart(Stage stage) {
        router.navigate("login");
        stage.show();
    }
}
