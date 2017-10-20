package cn.guoxy.esms.bs.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.bs.dao.AdminDao;
import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.exception.AppException;

/**
 * ����Ա��¼ҵ���ӿ�
 * 
 * @author gxy
 *
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource(name = "adminDao")
	private AdminDao dao;

	public Admin ckLogin(Admin admin) {
		Admin ad = dao.findByName(admin.getAdminName());
		if (ad == null) {
			throw new AppException("�û���������");
		} else if (!ad.getAdminPwd().equals(admin.getAdminPwd())) {
			throw new AppException("�������");
		}
		return ad;
	}

}
