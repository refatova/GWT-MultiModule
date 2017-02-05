package client.hello_module.client.activity;

import client.hello_module.client.LoginServiceIntf;
import client.hello_module.client.LoginServiceIntfAsync;
import client.hello_module.client.ClientFactory;
import client.shared.client.GWTHelloConstants;
import client.hello_module.client.Injector;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import client.hello_module.client.ui.LoginPageView;
import client.hello_module.client.ui.LoginPageViewImpl;

import java.util.logging.Logger;

/**
 * Created by Saniye on 27.10.16.
 */
public class LoginActivity extends AbstractActivity implements LoginPageView.Presenter {

    private final Injector injector;
    private LoginPageView loginPageView;
    private static Logger logger = Logger.getLogger(LoginPageViewImpl.class.getName());
    private final LoginServiceIntfAsync loginService = GWT.create(LoginServiceIntf.class);
    private GWTHelloConstants constants = GWT.create(GWTHelloConstants.class);
    private static final String LOGIN_PAGE = "LoginPage: ";

    public LoginActivity(ClientFactory clientFactory) {
        this.injector = Injector.INSTANCE;
        this.loginPageView = injector.getLoginPageView();
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        loginPageView.setNameFieldLabel();
        loginPageView.setPasswordFieldLabel();
        loginPageView.cleanErrorMessage();
        loginPageView.setLoginButtonText();
        loginPageView.cleanLoginField();
        loginPageView.cleanPasswordField();
        loginPageView.setLoginButtonEnable(true);
        loginPageView.setPresenter(this);
        containerWidget.setWidget(loginPageView.asWidget());
    }

    @Override
    public void sendUserToServer(String login, String password) {
        loginService.login(login, password, LocaleInfo.getCurrentLocale().getLocaleName(),
                new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        loginPageView.setErrorMessage(constants.serverError());
                        logger.info(LOGIN_PAGE + "Error message \"Incorrect username or password\"");
                        loginPageView.setLoginButtonEnable(true);
                    }

                    @Override
                    public void onSuccess(Void result) {
                        if (Cookies.getCookie("logged_user") != null)
                            Window.open("Main.html", "_self", "");
                    }
                });
    }
}
