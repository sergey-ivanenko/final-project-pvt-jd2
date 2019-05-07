package finalProject.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin", catalog = "labour_system")
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {
    
    public Admin() {
    }

    public Admin(String name, String login, String password) {
        super(name, login, password);
    }    
}
