package org.listener;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.config.util.SystemConfigUtils;
import org.oracle.util.ConnectionUtils;

import proguard.classfile.visitor.ClassForNameClassVisitor;

/**
 * Application Lifecycle Listener implementation class ConfigureListener
 *
 */
public class SystemStartListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SystemStartListener() {
    }
    /**
     * 
     * TODO 简单描述该方法的实现功能（可选）.
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			ConnectionUtils.destory();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


/**
 * 
 * TODO 简单描述该方法的实现功能（可选）.
 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
 */
	public void contextInitialized(ServletContextEvent sc) {
		try {
			Class.forName("org.config.HibernateSessionFactory");
			ConnectionUtils.initContext(SystemConfigUtils.load());
			Connection conn=ConnectionUtils.getConnection();
			System.out.println(conn+"-------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
