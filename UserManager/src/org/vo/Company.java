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
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "company", catalog = "companymanager")
public class Company extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Datastatus datastatus;
	private User user;
	private String name;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private String url;
	private Double orderNo;
	private Integer parentId;
	private Set<User> users = new HashSet<User>(0);
	private Set<Role> roles = new HashSet<Role>(0);

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(Datastatus datastatus, User user, String name,
			Timestamp createDate, Timestamp modifyDate, String url,
			Double orderNo, Integer parentId, Set<User> users, Set<Role> roles) {
		this.datastatus = datastatus;
		this.user = user;
		this.name = name;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.url = url;
		this.orderNo = orderNo;
		this.parentId = parentId;
		this.users = users;
		this.roles = roles;
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
	@JoinColumn(name = "DataStatus")
	public Datastatus getDatastatus() {
		return this.datastatus;
	}

	public void setDatastatus(Datastatus datastatus) {
		this.datastatus = datastatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Name", length = 4000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CreateDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "ModifyDate", length = 19)
	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "URL", length = 4000)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "OrderNo", precision = 22, scale = 0)
	public Double getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Double orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name = "parentId")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}