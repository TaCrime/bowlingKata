package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by ptatyana on 08.01.14.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            //creates the session factory from hibernate.cfg.xml
            Locale.setDefault(Locale.ENGLISH);
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
