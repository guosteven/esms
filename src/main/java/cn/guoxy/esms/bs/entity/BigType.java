package cn.guoxy.esms.bs.entity;

/**
 * ��Ʒ�����ʵ����
 * 
 * @author gxy
 *
 */
public class BigType {
	/**
	 * ������ID
	 */
	private int btId;
	/**
	 * ������
	 */
	private String btName;

	public int getBtId() {
		return btId;
	}

	public void setBtId(int btId) {
		this.btId = btId;
	}

	public String getBtName() {
		return btName;
	}

	public void setBtName(String btName) {
		this.btName = btName;
	}

	@Override
	public String toString() {
		return "BigType [btId=" + btId + ", btName=" + btName + "]";
	}
}
