package cn.guoxy.esms.fs.entity;

/**
 * ���ﳵʵ����
 * 
 * @author gxy
 *
 */
public class Gwc {
	/**
	 * ���ﳵID
	 */
	private int gwcId;
	/**
	 * ��ƷID
	 */
	private int goodsId;
	/**
	 * �û�ID
	 */
	private int userId;
	/**
	 * ��Ʒ����
	 */
	private int count;

	public int getGwcId() {
		return gwcId;
	}

	public void setGwcId(int gwcId) {
		this.gwcId = gwcId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
