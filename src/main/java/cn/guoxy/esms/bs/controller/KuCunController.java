package cn.guoxy.esms.bs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.service.KuCunService;
import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.util.LogFactory;
import cn.guoxy.esms.fs.entity.ReturnType;

/**
 * �������������߼�
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class KuCunController {
	@Resource(name = "kuCunService")
	private KuCunService kuCunService;
	/**
	 * ��־����
	 */
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * ת����������ҳ��
	 * 
	 * @return ��ͼ��
	 */
	@RequestMapping("toKuCun.do")
	public String toKuCun() {
		return "bs/kucun";
	}

	/**
	 * �����Ʒ�����Ϣ
	 * 
	 * @return ��Ʒ�����Ϣ
	 */
	@RequestMapping("/getkucun.do")
	@ResponseBody
	public List<Goods> getKucun() {
		List<Goods> list = kuCunService.getKuCun();
		return list;
	}

	/**
	 * ������Ʒ�����Ϣ
	 * 
	 * @param request
	 *            �������
	 * @return �Զ��巵������
	 */
	@RequestMapping("updateGoodsCount.do")
	@ResponseBody
	public ReturnType updateGoodsCount(HttpServletRequest request) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		int count = Integer.parseInt(request.getParameter("count"));
		kuCunService.updateGoodsCount(goodsId, count);
		log.info("MODIFY GOODS--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "���ĳɹ�");
	}

	/**
	 * ɾ����Ʒ
	 * 
	 * @param request
	 *            �������
	 * @return �Զ��巵������
	 */
	@RequestMapping("deleteGoods.do")
	@ResponseBody
	public ReturnType deleteGoods(HttpServletRequest request) {
		int goodsId = Integer.parseInt(request.getParameter("goodsId"));
		kuCunService.deleteGoods(goodsId);
		log.info("REMOVE GOODS--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		return new ReturnType(0, "���ĳɹ�");
	}
}
