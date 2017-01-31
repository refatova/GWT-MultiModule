package client.hello_module.client;

import client.shared.client.CommonView;
import client.shared.client.CommonViewImpl;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import client.main_module.client.ui.HomePageView;
import client.main_module.client.ui.HomePageViewImpl;
import client.hello_module.client.ui.LoginPageView;
import client.hello_module.client.ui.LoginPageViewImpl;

/**
 * Created by Saniye on 31.10.16.
 */
public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
//        bind(EventBus.class).to(SimpleEventBus.class);
//        bind(HomePageView.class).to(HomePageViewImpl.class);
        bind(LoginPageView.class).to(LoginPageViewImpl.class);
        bind(CommonView.class).to(CommonViewImpl.class);
    }
}
