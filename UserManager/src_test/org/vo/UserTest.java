package org.vo;

import java.sql.Timestamp;

import org.dao.DatastatusDAO;
import org.dao.UserDAO;
import org.dao.UserTypeDAO;
import org.junit.Test;

public class UserTest {

	@Test
	public void testSave() {
		DatastatusDAO dao=new DatastatusDAO();
		UserTypeDAO utd=new UserTypeDAO();
		for (int i = 0; i < 1; i++) {
			User data = new User();
			Timestamp tamp=new Timestamp(System.currentTimeMillis());
			data.setDatastatus(dao.findById(1));
			data.setUserType(utd.findById(3));
			data.setName("admin");
			UserDAO ud = new UserDAO();
			data.setCreateDate(tamp);
			ud.save(data);
		}
	}

}
