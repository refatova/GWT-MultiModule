package client.main_module.client.ui;

import client.main_module.client.GreetingMessageIntf;
import client.main_module.client.GreetingMessageIntfAsync;
import client.shared.client.GWTHelloConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Logger;

/**
 * Created by Saniye on 23.09.16.
 */
public class HomePageViewImpl extends Composite implements HomePageView{

    interface MyBinderUiBinder extends UiBinder<Widget, HomePageViewImpl> {}
    private static MyBinderUiBinder ourUiBinder = GWT.create(MyBinderUiBinder.class);
    private GWTHelloConstants constants = GWT.create(GWTHelloConstants.class);
    private static Logger logger = Logger.getLogger(HomePageViewImpl.class.toString());
    private static final String HOME_PAGE = "HomePage: ";
    private Presenter presenter;
    private final GreetingMessageIntfAsync greetingService = GWT.create(GreetingMessageIntf.class);

    @UiField
    Label greetingMessage;
    @UiField
    Button returnButton;


    public HomePageViewImpl(){
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void setGreetingMessage(String helloString) {
        greetingMessage.setText(helloString);
        logger.info(HOME_PAGE + "Display message: " + helloString);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setExitButtonText() {
        this.returnButton.setText(constants.quit());
    }


    @UiHandler("returnButton")
    void onClickLogout(ClickEvent e)
    {  Cookies.removeCookie("logged_user");
        logger.info(HOME_PAGE + "Return button pushed");
        Window.open("Hello.html","_self","");
    }

}