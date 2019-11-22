package finalProject.dao;

import finalProject.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public UserDaoImpl() {}

	@Override
	public void add(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public void update(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
    public User findByLogin(String login) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String hql = "FROM User user WHERE user.login = :login";
        System.out.println(hql);
        Query query = entityManager.createQuery(hql);
        query.setParameter("login", login);
        if (!query.getResultList().isEmpty()) {
            User entity = (User) query.getResultList().get(0);
            entityManager.getTransaction().commit();
            entityManager.close();
            return entity;
        }
        entityManager.close();
        return null;
    }
	
	@Override
	public void delete(User user) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<User> getAll() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<User> list = entityManager.createQuery("FROM User").getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return list;
	}
}