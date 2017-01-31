package client.upload_module.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Created by Saniye on 03.01.17.
 */
public class Upload implements EntryPoint {
    public void onModuleLoad() {
        Window.alert("upload module");
        LoadFilePageView loadFilePageView=new LoadFilePageViewImpl();
        RootPanel.get("content").clear();
        RootPanel.get("content").add(loadFilePageView);
    }
}
