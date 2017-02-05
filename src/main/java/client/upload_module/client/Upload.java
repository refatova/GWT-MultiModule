package client.upload_module.client;


import client.shared.client.CommonView;
import client.shared.client.CommonViewImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Upload implements EntryPoint {
    private CommonView commonView;
    public void onModuleLoad() {
        commonView=new CommonViewImpl();
        LoadFilePageView loadFilePageView=new LoadFilePageViewImpl();
        RootPanel.get().clear();
        RootPanel.get().add((Widget) commonView);
        commonView.setWidget(loadFilePageView);
    }
}
