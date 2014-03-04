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
 * Productgroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "productgroup", catalog = "companymanager")
public class Productgroup extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private Datastatus datastatus;
	private Integer companyId;
	private Integer userId;
	private String name;
	private String memo;
	private Timestamp createDate;
	private Timestamp modifyDate;
	private Double orderNo;
	private Set<Product> products = new HashSet<Product>(0);
	private Set<Auth> auths = new HashSet<Auth>(0);

	// Constructors

	/** default constructor */
	public Productgroup() {
	}

	/** full constructor */
	public Productgroup(Datastatus datastatus, Integer companyId,
			Integer userId, String name, String memo, Timestamp createDate,
			Timestamp modifyDate, Double orderNo, Set<Product> products,
			Set<Auth> auths) {
		this.datastatus = datastatus;
		this.companyId = companyId;
		this.userId = userId;
		this.name = name;
		this.memo = memo;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.orderNo = orderNo;
		this.products = products;
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
	@JoinColumn(name = "DataStatus")
	public Datastatus getDatastatus() {
		return this.datastatus;
	}

	public void setDatastatus(Datastatus datastatus) {
		this.datastatus = datastatus;
	}

	@Column(name = "company_id")
	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "Name", length = 4000)
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

	@Column(name = "ModifyDate", length = 19)
	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Column(name = "OrderNo", precision = 22, scale = 0)
	public Double getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Double orderNo) {
		this.orderNo = orderNo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productgroup")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productgroup")
	public Set<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(Set<Auth> auths) {
		this.auths = auths;
	}

}