package cn.guoxy.esms.commons.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * ��Ʒҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface GoodsService {
	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 *            ��Ʒ����
	 */
	void saveGoods(Goods goods);

	/**
	 * �õ�����������Ʒ
	 * 
	 * @param season
	 *            ����
	 * @return
	 */
	List<Goods> getNewGoods(Integer season);

	/**
	 * ͨ��ID��ѯ��Ʒ
	 * 
	 * @param goodsId
	 *            ��ƷID
	 * @return
	 */
	Goods findByGoodsId(Integer goodsId);

	/**
	 * ���µ����
	 * 
	 * @param goodsId
	 *            ��ƷID
	 */
	void updateClickNum(Integer goodsId);

	void updateGoodsCount(int goodsId, int num);

	List<Goods> getHotGoods();
}
