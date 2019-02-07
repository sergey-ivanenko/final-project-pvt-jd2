package finalProject.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public abstract class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private Integer userId;
	
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	
	@Column(name = "login", nullable = false, length = 30)
	private String login;
	
	@Column(name = "password", nullable = false, length = 30)
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "requester")
	private List<Request> requests;

	public User(String name, String login, String password) {
		this.name = name;
		this.login = login;
		this.password = password;
	}
	
	public boolean isEnter(String login, String password) {
		return true;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + "id = " + userId + ", name = " 
											   + name + ", login = " + login 
											   + ", password = " + password;
	}
}
