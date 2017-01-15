package client.hello_module.client;

import client.shared.client.CommonView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import client.main_module.client.ui.HomePageView;
import client.hello_module.client.ui.LoginPageView;

/**
 * Created by Saniye on 31.10.16.
 */

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    Injector INSTANCE = GWT.create(Injector.class);

    EventBus getEventBus();

    HomePageView gethomePageView();

    LoginPageView getLoginPageView();

    CommonView getCommonView();
}
