package cn.guoxy.esms.fs.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.util.PasswordUtil;
import cn.guoxy.esms.fs.dao.UserDAO;
import cn.guoxy.esms.fs.entity.User;
import cn.guoxy.esms.fs.exception.AppException;

/**
 * ��¼ҵ���ʵ����
 * 
 * @author gxy
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Resource(name = "userDAO")
	private UserDAO dao;

	public User cheakLogin(User user) {
		User u = dao.findByname(user.getUserName());
		if (u == null) {
			throw new AppException("�û���������");
		} else if (!PasswordUtil.verify(user.getPwd(), u.getPwd())) {
			throw new AppException("�������");
		}
		return u;
	}

}
