package org.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.dao.BaseVO;

/**
 * RoleAuth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role_auth", catalog = "companymanager")
public class RoleAuth extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Role role;
	private Datastatus datastatus;
	private Auth auth;
	private String name;
	private String memo;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public RoleAuth() {
	}

	/** full constructor */
	public RoleAuth(User user, Role role, Datastatus datastatus, Auth auth,
			String name, String memo, Timestamp createDate) {
		this.user = user;
		this.role = role;
		this.datastatus = datastatus;
		this.auth = auth;
		this.name = name;
		this.memo = memo;
		this.createDate = createDate;
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
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
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
	@JoinColumn(name = "auth_id")
	public Auth getAuth() {
		return this.auth;
	}

	public void setAuth(Auth auth) {
		this.auth = auth;
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

}