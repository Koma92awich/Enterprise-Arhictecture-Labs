package cs544.exercise_01;

import java.util.Date;
import java.util.List;

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

	// Hibernate placeholders
	static Session session = null;
	static Transaction tx = null;

	public static void main(String[] args) {

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			storeBooks();
			retrieveBooks();
			retrieveChangeDelete();
			retrieveBooks();
			
			

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

	public static void storeBooks() {
		// Create new instance of Book and set values
		Book book1 = new Book("Enterprise Architecture", "123-456-789", "Komakech", 2000.0, new Date());
		Book book2 = new Book("Java Beginners", "123-456-789", "Gideon", 45000.0,new Date());
		Book book3 = new Book("Software design principles", "123-456-789", "Philip", 15000.0,new Date());

		// save the Book
		session.persist(book1);
		session.persist(book2);
		session.persist(book3);

	}

	public static void retrieveBooks() {
		// get a list of Books
		@SuppressWarnings("unchecked")
		List<Book> listBook = session.createQuery("from Book").list();

		listBook.forEach(x -> System.out.println(x));

	}

	public static void retrieveChangeDelete() {

		@SuppressWarnings("unchecked")
		
		//change title and price of a book
		Book rename = (Book) session.get(Book.class, 1L);
		rename.setTitle("JAVA PERSISTANCE");
		rename.setPrice(600.0);
		session.persist(rename);

		//Delete a book different from the just updated one
	   Book toDelete = (Book)session.get(Book.class,2L);
	   session.delete(toDelete);

	}

}
