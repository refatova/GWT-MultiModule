package server.hello_module;

import client.hello_module.client.LoginServiceIntf;
import client.hello_module.client.UserNotFoundException;
import client.shared.client.HibernateUtil;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import javax.servlet.http.Cookie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


/**
 * Created by Saniye on 21.09.16.
 */
public class LoginServiceIntfImpl extends RemoteServiceServlet implements LoginServiceIntf {

    final static Logger log = LogManager.getLogger(LoginServiceIntfImpl.class.getName());

    @Override
    public void login(String login, String password, String locale) {
        log.info("Server received login_module: " + login);
        String username = findUser(login, password);
        if (username == null) throw new UserNotFoundException();
        else {
            Cookie cookie = null;
            try {
                cookie = new Cookie("logged_user", URLEncoder.encode(username, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            cookie.setPath("/");
            getThreadLocalResponse().addCookie(cookie);
        }
    }

    protected String findUser(String login, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Account where login= :login and password= HASH('SHA256', STRINGTOUTF8(CONCAT(:password,sault)), 1000)";
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        query.setParameter("password", password);
        List<Account> list = query.list();
        if (list.isEmpty()) {
            log.info("User is not found");
            return null ;
        } else {
            String personName = list.get(0).getName();
            log.info("User with name {} was found", personName);
            return personName;
        }

    }
}