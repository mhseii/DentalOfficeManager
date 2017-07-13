package br.com.dentalofficemanager.user.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.dentalofficemanager.common.model.BaseEntity;

@Entity
@Table(name = "USER_GROUP")
public class UserGroup extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -7398079586077425798L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long groupCode;
	@Enumerated(EnumType.STRING)
	private UserGroupEnum groupName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userGroup")
	@JsonIgnore
	private Set<User> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGroupCode() {
		return UserGroupEnum.getGroupCode(this.groupCode);
	}

	private void setGroupCode(UserGroupEnum groupCode) {
		this.groupCode = UserGroupEnum.getGroupCode(groupCode);
	}

	public UserGroupEnum getGroupName() {
		return groupName;
	}

	public void setGroupName(UserGroupEnum userGroup) {
		this.groupName = userGroup;
		this.setGroupCode(userGroup);
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
