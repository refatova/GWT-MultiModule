package client.shared.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Saniye on 28.12.16.
 */
public class Shared implements EntryPoint {
    public void onModuleLoad() {
        CommonViewImpl commonView=new CommonViewImpl();
        RootPanel.get().add(commonView);

    }
}
