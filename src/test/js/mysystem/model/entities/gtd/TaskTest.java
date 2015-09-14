package js.mysystem.model.entities.gtd;

import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaskTest {

	static SessionFactory factory;
	
	
	@Test
	public void addTaskTest() {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Task task = new Task();
			task.setId(1);
			task.setCaption("Hallo");
			session.save(task);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}


	}
	@Test
	public void addProjectTest() {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			Project project = new Project();
			project.setId(1);
			project.setCaption("Hallo");
			session.save(project);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}


	}

	
	
	@Before
	public void setupRoutine() {
		System.out.println("before each test");
	}
	@After
	public void cleanUpRoutine() {
		System.out.println("after each test");
	}
	@BeforeClass
	public static void setupRoutineClass() {
		System.out.println("before each class");
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder
				.build());

	}
	@AfterClass
	public static void cleanUpRoutineClass() {
		System.out.println("after each class");
		factory.close();
	}

}
