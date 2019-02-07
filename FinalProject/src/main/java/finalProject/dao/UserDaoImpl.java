package finalProject.dao;

import finalProject.model.User;
import finalProject.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(User user) {
		
	}

	@Override
	public User findUser(String login, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		User user = (User)session.createQuery("FROM User user WHERE user.login = ?, user.password = ?")
			   .setParameter(0, login).setParameter(1, password).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public void delete(User user) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<User> getAll() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
