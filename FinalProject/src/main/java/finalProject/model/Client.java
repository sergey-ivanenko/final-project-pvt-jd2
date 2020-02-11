package finalProject.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "client", catalog = "labour_system")
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User {
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "requester")
    private List<Request> requests = new ArrayList<>(0);

    public Client() {
    }

    public Client(String name, String login, String password) {
        super(name, login, password);
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public void takeResult(Request request) {

    }

    @Override
    public String toString() {
        return super.toString() + ", requests: " + requests;
    }
}
