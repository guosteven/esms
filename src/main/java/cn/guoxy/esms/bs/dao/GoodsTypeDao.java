package cn.guoxy.esms.bs.dao;

import java.util.List;

import cn.guoxy.esms.bs.entity.SmallType;

/**
 * ��Ʒ���ͳ־ò�ӿ�
 * 
 * @author gxy
 *
 */
public interface GoodsTypeDao {
	/**
	 * ���ݴ�����ѯ���е�С����
	 * 
	 * @param btId
	 *            �����Id
	 */
	List<SmallType> getSmallType(int btId);
}
