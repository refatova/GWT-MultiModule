package client.hello_module.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by Saniye on 27.10.16.
 */
public interface LoginPageView extends IsWidget, AcceptsOneWidget {

    void setLoginButtonText();

    void setNameFieldLabel();

    void setPasswordFieldLabel();

    void setErrorMessage(String messaage);

    void setPresenter(Presenter presenter);

    void setLoginButtonEnable(boolean flag);

    void cleanLoginField();

    void cleanPasswordField();

    void cleanErrorMessage();


    public interface Presenter {
//        void goTo(Place place);
        void sendUserToServer(String login, String password);
//        AcceptsOneWidget getLoginPageView();
    }


}
