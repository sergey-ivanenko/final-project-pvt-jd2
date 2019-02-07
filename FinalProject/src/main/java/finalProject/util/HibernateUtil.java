package finalProject.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml            
            Configuration configuration = new Configuration().configure();
			//configuration.addResource("hibernate.cfg.xml");
			configuration.addAnnotatedClass(finalProject.model.Admin.class);
			configuration.addAnnotatedClass(finalProject.model.User.class);
			configuration.addAnnotatedClass(finalProject.model.Client.class);
			configuration.addAnnotatedClass(finalProject.model.Request.class);
            return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
                                                    .applySettings(configuration.getProperties())
                                                    .build());
            
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}