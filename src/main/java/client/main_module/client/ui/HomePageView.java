package client.main_module.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface HomePageView extends IsWidget {


    void setGreetingMessage(String helloString);

    void setExitButtonText();

    interface Presenter {
        void goTo(Place place);
    }
}

