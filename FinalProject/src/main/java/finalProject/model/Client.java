package finalProject.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users", catalog = "labour_system")
public class Client extends User {	
	public Client(String name, String login, String password) {
		super(name, login, password);
	}
	
	public void takeResult(Request request) {
		
	}
}
