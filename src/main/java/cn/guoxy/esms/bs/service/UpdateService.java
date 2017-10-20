package cn.guoxy.esms.bs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.guoxy.esms.bs.entity.SmallType;
import cn.guoxy.esms.commons.entity.Goods;

/**
 * �ϴ���Ʒҵ���ӿ�
 * 
 * @author gxy
 *
 */
public interface UpdateService {
	/**
	 * �õ�������Ϣ
	 * 
	 * @param btId
	 *            ������Id
	 */
	List<SmallType> getSmallType(int btId);

	/**
	 * ������Ʒ
	 * 
	 * @param goods
	 *            ��Ʒ����
	 */
	void saveGoods(Goods goods);

	/**
	 * �жϱ��Ƿ��ظ��ύ
	 * 
	 * @param request
	 *            �������
	 * @return ����boolean���� �ظ��ύ����true
	 */
	boolean isRepeatSubmit(HttpServletRequest request);
}
