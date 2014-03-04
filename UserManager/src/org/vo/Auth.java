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
 * Auth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auth", catalog = "companymanager")
public class Auth extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private ProjectModuleFunc projectModuleFunc;
	private Datastatus datastatus;
	private ProductModule productModule;
	private Product product;
	private Productgroup productgroup;
	private Integer companyId;
	private String name;
	private String memo;
	private Timestamp createDate;
	private Set<RoleAuth> roleAuths = new HashSet<RoleAuth>(0);

	// Constructors

	/** default constructor */
	public Auth() {
	}

	/** full constructor */
	public Auth(User user, ProjectModuleFunc projectModuleFunc,
			Datastatus datastatus, ProductModule productModule,
			Product product, Productgroup productgroup, Integer companyId,
			String name, String memo, Timestamp createDate,
			Set<RoleAuth> roleAuths) {
		this.user = user;
		this.projectModuleFunc = projectModuleFunc;
		this.datastatus = datastatus;
		this.productModule = productModule;
		this.product = product;
		this.productgroup = productgroup;
		this.companyId = companyId;
		this.name = name;
		this.memo = memo;
		this.createDate = createDate;
		this.roleAuths = roleAuths;
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
	@JoinColumn(name = "Product_Module_func_id")
	public ProjectModuleFunc getProjectModuleFunc() {
		return this.projectModuleFunc;
	}

	public void setProjectModuleFunc(ProjectModuleFunc projectModuleFunc) {
		this.projectModuleFunc = projectModuleFunc;
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
	@JoinColumn(name = "Product_module")
	public ProductModule getProductModule() {
		return this.productModule;
	}

	public void setProductModule(ProductModule productModule) {
		this.productModule = productModule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Product_id")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductGroup_id")
	public Productgroup getProductgroup() {
		return this.productgroup;
	}

	public void setProductgroup(Productgroup productgroup) {
		this.productgroup = productgroup;
	}

	@Column(name = "company_id")
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "auth")
	public Set<RoleAuth> getRoleAuths() {
		return this.roleAuths;
	}

	public void setRoleAuths(Set<RoleAuth> roleAuths) {
		this.roleAuths = roleAuths;
	}

}