package finalProject.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false, unique = true)
	private Integer roleId;
	
	@Column(name = "name", length = 30)
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public Role() {
	}

	public Integer getId() {
		return roleId;
	}

	public void setId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return roleName;
	}

	public void setName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role: " + "roleId = " + roleId + ", roleName = " + roleName + ", users = " + users;
	}
}
