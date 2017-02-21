package client.main_module.client;

import client.main_module.client.ui.HomePageView;
import client.shared.client.CommonView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Main implements EntryPoint {
    GreetingMessageIntfAsync greetingservice = GWT.create(GreetingMessageIntf.class);
    private CommonView commonView;
    HomePageView homePageView;
    private final Injector injector = Injector.INSTANCE;

    public void onModuleLoad() {

        commonView = injector.getCommonView();
        homePageView = injector.gethomePageView();
        homePageView.setExitButtonText();
        AsyncCallback<String> callback = new AsyncCallback<String>() {
                @Override
                public void onFailure(Throwable caught) {
                    System.out.println("error");
                }

                @Override
                public void onSuccess(String result) {
                    homePageView.setGreetingMessage(result);
                    commonView.setWidget(homePageView);
                    RootPanel.get().clear();
                    RootPanel.get().add((Widget) commonView);
                }
            };
        greetingservice.getGreeting(LocaleInfo.getCurrentLocale().getLocaleName(), callback);
    }
}
