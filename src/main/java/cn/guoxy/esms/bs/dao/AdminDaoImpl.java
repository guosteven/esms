package cn.guoxy.esms.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.guoxy.esms.bs.entity.Admin;

/**
 * ����Ա�־ò�ʵ����
 * 
 * @author gxy
 *
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	@Resource(name = "ds")
	private DataSource ds;

	public Admin findByName(String name) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from admin where adminName = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				return admin;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
