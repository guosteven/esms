package cn.guoxy.esms.fs.service;

import cn.guoxy.esms.fs.entity.User;

/**
 * ��¼ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface LoginService {
	/**
	 * ��֤��¼
	 * 
	 * @param user
	 * @return
	 */
	public User cheakLogin(User user);

}
