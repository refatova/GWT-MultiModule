package client.main_module.client.activity;

import client.main_module.client.Injector;
import client.shared.client.ClientFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import client.main_module.client.place.HomePlace;
import client.main_module.client.ui.HomePageView;

/**
 * Created by Saniye on 27.10.16.
 */
public class HomeActivity extends AbstractActivity implements HomePageView.Presenter {
    private ClientFactory clientFactory;
    final Injector injector;
    private String message;
    private HomePageView homePageView;

    public HomeActivity(HomePlace place, ClientFactory clientFactory) {
        this.message = place.getGreetingMessage();
        this.clientFactory = clientFactory;
        this.injector = Injector.INSTANCE;
        this.homePageView=injector.gethomePageView();
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        homePageView.setExitButtonText();
        homePageView.setGreetingMessage(message);
        homePageView.setPresenter(this);
        containerWidget.setWidget(homePageView.asWidget());
    }

    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

}
