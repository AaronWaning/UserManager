package org.rest.action;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class RestApplication extends Application {

	final Set<Class<?>> set_classes = new HashSet<Class<?>>();
	final Set<Object> set_objects = new HashSet<Object>();
	
	
	public RestApplication() {
		set_classes.add(RestDemo.class);
		set_classes.add(DownFileDemo.class);
	 }
	
	public Set<Class<?>> getClasses() {
		return set_classes;
	}

	public Set<Object> getSingletons() {
		return set_objects;
	}
}
