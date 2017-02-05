package client.hello_module.client;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

public class UserNotFoundException extends RuntimeException implements IsSerializable, Serializable {

    public UserNotFoundException() {
    }
}
