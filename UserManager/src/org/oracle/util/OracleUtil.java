package org.oracle.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleUtil {
	public static void importfromtext(File file,String table,Connection conn) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
			
			PreparedStatement pstmt=conn.prepareStatement("insert into "+table+"(type_id,name) values (?,?)");
			String line=null;
			int count=1;
			conn.setAutoCommit(false);
			while((line=br.readLine())!=null){
				System.out.println(line);
				String[] s= line.split("\t");
				pstmt.setString(1, s[0]);
				pstmt.setString(2, s[1]);
				pstmt.addBatch();
				if(count++%10000==0)
					pstmt.executeBatch();
			}
			if((count--%10000)!=0)
				pstmt.executeBatch();
			conn.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public static void select(String table,Connection conn) {
		try {
			Statement pstmt=conn.createStatement();
			ResultSet rs=pstmt.executeQuery("select * from  "+table);
			while(rs.next()){
				System.out.println(rs.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
