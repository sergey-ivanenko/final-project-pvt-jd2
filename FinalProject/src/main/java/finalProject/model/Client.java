package finalProject.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "clients", catalog = "labour_system")
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User {
    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "requester")
    private Set<Request> requests = new HashSet<>(0);

    public Client() {
    }

    public Client(String name, String login, String password) {
        super(name, login, password);
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public void takeResult(Request request) {

    }

    @Override
    public String toString() {
        return super.toString() + ", requests: " + requests;
    }
}
