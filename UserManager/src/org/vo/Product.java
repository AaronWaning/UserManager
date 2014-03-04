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
 * Product entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "product", catalog = "companymanager")
public class Product extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Productgroup productgroup;
	private Datastatus datastatus;
	private String name;
	private String memo;
	private Timestamp createDate;
	private Double orderNo;
	private Set<Auth> auths = new HashSet<Auth>(0);
	private Set<ProductModule> productModules = new HashSet<ProductModule>(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(User user, Productgroup productgroup, Datastatus datastatus,
			String name, String memo, Timestamp createDate, Double orderNo,
			Set<Auth> auths, Set<ProductModule> productModules) {
		this.user = user;
		this.productgroup = productgroup;
		this.datastatus = datastatus;
		this.name = name;
		this.memo = memo;
		this.createDate = createDate;
		this.orderNo = orderNo;
		this.auths = auths;
		this.productModules = productModules;
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
	@JoinColumn(name = "group_id")
	public Productgroup getProductgroup() {
		return this.productgroup;
	}

	public void setProductgroup(Productgroup productgroup) {
		this.productgroup = productgroup;
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

	@Column(name = "OrderNo", precision = 22, scale = 0)
	public Double getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Double orderNo) {
		this.orderNo = orderNo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public Set<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(Set<Auth> auths) {
		this.auths = auths;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductModule> getProductModules() {
		return this.productModules;
	}

	public void setProductModules(Set<ProductModule> productModules) {
		this.productModules = productModules;
	}

}