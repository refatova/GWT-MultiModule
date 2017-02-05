package client.main_module.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("home")
public interface GreetingMessageIntf extends RemoteService {

    String getGreeting(String locale);
}
