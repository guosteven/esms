package cn.guoxy.esms.bs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ��̨��ҳController
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class BsIndexController {
	/**
	 * ת������̨��ҳ
	 * 
	 * @return ��̨��ҳ
	 */
	@RequestMapping("toBsIndex.do")
	public String toBsIndex() {
		return "bs/bsindex";
	}
}
