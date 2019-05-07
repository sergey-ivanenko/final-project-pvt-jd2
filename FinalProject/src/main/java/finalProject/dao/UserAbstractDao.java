package finalProject.dao;

import finalProject.model.User;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserAbstractDao<T extends User> implements UserDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public UserAbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

        /*ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
             .getActualTypeArguments()[0];*/
    }

    @Override
    public void add(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T findUser(String login, String password) {
        //System.out.println(this.getClass().getSimpleName());
        //System.out.println(persistentClass.getSimpleName());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String entityName = persistentClass.getSimpleName();
        String hql = String.format("FROM %s %s WHERE %s.login = :login AND %s.password = :password",
                entityName, entityName.toLowerCase(), entityName.toLowerCase(),
                entityName.toLowerCase());
        System.out.println(hql);
        Query query = session.createQuery(hql);
        query.setParameter("login", login);
        query.setParameter("password", password);
        T entity = (T) query.uniqueResult();

        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public void delete(T t) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<T> getAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String entityName = persistentClass.getSimpleName();
        List<T> list = (List<T>) session.createQuery("FROM " + entityName).getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
