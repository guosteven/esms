package cn.guoxy.esms.fs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.fs.entity.ReturnType;
import cn.guoxy.esms.fs.entity.User;
import cn.guoxy.esms.fs.service.EmailService;
import cn.guoxy.esms.fs.service.RegistService;

/**
 * ע�ᴦ��
 * 
 * @author gxy
 *
 */
@Controller
public class RegistController {
	@Resource(name = "registService")
	private RegistService registService;
	@Resource(name = "emailService")
	public EmailService emailService;

	/**
	 * ת����ע��ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/toregist.do")
	public String toRegist() {
		return "regist";
	}

	/**
	 * ����û����Ƿ��ظ�
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/ckUserName.do")
	public void ckUserName(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		response.setContentType("text/html;charset=UTF-8;");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (registService.checkUserName(userName)) {
			out.println("�û����Ϸ�");
		} else {
			out.println("�û�����ռ��");
		}
	}

	/**
	 * �������
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ckEmail.do")
	@ResponseBody
	public ReturnType ckEmail(HttpServletRequest request) throws Exception {
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		if (registService.checkEmail(email)) {
			User user = new User(email, userName, pwd);
			request.getSession().setAttribute("now", user);
			emailService.ckEmail(request);
			return new ReturnType(0);
		} else {
			return new ReturnType(1, "�����Ѵ���");
		}
	}

	/**
	 * ��������Ƿ���ʵ����
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ckkEmail.do")
	public String ckkEmail(HttpServletRequest request) throws Exception {
		String uid = request.getParameter("uid");
		String uuid = (String) request.getSession().getAttribute("uid");
		if (uid.equals(uuid)) {
			request.setAttribute("now", request.getSession().getAttribute("now"));
			request.getSession().removeAttribute("now");
			return "regist";
		} else {
			request.setAttribute("error", "������֤ʧ��");
			return "regist";
		}

	}

	/**
	 * ע�ᴦ�����û���Ϣ�浽���ݿ�
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/regist.do")
	public String regist(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		User user = new User(email, userName, pwd);
		if (!registService.checkUserName(userName)) {
			return "regist";
		} else {
			request.getSession().setAttribute("user", user);
			registService.save(user);
			return "index";
		}
	}
}
