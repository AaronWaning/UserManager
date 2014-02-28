package org.config;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SystemConfig {
	@SerializedName("databases")
	private List<DataBase> databases;
	@SerializedName("current")
	private Integer current;
	
	public void setCurrent(Integer current) {
		this.current = current;
	}

	public List<DataBase> getDatabases() {
		return databases;
	}

	public void setDatabase(List<DataBase> databases) {
		this.databases = databases;
	}

	public DataBase getDatabase() {
		
		return databases.get(this.current);
	}

	
}
