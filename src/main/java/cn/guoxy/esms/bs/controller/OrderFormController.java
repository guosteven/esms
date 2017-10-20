package cn.guoxy.esms.bs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.OrderFormService;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.commons.util.LogFactory;
import cn.guoxy.esms.fs.entity.ReturnType;

/**
 * �������������
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs")
public class OrderFormController {
	@Resource(name = "orderFormService")
	private OrderFormService ofs;
	/**
	 * ��־����
	 */
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * ת������������
	 * 
	 * @return ��ͼ��
	 */
	@RequestMapping("toOrderForm.do")
	public String toOrderForm() {
		return "bs/orderForm";
	}

	/**
	 * �õ����ж�����Ϣ
	 * 
	 * @return ���ж�����Ϣ
	 */
	@RequestMapping("getorderfrom.do")
	@ResponseBody
	public List<OrderFormGoods> getAllOrderFrom() {
		List<OrderFormGoods> list = ofs.findAll();
		return list;
	}

	/**
	 * ɾ������
	 * 
	 * @param request
	 * @return �Զ��巵������
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public ReturnType delect(HttpServletRequest request) {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		ofs.removeOrderForm(orderId);
		log.info("REMOVE ORDERFORM--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "ɾ���ɹ�");
	}

	/**
	 * �ı䶩��״̬
	 * 
	 * @param request
	 * @return �Զ��巵������
	 */
	@RequestMapping("ree.do")
	@ResponseBody
	public ReturnType ree(HttpServletRequest request) {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int status = Integer.parseInt(request.getParameter("status"));
		ofs.updateStatus(orderId, status);
		log.info("MODIFY ORDERFORM--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "�ı�״̬�ɹ�");
	}
}
