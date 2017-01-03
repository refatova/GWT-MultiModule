package server.hello_module;


import client.hello_module.client.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

/**
 * Created by Saniye on 28.09.16.
 */


public class LoginPageTest extends Assert {

    @Test
    public void findUserTest() {
        LoginServiceIntfImpl m = new LoginServiceIntfImpl();
        assertTrue("Иван".equals(m.findUser("ivan", "secret")));
    }

    @Test
    public void findInvalidUser() {
        LoginServiceIntfImpl m = new LoginServiceIntfImpl();
        assertTrue((m.findUser("test", "test"))==null);
    }

    @Test(expected = UserNotFoundException.class)
    public void loginServiceTest() {
        LoginServiceIntfImpl serviceMock = Mockito.spy(new LoginServiceIntfImpl());
        doReturn(null).when(serviceMock).findUser("not_existed_user", "not_existed_user");
        serviceMock.login("not_existed_user", "not_existed_user", "ru");
    }
}
