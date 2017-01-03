package client.main_module.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingMessageIntfAsync {
    void getGreeting(String locale, AsyncCallback<String> async);
}
