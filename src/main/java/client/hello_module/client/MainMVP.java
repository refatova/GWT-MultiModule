package client.hello_module.client;

import client.shared.client.CommonView;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import client.hello_module.client.place.LoginPlace;
import com.google.gwt.user.client.ui.Widget;

public class MainMVP implements EntryPoint {

    private Place defaultPlace = new LoginPlace();
    private CommonView commonView;
    private final Injector injector=Injector.INSTANCE;

    @Override
    public void onModuleLoad() {
        commonView=injector.getCommonView();
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
        commonView.setWidget(appWidget);
        RootPanel.get().clear();
        RootPanel.get().add((Widget) commonView);
        historyHandler.handleCurrentHistory();
    }
}
