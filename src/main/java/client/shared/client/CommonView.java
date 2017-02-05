package client.shared.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;

public interface CommonView extends AcceptsOneWidget {

    interface Presenter {
        AcceptsOneWidget getCommonView();
    }
}
