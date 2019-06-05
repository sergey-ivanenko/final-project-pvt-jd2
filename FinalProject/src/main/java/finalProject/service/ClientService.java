package finalProject.service;

import finalProject.dao.ClientDao;
import finalProject.model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends UserAbstractService<Client, ClientDao>{
	
	public ClientService(ClientDao clientDao) {
		super(clientDao);
	}
}