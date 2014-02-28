package org.version;

import java.util.ArrayList;
import java.util.Collections;

import proguard.annotation.Keep;
import proguard.annotation.KeepName;

/**
 * Proxy锟侥碉拷前锟芥本
 */
@Keep
@KeepName

public class Version {

	final private static ArrayList<IVersion> verList;
	
	static {
		verList = new ArrayList<IVersion>();
		
		VersionImpl ver = null; 
		ver = new VersionImpl("V1.0.2.201310151507", "beta");
		ver.addDescription("Proxy锟斤拷锟斤拷1.0.2锟芥本");
		verList.add(ver);
		

		// 锟斤拷锟斤拷
		Collections.sort(verList);
	}

	public static void main(String[] args) {
		System.out.print(getVersion());
	}

	/**
	 * 锟斤拷锟斤拷前锟芥本锟侥凤拷锟斤拷锟斤拷息
	 * @param releaseFile
	 * @return
	 */
	@Keep
	@KeepName
	public static String getReleaseInfo(Boolean onlyCurrentVersion) {
		StringBuffer content = new StringBuffer("");

		if( onlyCurrentVersion ){
			IVersion v = verList.get(0);
			content.append(v.getVersion() + " " + v.getVersionType());
			
			int nVerDespCount = v.getVersionDescription().length;
			for (int j = 0; j < nVerDespCount ; j++) {
				content.append("[").append(j + 1).append("]");
				content.append(v.getVersionDescription()[j]);
			}
		}else{
			//锟斤拷锟斤拷锟较版本锟斤拷息
			int nVerCount = verList.size();
			for (int i = 0; i < nVerCount; i++) {
				IVersion v = verList.get(i);
				content.append(v.getVersion() + " " + v.getVersionType());
				if( i == 0 ){
					content.append("(*锟斤拷前锟芥本*)");
				}
				content.append("\r\n");
				
				int nVerDespCount = v.getVersionDescription().length;
				for (int j = 0; j < nVerDespCount ; j++) {
					content.append("[").append(j + 1).append("]");
					content.append(v.getVersionDescription()[j]);
					content.append("\r\n");
				}
				if(i != nVerCount-1)content.append("\r\n\r\n");
			}
		}

		return content.toString();
	}
	
	/**
	 * 锟斤拷取锟斤拷前锟芥本锟斤拷息
	 * 
	 * @return
	 */
	@Keep
	@KeepName
	public static String getVersion() {
		return verList.get(0).getVersion();
	}

	/**
	 * 锟斤拷玫锟角帮拷姹撅拷锟斤拷薷锟斤拷锟斤拷锟�	 * 
	 * @return
	 */
	@Keep
	@KeepName
	public static String[] getVersionDescription() {
		return verList.get(0).getVersionDescription();
	}
	@Keep
	@KeepName
	public static int getVersionCount() {
		return verList.size();
	}

	/**
	 * 锟斤拷取锟斤拷前锟芥本锟斤拷息
	 * 
	 * @return
	 */
	@Keep
	@KeepName
	public static String getVersion(int index) {
		return verList.get(index).getVersion();
	}

	/**
	 * 锟斤拷玫锟角帮拷姹撅拷锟斤拷薷锟斤拷锟斤拷锟�	 * 
	 * @return
	 */
	@Keep
	@KeepName
	public static String[] getVersionDescription(int index) {
		return verList.get(index).getVersionDescription();
	}

	/**
	 * 锟斤拷取锟斤拷前锟芥本锟斤拷息
	 * 
	 * @return
	 */
	@Keep
	@KeepName
	public static String getVersionType(int index) {
		return verList.get(index).getVersionType();
	}

	/**
	 * 锟斤拷玫锟角帮拷姹撅拷锟斤拷薷锟斤拷锟斤拷锟�	 * 
	 * @return
	 */
	@Keep
	@KeepName
	public static String[] getVersionErrors(int index) {
		return verList.get(index).getVersionErrors();
	}
}
