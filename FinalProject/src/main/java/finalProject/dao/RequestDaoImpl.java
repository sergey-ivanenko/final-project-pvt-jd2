package finalProject.dao;

import finalProject.model.Request;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestDaoImpl implements RequestDao {

    @Autowired
    //private SessionFactory sessionFactory;
	private EntityManagerFactory entityManagerFactory;

    @Override
    public void add(Request request) {
        /*Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();
        session.close();*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(request);
		entityManager.getTransaction().commit();
		entityManager.close();
    }

    @Override
    public Request findRequest(int id) {
        /*Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Request request WHERE request.requestId = :id");
        query.setParameter("id", id);
        Request request = (Request) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return request;*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Request request WHERE request.requestId = :id");
        query.setParameter("id", id);
		Request request = (Request) query.getSingleResult();
		entityManager.getTransaction().commit();
		entityManager.close();
		return request;
    }

    @Override
    public void update(Request request) {
        /*Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(request);
        session.getTransaction().commit();
        session.close();*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(request);
		entityManager.getTransaction().commit();
		entityManager.close();
    }

    @Override
    public void delete(Request request) {
        /*Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(request);
        session.getTransaction().commit();
        session.close();*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(request);
		entityManager.getTransaction().commit();
		entityManager.close();
    }

    @Override
    public List<Request> getAll() {
        /*Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Request> list = (List<Request>) session.createQuery("FROM Request").getResultList();
        session.getTransaction().commit();
        session.close();
        return list;*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Request> list = (List<Request>) entityManager.createQuery("FROM Request").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return list;
    }
}
