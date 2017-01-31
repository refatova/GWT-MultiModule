package client.shared.client;

import client.hello_module.client.place.LoginPlace;
import client.hello_module.client.ui.LoginPageViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Saniie on 14.01.17.
 */
public class CommonViewImpl extends Composite implements CommonView {
    private ClientFactory clientFactory;
    private Presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter=presenter;
    }

//    @Override
//    public AcceptsOneWidget getCommonView() {
//        return null;
//    }

//    @Override
//    public void goTo(Place place) {
//        clientFactory.getPlaceController().goTo(place);
//    }

    interface ComUiBinder extends UiBinder<HTMLPanel, CommonViewImpl> {}
    private static ComUiBinder ourUiBinder = GWT.create(ComUiBinder.class);

    public CommonViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
//        this.setWidget(new LoginPageViewImpl());
//        presenter.goTo(new LoginPlace());
    }

    @Override
    public void setWidget(IsWidget isWidget) {
        content.setWidget(isWidget);
    }

    @UiField
    AcceptsOneWidget content;


}
