package cn.guoxy.esms.bs.entity;

/**
 * ��ƷС����ʵ����
 * 
 * @author gxy
 *
 */
public class SmallType {
	/**
	 * С����ID
	 */
	private int stId;
	/**
	 * С������
	 */
	private String stName;
	/**
	 * ������ID
	 */
	private int btId;

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public int getBtId() {
		return btId;
	}

	public void setBtId(int btId) {
		this.btId = btId;
	}

	@Override
	public String toString() {
		return "SmallType [stId=" + stId + ", stName=" + stName + ", btId=" + btId + "]";
	}
}
