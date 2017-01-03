package client.hello_module.client.ui;

import client.shared.client.GWTHelloConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Logger;


/**
 * Created by Saniye on 23.09.16.
 */
public class LoginPageViewImpl extends Composite implements LoginPageView {
    interface LoginBinderUiBinder extends UiBinder<Widget, LoginPageViewImpl> {
    }
    private static LoginBinderUiBinder ourUiBinder = GWT.create(LoginBinderUiBinder.class);

    private GWTHelloConstants constants = GWT.create(GWTHelloConstants.class);
    private static Logger logger = Logger.getLogger(LoginPageViewImpl.class.getName());
    private static final String LOGIN_PAGE = "LoginPage: ";
    private Presenter presenter;
    @UiField
    Button loginButton;
    @UiField
    TextBox nameField;
    @UiField
    PasswordTextBox passwordTextBox;
    @UiField
    Label labelName;
    @UiField
    Label labelPassword;
    @UiField
    Label errorMessage;

    @Override
    public void setLoginButtonText() {
        this.loginButton.setText(constants.login());
    }

    @Override
    public void setNameFieldLabel() {
        labelName.setText(constants.username());
    }

    @Override
    public void setPasswordFieldLabel() {
        labelPassword.setText(constants.password());
    }

    @Override
    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void setLoginButtonEnable(boolean flag) {
        loginButton.setEnabled(flag);
    }

    @Override
    public void cleanLoginField() {
        nameField.setText("");

    }

    @Override
    public void cleanPasswordField() {
        passwordTextBox.setText("");
    }

    @Override
    public void cleanErrorMessage() {
        errorMessage.setText("");
    }

    @UiHandler("loginButton")
    void onClickLogin(ClickEvent e) {
        String loginToServer = nameField.getText();
        String passwordToServer = passwordTextBox.getText();
        if (!loginToServer.isEmpty() && !passwordToServer.isEmpty()) {
            setLoginButtonEnable(false);
            presenter.sendUserToServer(loginToServer, passwordToServer);
            logger.info(LOGIN_PAGE +"Login "+ loginToServer + " "+ " were sent to client.shared.server");
        } else {
            logger.info(LOGIN_PAGE + "Error message \"Login and password fields are empty\"");
            setErrorMessage(constants.validationError());
        }
    }

    public LoginPageViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
        logger.info(LOGIN_PAGE + "Login page loaded");
        logger.info(LOGIN_PAGE + "Browser locale is " + LocaleInfo.getCurrentLocale().getLocaleName());
    }
}