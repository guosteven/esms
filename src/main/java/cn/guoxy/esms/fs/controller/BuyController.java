package cn.guoxy.esms.fs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.commons.service.GoodsService;
import cn.guoxy.esms.commons.util.OrderNumber;
import cn.guoxy.esms.fs.dao.UserDAO;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;
import cn.guoxy.esms.fs.entity.ReturnType;
import cn.guoxy.esms.fs.entity.User;
import cn.guoxy.esms.fs.service.BuyGoodsService;

/**
 * �������������
 * 
 * @author gxy
 *
 */
@Controller
public class BuyController {
	@Resource(name = "buyGoodsService")
	private BuyGoodsService buyGoodsService;
	@Resource(name = "goodsService")
	private GoodsService goodsService;
	@Resource(name = "userDAO")
	private UserDAO dao;

	/**
	 * ������빺�ﳵ������
	 * 
	 * @param request
	 *            �������
	 * @param session
	 *            ȡ���󶨵��û�
	 * @return �Զ��巵������
	 */
	@RequestMapping("putingwc.do")
	@ResponseBody
	public ReturnType putInGwc(HttpServletRequest request, HttpSession session) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		Gwc gwc = new Gwc();
		gwc.setGoodsId(goodsId);
		gwc.setCount(count);
		gwc.setUserId(user.getId());
		buyGoodsService.putInGwc(gwc);
		return new ReturnType(0, "���빺�ﳵ�ɹ�");
	}

	/**
	 * ֱ�ӹ����������붩��
	 * 
	 * @return �Զ��巵������
	 */
	@RequestMapping("putinorder.do")
	@ResponseBody
	public ReturnType putInOrderForm(HttpServletRequest request, HttpSession session) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		OrderForm orderForm = new OrderForm();
		orderForm.setCount(count);
		orderForm.setGoodsId(goodsId);
		orderForm.setOrderNumber(OrderNumber.CreateOrderNumber(session));
		orderForm.setUserId(user.getId());
		buyGoodsService.putInOrderFrom(orderForm);
		goodsService.updateGoodsCount(goodsId, count);
		Goods goods = goodsService.findByGoodsId(goodsId);
		User user2 = dao.findByid(user.getId());
		int vip = count * goods.getGoodsPrice() + user2.getVip();
		buyGoodsService.updateVip(user.getId(), vip);
		return new ReturnType(0, "����ɹ�");
	}

	/**
	 * �ӹ��ﳵ����
	 * 
	 * @return �Զ��巵������
	 */
	@RequestMapping("putinorder1.do")
	@ResponseBody
	public ReturnType putInOrderForm1(HttpServletRequest request, HttpSession session) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		int gwcId = Integer.parseInt(request.getParameter("gwcId"));
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		OrderForm orderForm = new OrderForm();
		orderForm.setCount(count);
		orderForm.setGoodsId(goodsId);
		orderForm.setOrderNumber(OrderNumber.CreateOrderNumber(session));
		orderForm.setUserId(user.getId());
		buyGoodsService.putInOrderFrom(orderForm);
		goodsService.updateGoodsCount(goodsId, count);
		Goods goods = goodsService.findByGoodsId(goodsId);
		User user2 = dao.findByid(user.getId());
		int vip = count * goods.getGoodsPrice() + user2.getVip();
		buyGoodsService.delgwc(gwcId);
		buyGoodsService.updateVip(user.getId(), vip);
		return new ReturnType(0, "����ɹ�");
	}

	/**
	 * ת��������ҳ
	 * 
	 * @return �Զ��巵������
	 */
	@RequestMapping("toorderForm.do")
	public String orderForm() {
		return "orderfrom";
	}

	/**
	 * �õ���ǰ�û����ж���
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("getForm.do")
	@ResponseBody
	public List<OrderFormGoods> getorderForm(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		List<OrderFormGoods> list = buyGoodsService.findByGoodsId_OrderForm(user.getId());
		return list;
	}

	/**
	 * ת�������ﳵҳ��
	 * 
	 * @return
	 */
	@RequestMapping("togwc.do")
	public String orderGwc() {
		return "gwc";
	}

	/**
	 * �õ���ǰ�û����еĹ��ﳵ��Ϣ
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("getgwc.do")
	@ResponseBody
	public List<GwcGoods> getgwc(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getId() == 0) {
			user = dao.findByEmail(user.getEmail());
		}
		List<GwcGoods> list = buyGoodsService.findByGoodsId_gwc(user.getId());
		return list;
	}

	/**
	 * ɾ�����ﳵ��Ʒ
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("delgwc.do")
	@ResponseBody
	public ReturnType delGwc(HttpServletRequest request) {
		int gwcId = Integer.parseInt(request.getParameter("gwcId"));
		buyGoodsService.delgwc(gwcId);
		return new ReturnType(0, "ɾ���ɹ�");
	}
}
