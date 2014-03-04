package com.oracle.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import org.config.util.SystemConfigUtils;
import org.junit.Test;
import org.oracle.util.ConnectionUtils;
import org.oracle.util.OracleUtil;

import com.google.gson.JsonParseException;

public class OracleUtilTest {

	public static void main(String[] args) {
	}
	@Test
	public void testImportfromtext() {
		try {
			ConnectionUtils.initContext(SystemConfigUtils.load());
			Connection conn=ConnectionUtils.getConnection();
			OracleUtil.importfromtext(new File("E:/workspaces/changzhou/Database/src_test/data/type"), "EZCRM_DIC_ZD", conn);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void testselect(){
		try {
			ConnectionUtils.initContext(SystemConfigUtils.load());
			Connection conn=ConnectionUtils.getConnection();
			OracleUtil.select( "user", conn);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
