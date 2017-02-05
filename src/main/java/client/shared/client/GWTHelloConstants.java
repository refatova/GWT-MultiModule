package client.shared.client;

import com.google.gwt.i18n.client.Constants;

public interface GWTHelloConstants extends Constants {


    @DefaultStringValue("Login")
    String login();

    @DefaultStringValue("Password")
    String password();

    @DefaultStringValue("Username")
    String username();

    @DefaultStringValue("Quit")
    String quit();

    @DefaultStringValue("Please enter login and password.")
    String validationError();

    @DefaultStringValue("Incorrect username or password.")
    String serverError();

    @DefaultStringValue("Upload")
    String upload();

    @DefaultStringValue("Clean")
    String clean();

}
