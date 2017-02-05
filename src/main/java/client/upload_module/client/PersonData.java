package client.upload_module.client;

import com.google.gwt.core.client.JavaScriptObject;

public class PersonData extends JavaScriptObject {
    protected PersonData() {}

    public final native String getName() /*-{ return this.name; }-*/;
    public final native String getBirthDay() /*-{ return this.birthDay; }-*/ ;
    public final native String getEmail()  /*-{return this.email;}-*/ ;



}
