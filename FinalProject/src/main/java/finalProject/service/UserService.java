package finalProject.service;

import finalProject.model.User;
import java.util.List;

public interface UserService<T extends User> {
	void add(T user);
	T findUser(String login, String password);
	void update(T user);
	void delete(T user);
	List<T> getAll();
}
