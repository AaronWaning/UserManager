package org.version;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �汾�����ʵ��
 */
class VersionImpl implements IVersion {

	final String versionName;
	final String versionType;
	final ArrayList<String> versionDescs = new ArrayList<String>();
	final ArrayList<String> versionErrs = new ArrayList<String>();

	VersionImpl(String versionName, String versionType) {
		this.versionName = versionName;
		this.versionType = versionType;
	}

	public boolean addDescription(String descriptoin) {
		return versionDescs.add(descriptoin);
	}

	public boolean addError(String err) {
		return versionErrs.add(err);
	}

	public String getVersion() {
		return versionName;
	}

	public String[] getVersionDescription() {
		return versionDescs.toArray(new String[0]);
	}

	/**
	 * �����ַ�Ƚ�
	 */
	public int compareTo(IVersion v) {
		String me = this.getVersion();
		String he = v.getVersion();
		
		me = normal(me);
		he = normal(he);
		
		return he.compareToIgnoreCase(me);
	}

	/**
	 * �� 1��9 ת��Ϊ 01��09
	 * @param me
	 * @return
	 */
	protected String normal(String me) {
		Pattern p = Pattern.compile("\\.(\\d)\\.");
		Matcher m = p.matcher(me);
		while( m.find() ){
			me = me.replace("."+m.group(1)+".",".0"+m.group(1)+".");
			m = p.matcher(me);
		}
		return me;
	}


	public String[] getVersionErrors() {
		return versionErrs.toArray(new String[0]);
	}

	public String getVersionType() {
		return this.versionType;
	}

}
