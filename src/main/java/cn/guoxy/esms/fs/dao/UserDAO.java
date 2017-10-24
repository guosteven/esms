package cn.guoxy.esms.fs.dao;

import cn.guoxy.esms.fs.entity.User;

/**
 * �û���س־ò�ӿ�
 * 
 * @author gxy
 *
 */
public interface UserDAO {
	/**
	 * ͨ���û��������û�
	 * 
	 * @param userName
	 * @return
	 */
	public User findByname(String userName);

	/**
	 * ͨ����������û�
	 * 
	 * @param email
	 * @return
	 */
	public User findByEmail(String email);

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	public void save(User user);

	/**
	 * ͨ���û�ID�����û�
	 * 
	 * @param id
	 * @return
	 */
	public User findByid(int id);

	/**
	 * ��������
	 * 
	 * @param Pwd
	 * @param email
	 * @return
	 */
	int updatePwd(String Pwd, String email);
}
