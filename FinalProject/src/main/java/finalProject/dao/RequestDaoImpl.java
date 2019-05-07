package finalProject.dao;

import finalProject.model.Request;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class RequestDaoImpl implements RequestDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Request request) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Request findRequest(int id) {
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(request);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Request request) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(request);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Request> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Request> list = (List<Request>) session.createQuery("FROM Request").getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
