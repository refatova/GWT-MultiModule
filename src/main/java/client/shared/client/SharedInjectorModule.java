package client.shared.client;

import com.google.gwt.inject.client.AbstractGinModule;

public class SharedInjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(CommonView.class).to(CommonViewImpl.class);

    }
}
