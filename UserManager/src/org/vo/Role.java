package org.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dao.BaseVO;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "companymanager")
public class Role extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Company company;
	private Datastatus datastatus;
	private Integer userId;
	private String name;
	private String memo;
	private Timestamp createDate;
	private Set<RoleAuth> roleAuths = new HashSet<RoleAuth>(0);
	private Set<User> users = new HashSet<User>(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(Company company, Datastatus datastatus, Integer userId,
			String name, String memo, Timestamp createDate,
			Set<RoleAuth> roleAuths, Set<User> users) {
		this.company = company;
		this.datastatus = datastatus;
		this.userId = userId;
		this.name = name;
		this.memo = memo;
		this.createDate = createDate;
		this.roleAuths = roleAuths;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DataStatus")
	public Datastatus getDatastatus() {
		return this.datastatus;
	}

	public void setDatastatus(Datastatus datastatus) {
		this.datastatus = datastatus;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "name", length = 4000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Memo", length = 4000)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "CreateDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<RoleAuth> getRoleAuths() {
		return this.roleAuths;
	}

	public void setRoleAuths(Set<RoleAuth> roleAuths) {
		this.roleAuths = roleAuths;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}