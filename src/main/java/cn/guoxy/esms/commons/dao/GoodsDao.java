package cn.guoxy.esms.commons.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * ��Ʒ�־ò�ӿ�
 * 
 * @author gxy
 *
 */
public interface GoodsDao {
	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 *            ��Ʒ����
	 * @return ��¼���ĵ�����
	 */
	int saveGoods(Goods goods);

	/**
	 * ���������Ʒ
	 * 
	 * @param season
	 *            ��Ʒ���ü���
	 * @return ������������Ʒ
	 */
	List<Goods> getNewGoods(Integer season);

	/**
	 * ������ƷID������Ʒ
	 */
	Goods findByGoodsId(Integer goodsId);

	/**
	 * ������Ʒ�����
	 * 
	 * @param goodsId
	 *            ��ƷID
	 * @param num
	 *            ���º�ĵ����
	 * @return ��¼���ĵ�����
	 */
	int updateClickNum(Integer goodsId, int num);

	/**
	 * ������Ʒ���
	 * 
	 * @param goodsId
	 *            ��ƷID
	 * @param goodsCout
	 *            ��Ʒ����
	 * @return ��¼���ĵ�����
	 */
	int updateGoodsCount(int goodsId, int goodsCout);

	/**
	 * ��ѯ������Ʒ
	 * 
	 */
	List<Goods> findAllGoods();

	/**
	 * ɾ����Ʒ
	 * 
	 * @return
	 */
	int deleteGoods(int goodId);

	/**
	 * �õ��������ߵ�8����¼
	 * 
	 */
	List<Goods> findHotGoods();

}
