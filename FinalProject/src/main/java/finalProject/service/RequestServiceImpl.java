package finalProject.service;

import finalProject.dao.RequestRepository;
import finalProject.model.Request;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class RequestServiceImpl implements RequestService {
	
	private final RequestRepository repository;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Request> getAll() {
		return repository.findAll();
	}	
}
