package org.rest.action;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.jaxrs.json.annotation.JSONP;


@Path("/")
@Produces({"application/json;charset=utf-8"})
public class RestDemo {
	@Path("/HelloWorld")
	@GET
	@POST
	@JSONP	
	@Produces("application/json")
	@Consumes("application/json")
	public List<Person> getString(){
		List<Person> list=new ArrayList<Person>();
		for(int i=0;i<100;i++){
			list.add(new Person("name"+i, ("name"+i)));
		}

		return 	list;
	}
	
	
}

class Person{
	private String name;
	private String password;
	public Person(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + "]";
	}
	
	
}