package finalProject.service;

import finalProject.dao.RequestDao;
import finalProject.dao.RequestRepository;
import finalProject.model.Client;
import finalProject.model.Request;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class RequestServiceImpl implements RequestService {
	
	private final RequestRepository repository;
	@Autowired
	private RequestDao requestDao;

	@Autowired
	public RequestServiceImpl(RequestRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void add(Request request) {
		repository.save(request);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Request findRequest(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void update(Request request) {
		repository.save(request);
	}

	@Override
	public void delete(Request request) {
		repository.delete(request);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Request> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Request> findByRequester(Client client) {
		return repository.findByRequester(client);
	}
}
