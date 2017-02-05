package client.main_module.client;


import client.main_module.client.ui.HomePageView;
import client.main_module.client.ui.HomePageViewImpl;
import client.shared.client.CommonView;
import client.shared.client.CommonViewImpl;
import client.shared.client.SharedInjectorModule;


public class InjectorModule extends SharedInjectorModule {
    @Override
    protected void configure() {
        bind(HomePageView.class).to(HomePageViewImpl.class);
        bind(CommonView.class).to(CommonViewImpl.class);
    }
}
