/**
 * Project Name:UserManager
 * File Name:UserDAOTest.java
 * Package Name:org.vo
 * Date:2014-3-4下午03:23:46
 * Copyright (c) 2014
 *
*/

package org.vo;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;

/**
 * ClassName:UserDAOTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-3-4 下午03:23:46 <br/>
 * @author   wan_song
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class UserDAOTest {

	private UserDAO userdao;
	@Before
	public void setUp() throws Exception {
		userdao=new UserDAO();
	}

	@Test
	public final void testSave() {
		User user=new User();
		user.setName("测试用户");
		user.setUsername("sejin");
		user.setPassword("admin");
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		userdao.save(user);
	}

	@Test
	public final void testDelete() {
	}
	@Test
	public final void testFindAll() {
		System.out.println(userdao.findAll());
	}
	@Test
	public final void testFindByEmail() {
	}

}

