package client.upload_module.client;

import client.shared.client.GWTHelloConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Logger;

/**
 * Created by Saniye on 03.01.17.
 */
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
        removeTableRows();
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
                table.setHTML(1, 0, event.getResults());
            }
        });
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


    public void removeTableRows() {
        int numRows = table.getRowCount();
        if (numRows >= 1) {
            table.removeRow(numRows - 1);
            table.getFlexCellFormatter().setRowSpan(0, 1, numRows - 1);
        }
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