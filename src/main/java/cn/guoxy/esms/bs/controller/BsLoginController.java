package cn.guoxy.esms.bs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.AdminService;
import cn.guoxy.esms.fs.exception.AppException;

/**
 * ��̨��¼����
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class BsLoginController {
	@Resource(name = "adminService")
	private AdminService adminService;

	/**
	 * �쳣����
	 * 
	 * @param e
	 *            ������쳣
	 * @param request
	 *            �������
	 * @return ��ͼ��
	 */
	@ExceptionHandler
	public String handleEx(Exception e, HttpServletRequest request) {
		if (e instanceof AppException) {
			request.setAttribute("login_failed", e.getMessage());
			return "bs/bslogin";
		}
		return "error";
	}

	/**
	 * ת������̨��¼ҳ��
	 * 
	 * @return ��ͼ��
	 */
	@RequestMapping("tobslogin.do")
	public String toBsLogin() {
		return "bs/bslogin";
	}

	/**
	 * �����¼�߼�
	 * 
	 * @param request
	 *            �������
	 * @param session
	 *            �󶨲�������
	 * @return ��ͼ��
	 */
	@RequestMapping("bslogin.do")
	public String bsLogin(HttpServletRequest request, HttpSession session) {
		String adminName = request.getParameter("adminName");
		String adminPwd = request.getParameter("adminPwd");
		Admin ad = new Admin();
		ad.setAdminName(adminName);
		ad.setAdminPwd(adminPwd);
		Admin admin = adminService.ckLogin(ad);
		session.setAttribute("admin", admin);
		return "redirect:toBsIndex.do";
	}

	/**
	 * ����ǳ�����
	 * 
	 * @param session
	 *            �Ƴ�����ʱʹ��
	 * @return ��ͼ��
	 */
	@RequestMapping("bslogout.do")
	public String bsLogout(HttpSession session) {
		session.removeAttribute("admin");
		return "redirect:tobslogin.do";

	}
}
