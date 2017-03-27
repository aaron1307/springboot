package com.aaron.exer.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.JoinColumn;

/**
 * Bean class used to store admin user info, and maintain Hibernate table
 * "admin" Hibernate validation is is used here. Hibernate configuration file
 * located under /WEB-INF/Spring folder
 * 
 * @author Aaron C.
 * @version v0.1
 */
@Entity(name = "admin")
public class AdminUser implements Serializable {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = 4417532768155012143L;

	/**
	 * @Fields id : database unique id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * @Fields name : admin user account name
	 */
	@NotEmpty(message = "account is required")
	@Column(name = "name", length = 20)
	private String name;

	/**
	 * @Fields passwd : admin user account password
	 */
	@NotEmpty(message = "password is required")
	@Column(name = "passwd", length = 120)
	private String passwd;

	/**
	 * @Fields userRoles : foreign key, connects to column r_id of role table on
	 *         column u_id, many to one relationship
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "u_id") }, inverseJoinColumns = {
			@JoinColumn(name = "r_id") })
	private Set<Role> userRoles = new HashSet<Role>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AdminUser))
			return false;
		AdminUser other = (AdminUser) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

    @Override
    public String toString() {
        return "User [id=" + id + 
        		", name=" + name + "]";
    }

}
