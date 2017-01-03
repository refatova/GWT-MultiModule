package server.main_module;

import client.main_module.client.GreetingMessageIntf;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Saniye on 22.11.16.
 */
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingMessageIntf{

    static final String MORNING_MESSAGE = "morningMessage";
    static final String DAY_MESSAGE = "dayMessage";
    static final String EVENING_MESSAGE = "eveningMessage";
    static final String NIGHT_MESSAGE = "nightMessage";
    static final String LOCALISATION_BUNDLE = "bundle.MyBundle";
    final static Logger log = LogManager.getLogger(GreetingServiceImpl.class.getName());



    @Override
    public String getGreeting(String locale) {
        Locale browserLocal = new Locale(locale);
        Locale.setDefault(browserLocal);
        String messageCode = getMessageForCurrentTime();
        ResourceBundle labels = ResourceBundle.getBundle(LOCALISATION_BUNDLE, browserLocal);
        return labels.getString(messageCode);

    }


    protected static String choseGreetingMessage(int hours) {
        String str;
        if (hours >= 6 && hours < 9) {
            str = MORNING_MESSAGE;
        } else if (hours >= 9 && hours < 19) {
            str = DAY_MESSAGE;
        } else if (hours >= 19 && hours < 23) {
            str = EVENING_MESSAGE;
        } else {
            str = NIGHT_MESSAGE;
        }
        log.log(Level.TRACE, "Message \"{}\" will be printed", str);
        return str;
    }

    protected String getMessageForCurrentTime() {
        LocalDateTime today = LocalDateTime.now();
        int hour = today.getHour();
        return choseGreetingMessage(hour);
    }
}