package finalProject.model;

import java.io.Serializable;
import java.util.Set;
//import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
@Table(name = "user", catalog = "labour_system")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer userId;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "login", nullable = false, length = 32)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;
	
	@Transient
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.EAGER/*, cascade = CascadeType.ALL*/)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), 
									inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

    public User() {
    }

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + "id = " + userId + ", name = "
                + name + ", login = " + login
                + ", password = " + password;
    }
}
