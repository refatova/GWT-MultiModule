package client.main_module.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by Saniye on 22.11.16.
 */

@RemoteServiceRelativePath("home")
public interface GreetingMessageIntf extends RemoteService {

    String getGreeting(String locale);
}
