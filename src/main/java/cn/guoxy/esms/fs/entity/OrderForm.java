package cn.guoxy.esms.fs.entity;

import java.util.Date;

/**
 * ����ʵ����
 * 
 * @author gxy
 *
 */
public class OrderForm {
	/**
	 * ����ID
	 */
	private int orderId;
	/**
	 * ������
	 */
	private String orderNumber;
	/**
	 * �û�ID
	 */
	private int userId;
	/**
	 * ��ƷID
	 */
	private int goodsId;
	/**
	 * ����״̬
	 */
	private int status;
	/**
	 * ��������ʱ��
	 */
	private Date CreateTime;
	/**
	 * ��Ʒ����
	 */
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
}
