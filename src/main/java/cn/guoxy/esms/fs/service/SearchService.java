package cn.guoxy.esms.fs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * ����ҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface SearchService {
	/**
	 * ������Ʒ
	 * 
	 * @param patten
	 * @return
	 */
	List<Goods> searchGoods(String patten);
}
