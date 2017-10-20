package cn.guoxy.esms.bs.dao;

import java.util.List;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.entity.User;

/**
 * �˺Ź���־ò�ӿ�
 * 
 * @author gxy
 *
 */
public interface AccountManagementDao {
	/**
	 * �õ����еĻ�Ա��Ϣ
	 * 
	 */
	List<User> findAllUser();

	/**
	 * �õ����й���Ա��Ϣ
	 */
	List<Admin> findAllAdmin();

	/**
	 * ��ӹ���Ա
	 * 
	 * @param admin
	 *            ����Ա����
	 */
	int addAdmin(Admin admin);

	/**
	 * ɾ������Ա
	 * 
	 * @param adminId
	 *            ����ԱId
	 * @return ɾ���ļ�¼��
	 */
	int deleteAdmin(int adminId);
}
