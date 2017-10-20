package cn.guoxy.esms.bs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.AccountManagementService;
import cn.guoxy.esms.commons.util.LogFactory;
import cn.guoxy.esms.fs.entity.ReturnType;
import cn.guoxy.esms.fs.entity.User;

/**
 * ��̨�˺Ź�����
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class AccountManagementController {
	@Resource(name = "accountManagementService")
	private AccountManagementService accountManagementService;
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * ת������̨��Ա�������
	 * 
	 * @return��Ա����ҳ��
	 */
	@RequestMapping("toUser.do")
	public String toUser() {
		return "bs/user";
	}

	/**
	 * ת��������Ա�������
	 * 
	 * @return ����Ա����ҳ��
	 */
	@RequestMapping("toAdmin.do")
	public String toAdmin() {
		return "bs/admin";
	}

	/**
	 * ������л�Ա��Ϣ
	 * 
	 * @return ���еĻ�Ա��Ϣ
	 */
	@RequestMapping("getuser.do")
	@ResponseBody
	public List<User> getUser() {
		List<User> list = accountManagementService.findAllUser();
		return list;
	}

	/**
	 * �õ����еĹ���Ա��Ϣ
	 * 
	 * @return ����Ա��Ϣ
	 */
	@RequestMapping("getadmin.do")
	@ResponseBody
	public List<Admin> getAdmin() {
		List<Admin> list = accountManagementService.findAllAdmin();
		return list;
	}

	/**
	 * ��ӹ���Ա
	 * 
	 * @param request
	 * @return �Զ��巵������
	 */
	@RequestMapping("updateadmin.do")
	@ResponseBody
	public ReturnType updateAdmin(HttpServletRequest request) {
		Admin admin = new Admin();
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		admin.setAdminName(adminName);
		admin.setAdminPwd(adminPwd);
		accountManagementService.addAdmin(admin);
		log.info("ADD ADMIN--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName() + "--->"
				+ admin.getAdminName());
		return new ReturnType(0, "��ӳɹ�");
	}

	/**
	 * ɾ������Ա
	 * 
	 * @param request
	 * @return �Զ��巵������
	 */
	@RequestMapping("deleteadmin.do")
	@ResponseBody
	public ReturnType deleteAdmin(HttpServletRequest request) {
		Admin admin = new Admin();
		List<Admin> list = accountManagementService.findAllAdmin();
		int adminId = Integer.parseInt(request.getParameter("adminId"));
		for (Admin admin2 : list) {
			if (admin2.getAdminId() == adminId) {
				admin = admin2;
			}
		}
		accountManagementService.deleteAdmin(adminId);
		log.info("DELETE ADMIN--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName() + "--->"
				+ admin.getAdminName());
		return new ReturnType(0, "ɾ���ɹ�");
	}
}
