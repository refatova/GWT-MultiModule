package client.hello_module.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;


public class ClientFactoryImpl implements ClientFactory {
    private static final EventBus eventBus = Injector.INSTANCE.getEventBus();
    private static final PlaceController placeController = new PlaceController(eventBus);

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }


}
