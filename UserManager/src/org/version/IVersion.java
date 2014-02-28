package org.version;

public interface IVersion extends Comparable<IVersion> {
	/**
	 * ��ȡ��ǰ�汾��Ϣ
	 * 
	 * @return
	 */
	public String getVersion();

	/**
	 * �汾����
	 * 
	 * @return
	 */
	public String getVersionType();

	/**
	 * ��õ�ǰ�汾���޸�����
	 * 
	 * @return
	 */
	public String[] getVersionDescription();

	/**
	 * ��������
	 */
	public String[] getVersionErrors();
}
