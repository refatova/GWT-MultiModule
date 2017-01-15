package client.shared.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Saniie on 14.01.17.
 */
public class CommonViewImpl extends Composite implements CommonView {
    interface ComUiBinder extends UiBinder<HTMLPanel, CommonViewImpl> {}
    private static ComUiBinder ourUiBinder = GWT.create(ComUiBinder.class);

    public CommonViewImpl() {
//        initWidget(ourUiBinder.createAndBindUi(this));
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
    }

    @Override
    public void setWidget(IsWidget isWidget) {
        content.setWidget(isWidget);
    }

    @UiField
    AcceptsOneWidget content;
}
