package cn.guoxy.esms.bs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.OrderFormGoods;

/**
 * ��������־ò�ӿ�
 * 
 * @author gxy
 *
 */
public interface OrderFormDao {
	/**
	 * ��ѯ���ж���
	 */
	List<OrderFormGoods> findAllOrderForm();

	/**
	 * �Ƴ�����
	 * 
	 * @param orderId
	 *            ����ID
	 * @return ��¼�ı�����
	 */
	int removeOrderForm(int orderId);

	/**
	 * ���Ķ���״̬
	 * 
	 * @param orderId
	 *            ����ID
	 * @param status
	 *            ״ֵ̬
	 * @return ��¼���ı������
	 */
	int updateStatus(int orderId, int status);
}
