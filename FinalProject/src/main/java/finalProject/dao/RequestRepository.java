package finalProject.dao;

import finalProject.model.Client;
import finalProject.model.Request;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
	List<Request> findByRequester(Client client);
	void deleteById(int id);
}