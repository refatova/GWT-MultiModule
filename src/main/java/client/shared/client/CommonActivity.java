package client.shared.client;


//import client.hello_module.client.place.LoginPlace;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


/**
 * Created by Saniie on 20.01.17.
 */
public class CommonActivity  extends AbstractActivity implements CommonView.Presenter{
    private ClientFactory clientFactory;
//    private final Injector injector;
    CommonView commonView=new CommonViewImpl();

    public CommonActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
//        this.injector = Injector.INSTANCE;
//        this.commonView=injector.getCommonView();
    }

    @Override
    public AcceptsOneWidget getCommonView() {
        return commonView;
    }

//    @Override
//    public void goTo(Place place) {
//        clientFactory.getPlaceController().goTo(place);
//    }

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        commonView.setPresenter(this);
//        commonView.setWidget();
//    goTo(new LoginPlace());
    }
}
