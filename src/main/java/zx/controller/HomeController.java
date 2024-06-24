
package zx.controller;

import zx.bean.HomeData;
import zx.service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginDao
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�ͻ�������
		String keyword = request.getParameter("keyword");
		int sort = (request.getParameter("sort")==null)?0:Integer.parseInt(request.getParameter("sort"));
		int curPage = (request.getParameter("curPage")==null)?1:Integer.parseInt(request.getParameter("curPage"));



		// ����ģ�Ͳ㴦��ҵ��
		HomeData homeData = new HomeData(keyword,sort,curPage);
		System.out.println(homeData);
		CommodityService.prepareForHomeData(homeData);

		// ���ؼ�����Ϣ���õ����������У��Ա���ҳ����ʹ��
		request.setAttribute("keyword", keyword);

		// �Ѵ��������ݴ�����Ӧ��jsp�ϣ���Ӧ�ͻ��ˣ�
		request.setAttribute("homeData", homeData);											// key-value String-HomeData
		request.getRequestDispatcher("home.jsp").forward(request, response);		// request��response��ʲô��

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
