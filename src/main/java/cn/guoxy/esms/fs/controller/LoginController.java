package cn.guoxy.esms.fs.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.commons.util.LogFactory;
import cn.guoxy.esms.fs.entity.User;
import cn.guoxy.esms.fs.exception.AppException;
import cn.guoxy.esms.fs.service.LoginService;

/**
 * ��¼�������
 * 
 * @author gxy
 *
 */
@Controller
public class LoginController {

	@Resource(name = "loginService")
	private LoginService loginService;
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * ת������¼ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("tologin.do")
	public String toLogin() {
		return "login";
	}

	/**
	 * �쳣����
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler
	public String handleEx(Exception e, HttpServletRequest request) {
		log.info("APPEXCEPTION--->" + e.getMessage());
		if (e instanceof AppException) {
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		return "error";
	}

	/**
	 * ��¼���� �ɹ����ض�����ҳ
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, HttpSession session) throws IOException {
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		User u = new User(userName, pwd);
		User user = loginService.cheakLogin(u);
		session.setAttribute("user", user);
		return "redirect:toindex.do";
	}
}
