package org.easyfx.samples.basic.views;

import javafx.event.ActionEvent;
import org.easyfx.core.FXRouter;
import org.easyfx.core.annotations.View;

@View("home")
public class Home {

    private final FXRouter router;

    public Home(FXRouter router) {
        this.router = router;
    }

    public void goToLogin(ActionEvent actionEvent) {
        this.router.navigate("login");
    }
}
