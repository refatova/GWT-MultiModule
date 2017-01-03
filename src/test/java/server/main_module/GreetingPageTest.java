package server.main_module;

import org.junit.Assert;
import org.junit.Test;
import server.main_module.GreetingServiceImpl;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Saniye on 28.09.16.
 */


public class GreetingPageTest extends Assert {

    static final String MORNING_MESSAGE = "morningMessage";
    static final String DAY_MESSAGE = "dayMessage";
    static final String EVENING_MESSAGE = "eveningMessage";
    static final String NIGHT_MESSAGE = "nightMessage";
    static final String LOCALISATION_BUNDLE = "bundle.MyBundle";

    @Test
    public void defaultLocaleTest() {
        Locale china = new Locale("zh");
        Locale.setDefault(china);
        ResourceBundle labels = ResourceBundle.getBundle(LOCALISATION_BUNDLE, china);
        assertEquals("Good morning", labels.getString(MORNING_MESSAGE));
        assertEquals("Good day", labels.getString(DAY_MESSAGE));
        assertEquals("Good evening", labels.getString(EVENING_MESSAGE));
        assertEquals("Good night", labels.getString(NIGHT_MESSAGE));
    }


    @Test
    public void morningGreetingTest() {
        GreetingServiceImpl greetingMessageIntf=new GreetingServiceImpl();
        assertEquals(MORNING_MESSAGE, greetingMessageIntf.choseGreetingMessage(6));
        assertFalse(MORNING_MESSAGE.equals(greetingMessageIntf.choseGreetingMessage(9)));
    }

    @Test
    public void dayGreetingTest() {
        GreetingServiceImpl greetingMessageIntf=new GreetingServiceImpl();
        assertEquals(DAY_MESSAGE, greetingMessageIntf.choseGreetingMessage(9));
        assertFalse(DAY_MESSAGE.equals(greetingMessageIntf.choseGreetingMessage(19)));
    }

    @Test
    public void eveningGreetingTest() {
        GreetingServiceImpl greetingMessageIntf=new GreetingServiceImpl();
        assertEquals(EVENING_MESSAGE, greetingMessageIntf.choseGreetingMessage(19));
        assertFalse(EVENING_MESSAGE.equals(greetingMessageIntf.choseGreetingMessage(23)));
    }

    @Test
    public void nightGreetingTest() {
        GreetingServiceImpl greetingMessageIntf=new GreetingServiceImpl();
        assertEquals(NIGHT_MESSAGE, greetingMessageIntf.choseGreetingMessage(23));
        assertTrue(NIGHT_MESSAGE.equals(greetingMessageIntf.choseGreetingMessage(5)));
        assertFalse("6 a.m isn't included to night time", NIGHT_MESSAGE.equals(greetingMessageIntf.choseGreetingMessage(6)));
    }

//    @Test
//    public void loginServiceTestPositive(){
//        LoginServiceIntfImpl serviceMock = Mockito.spy(new LoginServiceIntfImpl());
//        doReturn("Keanu").when(serviceMock).findUser("user", "user");
//        doReturn(DAY_MESSAGE).when(serviceMock).get();
//        assertTrue("Добрий день, Keanu".equals(serviceMock.login("user", "user","uk")));
//    }


}
