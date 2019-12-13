package lung;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//根据诊断类别查找
@WebServlet("/PathlogyFindTypeServlet")
public class PathlogyFindTypeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PathlogyDao pd = new PathlogyDao();
		
		//接受两个数据，例如a=5,b=10 代表从数据库的第5条开始获取10条数据到第15条
		//a是从第几条开始搜索
		int a = Integer.parseInt(request.getParameter("a"));
		//b是搜索几条
		int b = Integer.parseInt(request.getParameter("b"));
		
		
		//接受查找类别
		String f = request.getParameter("type");
		String sql = "select * from pathlogy where diagnosis = '"+f+"' limit "+a+","+b;
		System.out.println(sql);
		List<Pathlogy> list = pd.find(sql);
		
		//返回数据
		request.setAttribute("list",list);
		
		//没有最后的跳转语句
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
