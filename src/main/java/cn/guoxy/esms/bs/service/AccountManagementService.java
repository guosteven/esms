package cn.guoxy.esms.bs.service;

import java.util.List;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.entity.User;

/**
 * �˻�����ҵ���
 * 
 * @author gxy
 *
 */
public interface AccountManagementService {
	/**
	 * �õ����л�Ա
	 */
	List<User> findAllUser();

	/**
	 * �õ����й���Ա
	 * 
	 * @return
	 */
	List<Admin> findAllAdmin();

	/**
	 * ��ӹ���Ա
	 * 
	 * @param admin
	 *            ����Ա����
	 */
	void addAdmin(Admin admin);

	/**
	 * ɾ������Ա
	 * 
	 * @param adminId
	 *            ����ԱID
	 */
	void deleteAdmin(int adminId);
}
