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
 * ProjectModuleFunc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "project_module_func", catalog = "companymanager")
public class ProjectModuleFunc extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private ProductModule productModule;
	private Datastatus datastatus;
	private String name;
	private String memo;
	private Timestamp createDate;
	private Set<Auth> auths = new HashSet<Auth>(0);

	// Constructors

	/** default constructor */
	public ProjectModuleFunc() {
	}

	/** full constructor */
	public ProjectModuleFunc(User user, ProductModule productModule,
			Datastatus datastatus, String name, String memo,
			Timestamp createDate, Set<Auth> auths) {
		this.user = user;
		this.productModule = productModule;
		this.datastatus = datastatus;
		this.name = name;
		this.memo = memo;
		this.createDate = createDate;
		this.auths = auths;
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
	@JoinColumn(name = "module_id")
	public ProductModule getProductModule() {
		return this.productModule;
	}

	public void setProductModule(ProductModule productModule) {
		this.productModule = productModule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DataStatus")
	public Datastatus getDatastatus() {
		return this.datastatus;
	}

	public void setDatastatus(Datastatus datastatus) {
		this.datastatus = datastatus;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projectModuleFunc")
	public Set<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(Set<Auth> auths) {
		this.auths = auths;
	}

}