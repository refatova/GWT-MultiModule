package client.main_module.client;

import client.main_module.client.ui.HomePageView;
import client.shared.client.CommonView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;


@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    Injector INSTANCE = GWT.create(Injector.class);

    HomePageView gethomePageView();

    CommonView getCommonView();
}
