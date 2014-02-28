package org.oracle.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.config.DataBase;
import org.config.SystemConfig;

public class ConnectionUtils {
	static private DataSource ds = null;
	
	private static DataBase datas;
	static public void initContext(SystemConfig systemConfig) throws NamingException{
			datas = systemConfig.getDatabase();
			String jndi=datas.getJndi();
			if(jndi==null||jndi.trim().equals("")){
				ds = createDataSourceFromJDBC();
			}else{
				ds=createDataSourceFromJNDI(jndi);
			}
	}

	private static DataSource createDataSourceFromJNDI(String jndi)
			throws NamingException {
		Context ctx = (Context) new InitialContext();
		return (DataSource) ctx.lookup(jndi);
	}

	private static BasicDataSource createDataSourceFromJDBC() {
		BasicDataSource bds = new BasicDataSource();
		bds.setUrl(datas.getUrl());
		bds.setInitialSize(datas.getPoolSize());
		bds.setMaxActive(datas.getPoolSize());
		bds.setDriverClassName(datas.getDriverName());
		bds.setUsername(datas.getUsername());
		bds.setPassword(datas.getPassword());
		bds.setValidationQuery(datas.getValidationSQL());
		bds.setValidationQueryTimeout(datas.getValidationTimeout());
		bds.setNumTestsPerEvictionRun(1000);
		return bds;
	}
		
	static public Connection getConnection() throws Exception{
		return ds.getConnection();
	}
	
	static public void destory() throws NamingException{
		String jndi=datas.getJndi();
		if(jndi==null||jndi.trim().equals("")){
			return;
		}
		Context ctx = (Context) new InitialContext();
		ds = (DataSource) ctx.lookup(jndi);
		if(ds!=null){
		 ctx.unbind(datas.getJndi());
		}
	}
}
