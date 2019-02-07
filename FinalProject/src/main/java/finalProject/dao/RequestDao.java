package finalProject.dao;

import finalProject.model.Client;
import finalProject.model.Request;
import java.util.List;

public interface RequestDao {
	void add();
	void load();
	Request findRequest(Client client);
	void delete(int id);
	List<Request> getAll();
}
