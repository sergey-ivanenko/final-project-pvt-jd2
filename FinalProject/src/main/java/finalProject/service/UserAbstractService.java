package finalProject.service;

import finalProject.dao.UserAbstractDao;
import finalProject.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public abstract class UserAbstractService<T extends User, D extends UserAbstractDao> implements UserService<T> {
	
	private final D dao;

	@Autowired
	public UserAbstractService(D dao) {
		this.dao = dao;
	}

	@Override
	public void add(T user) {
		dao.add(user);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public T findUser(String login, String password) {
		return (T) dao.findUser(login, password);
	}

	@Override
	public void update(T user) {
		dao.update(user);
	}

	@Override
	public void delete(T user) {
		dao.delete(user);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<T> getAll() {
		return dao.getAll();
	}
}
