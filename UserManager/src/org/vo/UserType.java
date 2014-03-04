package org.vo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dao.BaseVO;

/**
 * UserType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_type", catalog = "companymanager")
public class UserType extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Datastatus datastatus;
	private String name;
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public UserType() {
	}

	/** full constructor */
	public UserType(Datastatus datastatus, String name, Set<User> users) {
		this.datastatus = datastatus;
		this.name = name;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DataStatus")
	public Datastatus getDatastatus() {
		return this.datastatus;
	}

	public void setDatastatus(Datastatus datastatus) {
		this.datastatus = datastatus;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userType")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}