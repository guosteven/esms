package cn.guoxy.esms.fs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * ������Ʒ�־ò�ӿ�
 * 
 * @author gxy
 *
 */
public interface SearchDao {
	List<Goods> searchGoods(String patten);
}
