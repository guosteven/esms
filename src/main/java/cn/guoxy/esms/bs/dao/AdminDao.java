package cn.guoxy.esms.bs.dao;

import cn.guoxy.esms.bs.entity.Admin;

/**
 * ����Ա�־ò�
 * 
 * @author gxy
 *
 */
public interface AdminDao {
	/**
	 * ͨ������Ա�����ҹ���Ա
	 * 
	 * @param name
	 *            ����Ա��
	 * @return ����Ա����
	 */
	Admin findByName(String name);
}
