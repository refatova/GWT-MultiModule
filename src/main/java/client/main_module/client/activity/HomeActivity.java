package client.main_module.client.activity;


import client.hello_module.client.ClientFactory;
import client.hello_module.client.Injector;
import client.shared.client.CommonView;
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
    private CommonView commonView;



    public HomeActivity(HomePlace place, ClientFactory clientFactory) {
        this.message = place.getGreetingMessage();
        this.clientFactory = clientFactory;
        this.injector = Injector.INSTANCE;
        this.homePageView=injector.gethomePageView();
        this.commonView=injector.getCommonView();
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        HomePageView homePageView = injector.gethomePageView();
        homePageView.setExitButtonText();
        homePageView.setGreetingMessage(message);
        homePageView.setPresenter(this);
        commonView.setWidget(homePageView);
//        containerWidget.setWidget(homePageView.asWidget());
    }

    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

//    @Override
//    public AcceptsOneWidget getHomePageView() {
//        return (AcceptsOneWidget) homePageView;
//    }


}
