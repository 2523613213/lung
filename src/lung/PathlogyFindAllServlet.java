package lung;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//查看所有条目
@WebServlet("/PathlogyFindAllServlet")
public class PathlogyFindAllServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//接受两个数据，例如a=5,b=10 代表从数据库的第5条开始获取10条数据到第15条
		//a是从第几条开始搜索
		int a = Integer.parseInt(request.getParameter("a"));
		//b是搜索几条
		int b = Integer.parseInt(request.getParameter("b"));
		
		PathlogyDao pd = new PathlogyDao();
		String sql = "select * from pathlogy limit "+a+","+b;
		List<Pathlogy> list = pd.find(sql);
		System.out.println(list.size());
		//返回list
		request.setAttribute("list",list);
		//后面没写跳转语句，自行填写
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
