package org.easyfx.samples.basic.views;

import javafx.event.ActionEvent;
import org.easyfx.core.FXRouter;
import org.easyfx.core.annotations.View;

@View("login")
public class Login {

    private final FXRouter router;

    public Login(FXRouter router) {
        this.router = router;
    }

    public void goToHome(ActionEvent actionEvent) {
        router.navigate("home");
    }
}
