package lung;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lung.UserDao;
//登录servlet
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 
		 
		 //接受来自jsp的两个数据，分别代表用户名和密码
		 	String username = request.getParameter("user");
			String password = request.getParameter("password");
			User user = new User(username,password);
			UserDao userdao = new UserDao();

			if(userdao.finduser(user)==true) {
				//成功跳转到下一步页面
			 	response.sendRedirect(request.getContextPath()+"/Web/list.jsp");
			 	return;
			}
			else {
				//登录失败，重新登录，并附加一个error提示，在jsp页面中处理（例如弹窗提醒
				response.sendRedirect(request.getContextPath()+"?error=yes");
				return;
			}
	 }
	 
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}
}
