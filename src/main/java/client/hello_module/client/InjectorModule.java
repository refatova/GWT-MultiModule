package client.hello_module.client;

import client.hello_module.client.ui.LoginPageView;
import client.hello_module.client.ui.LoginPageViewImpl;
import client.shared.client.CommonView;
import client.shared.client.CommonViewImpl;
import client.shared.client.SharedInjectorModule;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

public class InjectorModule extends SharedInjectorModule {
    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class);
        bind(LoginPageView.class).to(LoginPageViewImpl.class);
        bind(CommonView.class).to(CommonViewImpl.class);
    }
}
