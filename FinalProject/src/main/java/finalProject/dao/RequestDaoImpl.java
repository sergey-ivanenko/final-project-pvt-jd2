package finalProject.dao;

import finalProject.model.Request;
import finalProject.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class RequestDaoImpl implements RequestDao {

	@Override
	public void add(Request request) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(request);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Request findRequest(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Request request WHERE request.requestId = :id");
		query.setParameter("id", id);
		Request request = (Request) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return request;
	}

	@Override
	public void update(Request request) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(request);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Request request) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(request);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Request> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Request> list = (List<Request>) session.createQuery("FROM Request").getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}