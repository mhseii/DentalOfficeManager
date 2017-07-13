package br.com.dentalofficemanager.user.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
	@NamedQuery(name = "Role.findAllByIds", query = "SELECT r FROM Role r where r.id in (:ids)")
})
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String role;
	private String displayName;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
