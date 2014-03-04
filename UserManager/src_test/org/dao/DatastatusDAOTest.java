package org.dao;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.vo.Datastatus;

public class DatastatusDAOTest {
	static DatastatusDAO dsd;
	static{
		dsd=new DatastatusDAO();
	}
	@Test
	public void testSave() {
		String[] s={"锁定","删除","停用"};
		for (int i = 0; i < 3; i++) {
			Datastatus data = new Datastatus();
			data.setName(s[i]);
			Timestamp tamp = new Timestamp(System.currentTimeMillis());
			data.setCreateDate(tamp);
			data.setModifyDate(tamp);
			dsd.save(data);
		}
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testFindById() {
		
	}

	@Test
	public void testFindByExample() {
		
	}

	@Test
	public void testFindByProperty() {
		
	}

	@Test
	public void testFindByName() {
		
	}

	@Test
	public void testFindAll() {
		List list=dsd.findAll();
		System.out.println(list.size());
		System.out.println(list);
	}

	@Test
	public void testMerge() {
		
	}

	@Test
	public void testAttachDirty() {
		
	}

	@Test
	public void testAttachClean() {
		
	}

}
