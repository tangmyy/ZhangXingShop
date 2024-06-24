package zx.service;

import zx.bean.Users;
import zx.dao.UserDao;
import zx.util.MD5Util;

public class UserService {

	public void Login(Users user) {
		String pwdmd5 = MD5Util.getMD5Str(user.getPwd());
		user.setPwd(pwdmd5);
		new UserDao().selectForLogin(user);
	}
	public static boolean Register(Users user) {
		// ���ȣ�����û��Ƿ���ע��
		if (UserDao.selectForRegister(user)) {
			System.out.println("�û���ע��");
			return false;
		} else {
			System.out.println("δע�ᣬ���Բ������û�");
			return UserDao.InsertUser(user);
		}
	}
	public static boolean Retrieve(Users user) {
		// ���ȣ�����û��Ƿ����
		if (UserDao.selectForRegister(user)) {
			// ��ע�ᣬ�޸�
			System.out.println("�û����ڣ������޸�");
			return UserDao.ChangeUser(user);		// �����޸ĺ���
		} else {
			// δע��
			System.out.println("�û������ڣ��޷��޸�");
			return false;
		}
	}
}
