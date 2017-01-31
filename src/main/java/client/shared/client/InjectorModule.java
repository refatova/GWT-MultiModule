package client.shared.client;


import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;

/**
 * Created by Saniye on 31.10.16.
 */
public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(CommonView.class).to(CommonViewImpl.class);
        bind(EventBus.class).to(SimpleEventBus.class);
    }
}
