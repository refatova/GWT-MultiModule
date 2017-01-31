package client.shared.client;


import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * Created by Saniye on 31.10.16.
 */

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    Injector INSTANCE = GWT.create(Injector.class);
    CommonView getCommonView();
    EventBus getEventBus();
}
