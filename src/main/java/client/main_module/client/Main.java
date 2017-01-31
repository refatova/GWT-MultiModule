package client.main_module.client;

import client.main_module.client.ui.HomePageView;
import client.main_module.client.ui.HomePageViewImpl;
import client.shared.client.CommonView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;


/**
 * Created by Saniye on 29.12.16.
 */
public class Main implements EntryPoint {
    GreetingMessageIntfAsync greetingservice = GWT.create(GreetingMessageIntf.class);
    private CommonView commonView;
    HomePageView homePageView;
    private final Injector injector = Injector.INSTANCE;

    public void onModuleLoad() {
        commonView = injector.getCommonView();
        homePageView = injector.gethomePageView();
        Window.alert("main module");
//        HomePageView homePageView = new HomePageViewImpl();
        homePageView.setExitButtonText();
        String s = Cookies.getCookie("logged_user");
        if (s != null) {
            AsyncCallback<String> callback = new AsyncCallback<String>() {
                @Override
                public void onFailure(Throwable caught) {
                    System.out.println("error");
                }

                @Override
                public void onSuccess(String result) {
                    homePageView.setGreetingMessage(result + " " + s);
                    commonView.setWidget(homePageView);
                    RootPanel.get().clear();
                    RootPanel.get().add((Widget) commonView);


//                    RootPanel.get("content").clear();
//                    RootPanel.get().add(homePageView);
                }
            };
            greetingservice.getGreeting(LocaleInfo.getCurrentLocale().getLocaleName(), callback);

        } else {
//            Window.alert("cookie is null");
//            Window.open("Hello.html", "_self", "");
        }
    }
}
