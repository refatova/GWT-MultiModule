package client.upload_module.client;

import client.shared.client.GWTHelloConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Logger;

public class LoadFilePageViewImpl extends Composite implements LoadFilePageView {
    interface LoadFileUiBinder extends UiBinder<Widget, LoadFilePageViewImpl> {
    }

    public LoadFilePageViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
        init();
        this.setCleanButtonText();
        this.setUploadButtonText();
        setTable();
    }

    private GWTHelloConstants constants = GWT.create(GWTHelloConstants.class);
    private static Logger logger = Logger.getLogger(LoadFilePageViewImpl.class.getName());
    private static LoadFileUiBinder ourUiBinder = GWT.create(LoadFileUiBinder.class);

    @UiField
    Button uploadButton;

    @UiField
    Button cleanButton;

    @UiField
    FileUpload fileUpload;

    @UiField
    FormPanel uploadFormPanel;

    @UiField
    FlexTable table;

    @UiHandler("uploadButton")
    void onClickUploadButton(ClickEvent clickEvent) {
        uploadFormPanel.submit();
    }

    @UiHandler("cleanButton")
    void onClickClearButton(ClickEvent clickEvent) {
        table.removeAllRows();
    }


    public void init() {
        uploadFormPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        uploadFormPanel.setMethod(FormPanel.METHOD_POST);
        uploadFormPanel.setAction("/upload");

        uploadFormPanel.addSubmitHandler(new FormPanel.SubmitHandler() {
            public void onSubmit(FormPanel.SubmitEvent event) {
                if (fileUpload.getFilename().isEmpty()) {
                    Window.alert("Please chose file");
                    event.cancel();
                }
            }
        });

        uploadFormPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                JsArray<PersonData> jsArray = JsonUtils.safeEval(event.getResults());
                updateTable(jsArray);
            }
        });
    }

    private void updateTable(JsArray<PersonData> persons) {
        for (int i = 0; i < persons.length(); i++) {
            table.setHTML(i + 1, 0, persons.get(i).getName());
            table.setHTML(i + 1, 1, persons.get(i).getBirthDay());
            table.setHTML(i + 1, 2, persons.get(i).getEmail());
        }
    }

    public void setTable() {
        table.setWidth("32em");
        table.setCellSpacing(5);
        table.setCellPadding(3);
        FlexTable.FlexCellFormatter cellFormatter = table.getFlexCellFormatter();
        cellFormatter.setHorizontalAlignment(
                0, 1, HasHorizontalAlignment.ALIGN_LEFT);
        cellFormatter.setColSpan(0, 0, 2);
    }

    @Override
    public void setUploadButtonText() {
        this.uploadButton.setText(constants.upload());
    }

    @Override
    public void setCleanButtonText() {
        this.cleanButton.setText(constants.clean());
    }


}