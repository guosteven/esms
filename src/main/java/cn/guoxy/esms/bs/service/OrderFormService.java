package cn.guoxy.esms.bs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.OrderFormGoods;

/**
 * ��������ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface OrderFormService {
	/**
	 * �õ����ж���
	 * 
	 * @return
	 */
	List<OrderFormGoods> findAll();

	/**
	 * �Ƴ����ж���
	 * 
	 * @param orderId
	 */
	void removeOrderForm(int orderId);

	/**
	 * ���¶���״̬
	 * 
	 * @param orderId
	 *            ����ID
	 * @param status
	 *            ����״̬
	 */
	void updateStatus(int orderId, int status);
}
