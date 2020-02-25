package cs544.exercise_01;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import cs544.exercise_01.domain.Book;







public class AppBook {

	private static final SessionFactory sessionFactory;

    private static final ServiceRegistry serviceRegistry;

	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static void main(String[] args) {
		 // Hibernate placeholders
        Session session = null;
        Transaction tx = null;
        
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Create new instance of Car and set values in it
            Book book1 = new Book("Enterprise Architecture", "123-456-789", "Komakech", 2000.0);
            Book book2 = new Book("Java Beginners", "123-456-789", "Komakech", 45000.0);
            Book book3 = new Book("Software design principles", "123-456-789", "Philip",15000.0);
            
            // save the Book
            session.persist(book1);
            session.persist(book2);
            session.persist(book3);
           

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        
        
        
        
	}

}
