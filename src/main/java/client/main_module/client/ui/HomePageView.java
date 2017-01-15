package client.main_module.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by Saniye on 27.10.16.
 */

public interface HomePageView extends IsWidget {


    void setGreetingMessage(String helloString);

    void setPresenter(Presenter presenter);

    void setExitButtonText();

    public interface Presenter {
        void goTo(Place place);
//        AcceptsOneWidget getHomePageView();

//

    }
}

