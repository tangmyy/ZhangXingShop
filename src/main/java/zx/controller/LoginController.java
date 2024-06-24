package zx.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zx.bean.MyShopCartDate;
import zx.bean.Users;
import zx.service.UserService;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logout = request.getParameter("logout");
		if (logout != null){
			HttpSession session = request.getSession();
				session.invalidate();	// �������ٻỰ
			response.sendRedirect("HomeController");
			return;
		}
		// ��ȡ�ͻ�������
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");

		// 2��װ����,����ҵ���߼�������������
	  	 Users user = new Users();
	  	 user.setName(name);
	  	 user.setPwd(pwd);


		// ������̨��ʾ��	System.out.println("LoginController Class doGet:"+user.toString());
		System.out.println("name = "+name);
		System.out.println("pwd = "+pwd);
		System.out.println("LoginController "+ user);


	  	 UserService userService = new UserService();
	  	 userService.Login(user); 
	  	 // ����ҵ���߼���ķ��ؽ��������ͬ����Ӧ
	  	 response.setContentType("text/html;charset=utf-8");
	  	 if(user.getId() == null){
			response.getWriter().write("�����û�����������������������룺");
			response.setHeader("refresh", "5;login.jsp");
	  	 }else if(user.getId() == -1) {
			response.getWriter().write("ϵͳ���������Ժ����ԣ�");
			response.setHeader("refresh", "5;login.jsp");
	  	 }else {
			 HttpSession session = request.getSession();
			 session.setAttribute("user", user);
			 MyShopCartDate myShopCartDate = new MyShopCartDate(user.getId());		// ���ﳵ��ʼ��
			 session.setAttribute("myShopCartDate", myShopCartDate);
			 response.sendRedirect("HomeController");
	  	 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
