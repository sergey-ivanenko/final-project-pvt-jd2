package finalProject.dao;

import finalProject.model.User;
import java.util.List;

public interface UserDao<T extends User> {
	void add(T t);
	T findUser(String login, String password);
	void update(T t);
	void delete(T t);
	List<T> getAll();
}