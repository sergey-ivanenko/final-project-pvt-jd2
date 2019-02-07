package finalProject.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users", catalog = "labour_system")
public class Admin extends User {	
	
	public Admin(String name, String login, String password) {
		super(name, login, password);
	}	
}