package client.hello_module.client;

import client.shared.client.CommonView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import client.hello_module.client.ui.LoginPageView;

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    Injector INSTANCE = GWT.create(Injector.class);

    EventBus getEventBus();
    LoginPageView getLoginPageView();
    CommonView getCommonView();
}
