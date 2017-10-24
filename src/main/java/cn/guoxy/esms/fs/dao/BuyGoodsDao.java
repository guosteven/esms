package cn.guoxy.esms.fs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

/**
 * ������Ʒ��س־ò�ӿ�
 * 
 * @author gxy
 *
 */
public interface BuyGoodsDao {
	/**
	 * ��ӵ����ﳵ
	 * 
	 * @param gwc
	 * @return
	 */
	int saveGwc(Gwc gwc);

	/**
	 * ���浽����
	 * 
	 * @param orderFrom
	 * @return
	 */
	int saveOrderForm(OrderForm orderFrom);

	/**
	 * �����û�ID������Ʒ
	 * 
	 * @param userId
	 * @return
	 */
	List<OrderFormGoods> findByGoodsId_OrderForm(int userId);

	/**
	 * �����û�ID������Ʒ
	 * 
	 * @param userId
	 * @return
	 */
	List<GwcGoods> findByGoodsId_gwc(int userId);

	/**
	 * �����û��ȼ�
	 * 
	 * @param userId
	 * @param vip
	 * @return
	 */
	int updateVip(int userId, int vip);

	/**
	 * �ӹ��ﳵ�Ƴ�
	 * 
	 * @param gwcId
	 * @return
	 */
	int delgwc(int gwcId);
}
