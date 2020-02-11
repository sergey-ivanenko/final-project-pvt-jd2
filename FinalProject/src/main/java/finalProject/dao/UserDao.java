package finalProject.dao;

import finalProject.model.User;
import java.util.List;

public interface UserDao {
	void add(User user);
	//User findUser(String login, String password);
	User findByLogin(String login);
	void update(User user);
	void delete(User user);
	void deleteById(Integer id);
	List<User> getAll();
}