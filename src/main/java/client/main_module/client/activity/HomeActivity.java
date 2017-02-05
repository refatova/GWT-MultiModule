package client.main_module.client.activity;

import client.main_module.client.Injector;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import client.main_module.client.place.HomePlace;
import client.main_module.client.ui.HomePageView;

public class HomeActivity extends AbstractActivity implements HomePageView.Presenter {
    final Injector injector;
    private String message;
    private HomePageView homePageView;

    public HomeActivity(HomePlace place) {
        this.message = place.getGreetingMessage();
        this.injector = Injector.INSTANCE;
        this.homePageView=injector.gethomePageView();
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        homePageView.setExitButtonText();
        homePageView.setGreetingMessage(message);
        containerWidget.setWidget(homePageView.asWidget());
    }

    @Override
    public void goTo(Place place) {
    }

}
