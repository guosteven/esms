package cn.guoxy.esms.fs.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.guoxy.esms.fs.service.CodeService;

/**
 * 注册时验证码处理相关
 * 
 * @author gxy
 *
 */
@Controller
public class CodeController {
	@Resource(name = "codeService")
	private CodeService codeservice;

	/**
	 * 获得验证码请求处理
	 * 
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/code.do")
	public void code(HttpServletResponse response, HttpSession session) throws IOException {
		RenderedImage image = (RenderedImage) codeservice.createCode(session);
		response.setContentType("image/png");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "png", os);
	}

	/**
	 * 检查验证码是否正确
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/ckcode.do")
	public void ckCode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		String vcode = request.getParameter("code");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (codeservice.checkCode(vcode, session)) {
			out.println("验证码正确");
		} else {
			out.print("验证码错误");
		}
	}
}
