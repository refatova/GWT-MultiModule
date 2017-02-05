package client.hello_module.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceIntfAsync {
    void login(String username, String password,String locale, AsyncCallback<Void> async);

}
