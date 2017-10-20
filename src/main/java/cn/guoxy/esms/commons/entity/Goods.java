package cn.guoxy.esms.commons.entity;

import java.sql.Date;

import cn.guoxy.esms.bs.entity.BigType;
import cn.guoxy.esms.bs.entity.SmallType;

/**
 * ��Ʒʵ����
 * 
 * @author gxy
 *
 */
public class Goods {
	/**
	 * ��ƷID
	 */
	private int goodsId;
	/**
	 * ��Ʒ��
	 */
	private String goodsName;
	/**
	 * ��Ʒ����
	 */
	private String goodsShow;
	/**
	 * ��Ʒ����
	 */
	private int goodsPrice;
	/**
	 * ��Ʒ����
	 */
	private int goodsCount;
	/**
	 * ���м���
	 */
	private int season;
	/**
	 * ������ID {@link BigType}
	 */
	private int btId;
	/**
	 * С����ID{@link SmallType}
	 */
	private int stId;
	/**
	 * ��ƷСͼ��
	 */
	private String smallImg;
	/**
	 * ��Ʒ��ͼ��
	 */
	private String bigImg;
	/**
	 * �����
	 */
	private int clickNum;
	/**
	 * �ϴ�ʱ��
	 */
	private Date updateTime;

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getClickNum() {
		return clickNum;
	}

	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsShow() {
		return goodsShow;
	}

	public void setGoodsShow(String goodsShow) {
		this.goodsShow = goodsShow;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getBtId() {
		return btId;
	}

	public void setBtId(int btId) {
		this.btId = btId;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsShow=" + goodsShow + ", goodsPrice="
				+ goodsPrice + ", goodsCount=" + goodsCount + ", season=" + season + ", btId=" + btId + ", stId=" + stId
				+ ", smallImg=" + smallImg + ", bigImg=" + bigImg + "]";
	}
}
