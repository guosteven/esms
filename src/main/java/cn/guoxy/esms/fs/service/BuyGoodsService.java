package cn.guoxy.esms.fs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

/**
 * ������Ʒ���ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface BuyGoodsService {
	/**
	 * ���빺�ﳵ
	 * 
	 * @param gwc
	 */
	void putInGwc(Gwc gwc);

	/**
	 * ����ɹ����붩��
	 * 
	 * @param from
	 */
	void putInOrderFrom(OrderForm from);

	/**
	 * �����û��ȼ�
	 * 
	 * @param userId
	 * @param vip
	 */
	void updateVip(int userId, int vip);

	/**
	 * ��ѯ����
	 * 
	 * @param userId
	 * @return
	 */
	List<OrderFormGoods> findByGoodsId_OrderForm(int userId);

	/**
	 * ��ѯ���ﳵ
	 * 
	 * @param userId
	 * @return
	 */
	List<GwcGoods> findByGoodsId_gwc(int userId);

	/**
	 * ɾ�����ﳵ
	 * 
	 * @param gwcId
	 */
	void delgwc(int gwcId);
}
