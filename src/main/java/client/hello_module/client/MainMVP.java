package client.hello_module.client;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import client.hello_module.client.place.LoginPlace;


/**
 * Created by Saniye on 27.10.16.
 */
public class MainMVP implements EntryPoint {

    private Place defaultPlace = new LoginPlace();

    @Override
    public void onModuleLoad() {
        SimplePanel appWidget = new SimplePanel();
        ClientFactory clientFactory = GWT.create(ClientFactoryImpl.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);
        RootPanel.get().clear();
        RootPanel.get().add(appWidget);
//        RootPanel.get("content").clear();
//        RootPanel.get("content").add(appWidget);

        historyHandler.handleCurrentHistory();
    }
}
