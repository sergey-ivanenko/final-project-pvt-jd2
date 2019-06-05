package finalProject.dao;

import finalProject.model.User;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserAbstractDao<T extends User> implements UserDao<T> {

	@Autowired
	//private SessionFactory sessionFactory;
	private EntityManagerFactory entityManagerFactory;

	private final Class<T> persistentClass;

	public UserAbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];

		/*ParameterizedType genericSuperclass = (ParameterizedType) getClass()
             .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
             .getActualTypeArguments()[0];*/
	}

	/*public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}*/

	@Override
	public void add(T user) {
		/*Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void update(T user) {
		/*Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public T findUser(String login, String password) {
		/*Session session = sessionFactory.openSession();
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
        return entity;*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		String entityName = persistentClass.getSimpleName();
		String hql = String.format("FROM %s %s WHERE %s.login = :login AND %s.password = :password",
				entityName, entityName.toLowerCase(), entityName.toLowerCase(),
				entityName.toLowerCase());
		System.out.println(hql);
		Query query = entityManager.createQuery(hql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		if (!query.getResultList().isEmpty()) {
			T entity = (T) query.getResultList().get(0);
			entityManager.getTransaction().commit();
			entityManager.close();
			return entity;
		}
		entityManager.close();
		return null;
	}

	@Override
	public void delete(T user) {
		/*Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<T> getAll() {
		/*Session session = sessionFactory.openSession();
        session.beginTransaction();
        String entityName = persistentClass.getSimpleName();
        List<T> list = (List<T>) session.createQuery("FROM " + entityName).getResultList();
        session.getTransaction().commit();
        session.close();
        return list;*/
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		String entityName = persistentClass.getSimpleName();
		List<T> list = entityManager.createQuery("FROM " + entityName).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return list;
	}
}
