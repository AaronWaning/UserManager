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
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "companymanager")
public class Log extends BaseVO implements java.io.Serializable {

	// Fields

	private Integer id;
	private LogType logType;
	private Datastatus datastatus;
	private Integer creatorId;
	private String log;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(LogType logType, Datastatus datastatus, Integer creatorId,
			String log, Timestamp createDate) {
		this.logType = logType;
		this.datastatus = datastatus;
		this.creatorId = creatorId;
		this.log = log;
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
	@JoinColumn(name = "type_id")
	public LogType getLogType() {
		return this.logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DataStatus")
	public Datastatus getDatastatus() {
		return this.datastatus;
	}

	public void setDatastatus(Datastatus datastatus) {
		this.datastatus = datastatus;
	}

	@Column(name = "creator_id")
	public Integer getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	@Column(name = "Log", length = 4000)
	public String getLog() {
		return this.log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	@Column(name = "CreateDate", length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}