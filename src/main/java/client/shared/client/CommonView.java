package client.shared.client;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by Saniie on 12.01.17.
 */
public interface CommonView extends AcceptsOneWidget {


    public interface Presenter {
        AcceptsOneWidget getCommonView();
    }
}
