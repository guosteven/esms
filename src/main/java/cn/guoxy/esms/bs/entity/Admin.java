package cn.guoxy.esms.bs.entity;

/**
 * ����Աʵ����
 * 
 * @author gxy
 *
 */
public class Admin {
	/**
	 * ����ԱID
	 */
	private int adminId;
	/**
	 * ����Ա����
	 */
	private String adminName;
	/**
	 * ����Ա����
	 */
	private String adminPwd;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPwd=" + adminPwd + "]";
	}

}
