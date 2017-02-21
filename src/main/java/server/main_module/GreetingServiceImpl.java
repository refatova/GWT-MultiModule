package server.main_module;

import client.main_module.client.GreetingMessageIntf;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;


public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingMessageIntf {

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        ResourceBundle labels = ResourceBundle.getBundle(LOCALISATION_BUNDLE, browserLocal);
        return labels.getString(messageCode)+" "+name;

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
