package cn.guoxy.esms.bs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * ������ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface KuCunService {
	/**
	 * �õ����п����Ϣ
	 * 
	 * @return
	 */
	List<Goods> getKuCun();

	/**
	 * ���¿����Ϣ
	 * 
	 * @param goodsId
	 *            ��ƷID
	 * @param count
	 *            ��Ʒ����
	 */
	void updateGoodsCount(int goodsId, int count);

	/**
	 * ɾ����Ʒ
	 * 
	 * @param goodId
	 *            ��ƷID
	 */
	void deleteGoods(int goodId);
}
