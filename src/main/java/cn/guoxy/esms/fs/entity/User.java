package cn.guoxy.esms.fs.entity;

/**
 * �û�ʵ����
 * 
 * @author gxy
 *
 */
public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", userName=" + userName + ", pwd=" + pwd + ", vip=" + vip + "]";
	}

	/**
	 * �û�ID
	 */
	private int id;
	/**
	 * ����
	 */
	private String email;
	/**
	 * �û���
	 */
	private String userName;
	/**
	 * ����
	 */
	private String pwd;
	/**
	 * �ȼ�
	 */
	private int vip;

	public User(String email, String userName, String pwd) {
		super();
		this.email = email;
		this.userName = userName;
		this.pwd = pwd;
	}

	public User(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}

	public User(int id, String userName, String pwd) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
	}

	public User(int id, String userName, String pwd, int vip) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.vip = vip;
	}

	public User(int id, String email, String userName, String pwd, int vip) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.pwd = pwd;
		this.vip = vip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String uSerName) {
		this.userName = uSerName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getVip() {
		return vip;
	}

	public void setVip(int vip) {
		this.vip = vip;
	}
}
