package cn.guoxy.esms.fs.service;

import cn.guoxy.esms.fs.entity.User;

/**
 * ע��ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface RegistService {
	/**
	 * ����û����Ƿ��ظ�
	 * 
	 * @param userName
	 * @return
	 */
	public boolean checkUserName(String userName);

	/**
	 * �������
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email);

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public void save(User user);

	/**
	 * ��������
	 * 
	 * @param Pwd
	 * @param email
	 */
	void updatePwd(String Pwd, String email);
}
