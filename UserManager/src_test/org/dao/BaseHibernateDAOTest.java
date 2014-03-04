/**
 * Project Name:UserManager
 * File Name:BaseHibernateDAOTest.java
 * Package Name:org.dao
 * Date:2014-3-2下午04:20:48
 * Copyright (c) 2014
 *
*/

package org.dao;

import java.util.List;

import org.junit.Test;
import org.vo.Company;

/**
 * ClassName:BaseHibernateDAOTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-3-2 下午04:20:48 <br/>
 * @author   wan_song
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class BaseHibernateDAOTest {

	@Test
	public final void testGetSession() {
		try {
			Class.forName("org.vo.HibernateSessionFactory");
			DatastatusDAO ds=new DatastatusDAO();
			System.out.println(ds.findAll());
			CompanyDAO dao=new CompanyDAO();
			List<Company> list=dao.findAll();
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

