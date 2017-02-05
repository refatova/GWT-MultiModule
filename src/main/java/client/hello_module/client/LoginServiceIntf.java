package client.hello_module.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginServiceIntf extends RemoteService {
    void login(String username, String password, String locale) throws Exception;
}
