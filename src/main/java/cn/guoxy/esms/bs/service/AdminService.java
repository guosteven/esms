package cn.guoxy.esms.bs.service;

import cn.guoxy.esms.bs.entity.Admin;

/**
 * ����Ա��¼ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface AdminService {
	/**
	 * ����¼�����Ƿ�ƥ��
	 * 
	 * @param admin
	 *            ����Ա����
	 * @return ���ݿ��еĹ���Ա���󣬴�ֵ����session��֤
	 */
	Admin ckLogin(Admin admin);
}
