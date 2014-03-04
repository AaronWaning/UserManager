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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dao.BaseVO;

/**
 * LogType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log_type", catalog = "companymanager")
public class LogType extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Log> logs = new HashSet<Log>(0);

	// Constructors

	/** default constructor */
	public LogType() {
	}

	/** full constructor */
	public LogType(String name, Set<Log> logs) {
		this.name = name;
		this.logs = logs;
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

	@Column(name = "name", length = 4000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "logType")
	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

}