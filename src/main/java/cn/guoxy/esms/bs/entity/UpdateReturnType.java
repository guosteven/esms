package cn.guoxy.esms.bs.entity;

/**
 * ��Ʒ�ϴ�����ֵ����ʵ����
 * 
 * @author gxy
 *
 */
public class UpdateReturnType {
	/**
	 * ״̬�� 0:���� 1���ļ������� 2������������
	 */
	private int code;
	/**
	 * ԭʼͼƬ��
	 */
	private String smallImg;
	/**
	 * ��ͼƬ��
	 */
	private String bigImg;

	public UpdateReturnType() {
	}

	public UpdateReturnType(int code, String smallImg, String bigImg) {
		super();
		this.code = code;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
		return "UpdateReturnType [code=" + code + ", smallImg=" + smallImg + ", bigImg=" + bigImg + "]";
	}
}
