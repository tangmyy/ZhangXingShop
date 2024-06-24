package zx.controller;

import zx.bean.MyShopCartDate;
import zx.bean.Users;
import zx.service.UserService;
import zx.util.MD5Util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1��ȡ�ͻ�������
      String rs_username = request.getParameter("rs_username");
      String rs_userpwd = request.getParameter("rs_userpwd");
      String rs_qruserpwd = request.getParameter("rs_qruserpwd");
      String rs_tel = request.getParameter("rs_tel");
      String rs_email = request.getParameter("rs_email");
      String rs_sex = request.getParameter("rs_sex");
      System.out.println("rs_username = " + rs_username);
      System.out.println("rs_qruserpwd = " + rs_qruserpwd);
      System.out.println("rs_userpwd = " + rs_userpwd);
      System.out.println("rs_tel = " + rs_tel);
      System.out.println("rs_email = " + rs_email);
      System.out.println("rs_sex = " + rs_sex);

      // �����������ʽУ��
      String TestEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
      Pattern pattern = Pattern.compile(TestEmail);
      Matcher matcher = pattern.matcher(rs_email);
      if (!matcher.matches()) {
         request.setAttribute("emailCheck", "�����ʽ����ȷ��");
         request.getRequestDispatcher("register.jsp").forward(request, response);
         return;
      }

      // �����У��
      if(!rs_userpwd.equals(rs_qruserpwd)){
         request.setAttribute("passwordCheck", "�����������벻һ�£�");
         request.getRequestDispatcher("register.jsp").forward(request, response);
         return;
      }


      // 2��װ����,����ҵ���߼�������������
      Users user = new Users();
      user.setName(rs_username);
      String pwdmd5 = MD5Util.getMD5Str(rs_userpwd);
      user.setPwd(pwdmd5);
      user.setTel(rs_tel);
      user.setEmail(rs_email);
      user.setSex(rs_sex);

      // 3����ҵ���߼���ķ��ؽ��������ͬ����Ӧ
      response.setContentType("text/html;charset=utf-8");
      if(!UserService.Register(user)){
         response.getWriter().write("���û��Ѵ��ڣ����һ����룡");
         response.setHeader("refresh", "3;register.jsp");
      } else {
         response.getWriter().write("ע��ɹ��� 3s����ת����¼ҳ��...");
         response.setHeader("refresh", "3;login.jsp");
      }

   }
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }
}