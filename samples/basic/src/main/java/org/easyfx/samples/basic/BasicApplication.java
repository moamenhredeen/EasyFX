package org.easyfx.samples.basic;

import atlantafx.base.theme.NordDark;
import javafx.stage.Stage;
import org.easyfx.core.FXApplication;

public class BasicApplication extends FXApplication {

    @Override
    public void doStart(Stage stage) {
        BasicApplication.setUserAgentStylesheet(new NordDark().getUserAgentStylesheet());
        router.navigate("login");
        stage.show();
    }
}
