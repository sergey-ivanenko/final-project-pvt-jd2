package finalProject.dao;

import finalProject.model.Request;
import java.util.List;

public interface RequestDao {
	void add(Request request);
	Request findRequest(int id);
	void update(Request request);
	void delete(Request request);
	List<Request> getAll();
}
