package org.config;

import com.google.gson.annotations.SerializedName;
/**
 * 
 * @author Administrator
 * @version 
 * @since JDK 1.6
 */
public class DataBase {
	@SerializedName("jndi")
	private String jndi;
	@SerializedName("driverName")
	private String driverName;
	@SerializedName("url")
	private String url;
	@SerializedName("username")
	private String username;
	@SerializedName("password")
	private String password;
	@SerializedName("poolSize")
	private int poolSize;
	@SerializedName("validationSQL")
	private String validationSQL;
	@SerializedName("validationTimeout")
	private int validationTimeout;
	
	public String getValidationSQL() {
		return validationSQL;
	}
	public void setValidationSQL(String validationSQL) {
		this.validationSQL = validationSQL;
	}
	public int getValidationTimeout() {
		return validationTimeout;
	}
	public void setValidationTimeout(int validationTimeout) {
		this.validationTimeout = validationTimeout;
	}
	public int getPoolSize() {
		return poolSize;
	}
	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}
	public String getJndi() {
		return jndi;
	}
	public void setJndi(String jndi) {
		this.jndi = jndi;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DataBase [jndi=" + jndi + ", url=" + url + ", username="
				+ username + ", password=" + password + "]";
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
