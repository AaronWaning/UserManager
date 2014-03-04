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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "companymanager")
public class User extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserType userType;
	private Role role;
	private Company company;
	private Datastatus datastatus;
	private String name;
	private Timestamp createDate;
	private String password;
	private String username;
	private String email;
	private Set<ProductModule> productModules = new HashSet<ProductModule>(0);
	private Set<RoleAuth> roleAuths = new HashSet<RoleAuth>(0);
	private Set<ProjectModuleFunc> projectModuleFuncs = new HashSet<ProjectModuleFunc>(
			0);
	private Set<Product> products = new HashSet<Product>(0);
	private Set<Company> companies = new HashSet<Company>(0);
	private Set<Auth> auths = new HashSet<Auth>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(UserType userType, Role role, Company company,
			Datastatus datastatus, String name, Timestamp createDate,
			String password, String username, String email,
			Set<ProductModule> productModules, Set<RoleAuth> roleAuths,
			Set<ProjectModuleFunc> projectModuleFuncs, Set<Product> products,
			Set<Company> companies, Set<Auth> auths) {
		this.userType = userType;
		this.role = role;
		this.company = company;
		this.datastatus = datastatus;
		this.name = name;
		this.createDate = createDate;
		this.password = password;
		this.username = username;
		this.email = email;
		this.productModules = productModules;
		this.roleAuths = roleAuths;
		this.projectModuleFuncs = projectModuleFuncs;
		this.products = products;
		this.companies = companies;
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
	@JoinColumn(name = "type_id")
	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
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

	@Column(name = "Name", length = 20)
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

	@Column(name = "password", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "username", length = 30)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", length = 40)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ProductModule> getProductModules() {
		return this.productModules;
	}

	public void setProductModules(Set<ProductModule> productModules) {
		this.productModules = productModules;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<RoleAuth> getRoleAuths() {
		return this.roleAuths;
	}

	public void setRoleAuths(Set<RoleAuth> roleAuths) {
		this.roleAuths = roleAuths;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ProjectModuleFunc> getProjectModuleFuncs() {
		return this.projectModuleFuncs;
	}

	public void setProjectModuleFuncs(Set<ProjectModuleFunc> projectModuleFuncs) {
		this.projectModuleFuncs = projectModuleFuncs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(Set<Auth> auths) {
		this.auths = auths;
	}

	@Override
	public String toString() {
		return "User [auths=" + auths + ", companies=" + companies
				+ ", company=" + company + ", createDate=" + createDate
				+ ", datastatus=" + datastatus + ", email=" + email + ", id="
				+ id + ", name=" + name + ", password=" + password
				+ ", productModules=" + productModules + ", products="
				+ products + ", projectModuleFuncs=" + projectModuleFuncs
				+ ", role=" + role + ", roleAuths=" + roleAuths + ", userType="
				+ userType + ", username=" + username + "]";
	}

}