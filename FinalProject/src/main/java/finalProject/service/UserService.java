package finalProject.service;

import finalProject.model.User;
import java.util.List;

public interface UserService {
	void add(User user);
	User findByLogin(String login);
	void update(User user);
	void delete(User user);
	void deleteById(Integer id);
	List<User> getAll();
}