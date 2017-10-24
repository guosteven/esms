package cn.guoxy.esms.fs.entity;

/**
 * �Զ��巵�����ͣ�ʵ�ַ��ص�һ����
 * 
 * @author gxy
 *
 */
public class ReturnType {
	/**
	 * ״̬��
	 */
	private int code;
	/**
	 * ��Ϣ
	 */
	private String message;

	public ReturnType(int code) {
		super();
		this.code = code;
	}

	public ReturnType(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "ReturnType [code=" + code + ", message=" + message + "]";
	}

}
