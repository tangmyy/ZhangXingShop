package zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import zx.bean.Users;
import zx.util.DBUtil;

public class UserDao {
	public void selectForLogin(Users user) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from users where name=? and pwd=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());   // 1 = wei zhi
			ps.setString(2, user.getPwd());   // 1 = wei zhi

			rs = ps.executeQuery();    // ��ѯ���������rs����
			while (rs.next()) {
				int id = rs.getInt(1);   // ���id��ֵ���� 0 ˵����¼��Ϣ��ȷ
				String tel = rs.getString("tel");
				String username = rs.getString(3);
				String pwd = rs.getString(4);
				String email = rs.getString(5);
				String sex = rs.getString(6);

				LocalDateTime createTimeValue = rs.getTimestamp("create_time").toLocalDateTime();				//ȡ��ʱ��
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:SS");				//����������ʾ��ʽ
//				String createTime = createTimeValue.format(formatter);				//��ȡ����ʱ��ת������Ҫ��ʱ���ʽ�ַ���

				//��װ����
				user.setId(id);
				user.setTel(tel);
//	    	    user.setName(userName);
				user.setEmail(email);
				user.setSex(sex);
				user.setCreatetime(createTimeValue);

			}
		} catch (SQLException e) {
			e.printStackTrace();   // ��Ҫɾ������������Ҫ�ڿ���̨�ҳ�ԭ��
			user.setId(-1);         // �����쳣����һ�������ݿ⣩
		} finally {
			DBUtil.closeDBResource(rs, ps, conn);
		}
		System.out.println("UserDao "+ user);
	}

	public static boolean selectForRegister(Users user) {
		Connection conn = DBUtil.getConn();
		String sql = "SELECT 1 FROM users WHERE name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(user);
		try {
			System.out.print(sql + "\n");
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			rs = ps.executeQuery();    // ��ѯ���������rs����
			return rs.next();  // ���������������ݣ����� true�����򷵻� false
		} catch (SQLException e) {
			e.printStackTrace();   // ��Ҫɾ������������Ҫ�ڿ���̨�ҳ�ԭ��
			return false;  // �����쳣ʱ������ false
		} finally {
			DBUtil.closeDBResource(rs, ps, conn);
		}

	}

	public static boolean InsertUser(Users user) {
		Connection conn = DBUtil.getConn();  // ��ȡ���ݿ�����
//		String sql = "INSERT INTO users (name, pwd, tel, email, sex, create_time) VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";  // SQL �������
		String sql = "insert into users(name,pwd,tel,email,sex,create_time) values(?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";  // SQL �������
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);  // Ԥ���� SQL ���
			ps.setString(1, user.getName());  // ���� SQL �������
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getTel());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getSex());
			int rowsInserted = ps.executeUpdate();  // ִ�в������
			return rowsInserted > 0;  // ��������������� 0������ true�����򷵻� false
		} catch (SQLException e) {
			e.printStackTrace();
			return false;  // �����쳣ʱ������ false
		} finally {
			DBUtil.closeDBResource(null, ps, conn);  // �ر����ݿ���Դ
		}
	}

	public static boolean ChangeUser(Users user) {
		Connection conn = DBUtil.getConn();  // ��ȡ���ݿ�����
		String sql = "UPDATE users SET pwd=? WHERE name=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);  // Ԥ���� SQL ���
			ps.setString(1, user.getPwd());
			ps.setString(2, user.getName());
			int rowsChange = ps.executeUpdate();  // ִ�в������
			return rowsChange > 0;  // ��������������� 0������ true�����򷵻� false
		} catch (SQLException e) {
			e.printStackTrace();
			return false;  // �����쳣ʱ������ false
		} finally {
			DBUtil.closeDBResource(null, ps, conn);  // �ر����ݿ���Դ
		}
	}

	public static String getJiuPassword(String username) {
		Connection conn = DBUtil.getConn();
		String sql = "SELECT pwd FROM users WHERE name=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("pwd"));
				return rs.getString("pwd");
			} else {
				return null; // �û�������
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null; // �����쳣ʱ������null
		} finally {
			DBUtil.closeDBResource(rs, ps, conn);
		}
	}


}



