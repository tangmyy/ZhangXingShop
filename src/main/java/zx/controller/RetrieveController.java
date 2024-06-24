package zx.controller;

import zx.bean.Users;
import zx.dao.UserDao;
import zx.service.UserService;
import zx.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/RetrieveController")
public class RetrieveController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1��ȡ�ͻ�������
      String Ret_username = request.getParameter("Ret_username");
      String Ret_userpwd = request.getParameter("Ret_userpwd");
      String Ret_qruserpwd = request.getParameter("Ret_qruserpwd");
      String currentPwdMD5 = request.getParameter("oldPwdMD5");

      System.out.println("Ret_username = " + Ret_username);
      System.out.println("Ret_userpwd = " + Ret_userpwd);
      System.out.println("Ret_qruserpwd = " + Ret_qruserpwd);

      // �����������������Ƿ���ͬ
      if(!Ret_userpwd.equals(Ret_qruserpwd)){
         request.setAttribute("passwordCheck", "�����������벻һ�£�");
         request.getRequestDispatcher("retrieve.jsp").forward(request, response);
         return;
      }

      // 2��װ����,����ҵ���߼�������������
      Users user = new Users();
      user.setName(Ret_username);
      String pwdmd5 = MD5Util.getMD5Str(Ret_userpwd);
      user.setPwd(pwdmd5);

      // 3����ҵ���߼���ķ��ؽ��������ͬ����Ӧ
      response.setContentType("text/html;charset=utf-8");

      if(UserService.Retrieve(user)){
         response.getWriter().write("�޸ĳɹ��� 5s����ת����¼ҳ��...");
         response.setHeader("refresh", "5;login.jsp");
      } else {
         response.getWriter().write("���û������ڣ���ע�ᣡ 5s����ת��ע��ҳ��...");
         response.setHeader("refresh", "5;register.jsp");
      }

   }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }
}