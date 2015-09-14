package js.mysystem.model.daos.gtd;

import java.util.List;

import js.mysystem.model.entities.gtd.Task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskDao {

	@Autowired
	SessionFactory sf;
	
	public void createTask() {
		Session session = sf.openSession();
		
		Task task = new Task();
		task.setCaption("new Task");
		session.save(task);
		
		session.close();
	}
	
	
	public List<Task> readTasks() {
		Session session = sf.openSession();
		
		List list = session.createQuery("FROM Task").list();
		
		session.close();
		
		return list;
	}
	
	public void updateTask(Task task) {
		Session session = sf.openSession();
		
		session.saveOrUpdate(task);
		
		session.close();
	}
	
	public void deleteTask(Task task) {
		Session session = sf.openSession();
		
		session.delete(task);
		
		session.close();
	}

	
}
