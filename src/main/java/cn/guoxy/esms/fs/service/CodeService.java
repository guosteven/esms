package cn.guoxy.esms.fs.service;

import javax.servlet.http.HttpSession;

/**
 * ��֤��ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface CodeService {
	/**
	 * ������֤��
	 * 
	 * @param session
	 * @return
	 */
	public Object createCode(HttpSession session);

	/**
	 * �����֤��
	 * 
	 * @param vcode
	 * @param session
	 * @return
	 */
	public boolean checkCode(String vcode, HttpSession session);
}
