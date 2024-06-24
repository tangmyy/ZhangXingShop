package zx.util;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DBUtil {

	public static Connection getConn(){

		String DBDirverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DBUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=shop";
		String DBUser = "sa";
		String DBPwd = "2004";
		Connection connection = null;
		try {
			Class.forName(DBDirverName);
			connection = DriverManager.getConnection(DBUrl, DBUser, DBPwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLServerDriverû���ҵ�����������������");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.out.println("���ݿ����ӳ���������");
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeDBResource(ResultSet rs, Statement stm, Connection con) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stm != null) {
				stm.close();
				stm = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�ر����ݿ����������");
			e.printStackTrace();
		}

	}
	public  void printTableDataForTest(){
		Connection conn=getConn();
		String sql="select * from users";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();;
			while(rs.next()){
				int id=rs.getInt(1);
				String tel=rs.getString("tel");
				String username=rs.getString(3);
				String pwd=rs.getString(4);
				String email=rs.getString(5);
				String sex=rs.getString(6);

				//ȡ��ʱ��
				LocalDateTime createTimeValue = rs.getTimestamp("create_time").toLocalDateTime();
				//����������ʾ��ʽ
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:SS");
				//��ȡ����ʱ��ת������Ҫ��ʱ���ʽ�ַ���
				String createTime = createTimeValue.format(formatter);

				System.out.print(id+"\t");
				System.out.print(tel+"\t");
				System.out.print(username+"\t");
				System.out.print(pwd+"\t");
				System.out.print(createTime+"\t");
				System.out.print(sex+"\t\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();//��Ҫɾ������������Ҫ�ڿ���̨�ҳ�ԭ��
		}finally {
			closeDBResource(rs, ps, conn);
		}

	}
}
