package cn.guoxy.esms.bs.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.bs.dao.GoodsTypeDao;
import cn.guoxy.esms.bs.entity.SmallType;
import cn.guoxy.esms.commons.dao.GoodsDao;
import cn.guoxy.esms.commons.entity.Goods;

/**
 * ��Ʒ�ϴ�ҵ���ʵ����
 * 
 * @author gxy
 *
 */
@Service("updateService")
public class UpdateServiceImpl implements UpdateService {
	@Resource(name = "goodsTypeDao")
	private GoodsTypeDao dao;
	@Resource(name = "goodsDao")
	private GoodsDao goodsDao;

	public List<SmallType> getSmallType(int btId) {
		List<SmallType> list = dao.getSmallType(btId);
		return list;
	}

	public void saveGoods(Goods goods) {
		goodsDao.saveGoods(goods);
	}

	public boolean isRepeatSubmit(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		// 1������û��ύ�ı�������û��token�����û����ظ��ύ�˱�
		if (client_token == null) {
			return true;
		}
		// ȡ���洢��Session�е�token
		String server_token = (String) request.getSession().getAttribute("token");
		// 2�������ǰ�û���Session�в�����Token(����)�����û����ظ��ύ�˱�
		if (server_token == null) {
			return true;
		}
		// 3���洢��Session�е�Token(����)����ύ��Token(����)��ͬ�����û����ظ��ύ�˱�
		if (!client_token.equals(server_token)) {
			return true;
		}

		return false;
	}

}
