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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dao.BaseVO;

/**
 * Datastatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "datastatus", catalog = "companymanager")
public class Datastatus extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private Set<UserType> userTypes = new HashSet<UserType>(0);
	private Set<ProductModule> productModules = new HashSet<ProductModule>(0);
	private Set<User> users = new HashSet<User>(0);
	private Set<Productgroup> productgroups = new HashSet<Productgroup>(0);
	private Set<Log> logs = new HashSet<Log>(0);
	private Set<Product> products = new HashSet<Product>(0);
	private Set<Auth> auths = new HashSet<Auth>(0);
	private Set<RoleAuth> roleAuths = new HashSet<RoleAuth>(0);
	private Set<ProjectModuleFunc> projectModuleFuncs = new HashSet<ProjectModuleFunc>(
			0);
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Company> companies = new HashSet<Company>(0);

	// Constructors

	/** default constructor */
	public Datastatus() {
	}

	/** full constructor */
	public Datastatus(String name, Timestamp createDate, Timestamp modifyDate,
			Set<UserType> userTypes, Set<ProductModule> productModules,
			Set<User> users, Set<Productgroup> productgroups, Set<Log> logs,
			Set<Product> products, Set<Auth> auths, Set<RoleAuth> roleAuths,
			Set<ProjectModuleFunc> projectModuleFuncs, Set<Role> roles,
			Set<Company> companies) {
		this.name = name;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.userTypes = userTypes;
		this.productModules = productModules;
		this.users = users;
		this.productgroups = productgroups;
		this.logs = logs;
		this.products = products;
		this.auths = auths;
		this.roleAuths = roleAuths;
		this.projectModuleFuncs = projectModuleFuncs;
		this.roles = roles;
		this.companies = companies;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<UserType> getUserTypes() {
		return this.userTypes;
	}

	public void setUserTypes(Set<UserType> userTypes) {
		this.userTypes = userTypes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<ProductModule> getProductModules() {
		return this.productModules;
	}

	public void setProductModules(Set<ProductModule> productModules) {
		this.productModules = productModules;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<Productgroup> getProductgroups() {
		return this.productgroups;
	}

	public void setProductgroups(Set<Productgroup> productgroups) {
		this.productgroups = productgroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(Set<Auth> auths) {
		this.auths = auths;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<RoleAuth> getRoleAuths() {
		return this.roleAuths;
	}

	public void setRoleAuths(Set<RoleAuth> roleAuths) {
		this.roleAuths = roleAuths;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<ProjectModuleFunc> getProjectModuleFuncs() {
		return this.projectModuleFuncs;
	}

	public void setProjectModuleFuncs(Set<ProjectModuleFunc> projectModuleFuncs) {
		this.projectModuleFuncs = projectModuleFuncs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "datastatus")
	public Set<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		return "Datastatus [auths=" + auths + ", companies=" + companies
				+ ", createDate=" + createDate + ", id=" + id + ", logs="
				+ logs + ", modifyDate=" + modifyDate + ", name=" + name
				+ ", productModules=" + productModules + ", productgroups="
				+ productgroups + ", products=" + products
				+ ", projectModuleFuncs=" + projectModuleFuncs + ", roleAuths="
				+ roleAuths + ", roles=" + roles + ", userTypes=" + userTypes
				+ ", users=" + users + "]";
	}

}