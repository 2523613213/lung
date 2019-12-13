package lung;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//根据病理号查找数据
@WebServlet("/PathlogyFindOneServlet")
public class PathlogyFindOneServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PathlogyDao pd = new PathlogyDao();
		//前端传来的病理号
		String f = request.getParameter("pathlogy");
		
		String sql = "select * from pathlogy where pathology = '"+f+"'";
		List<Pathlogy> list = pd.find(sql);
		
		
		//虽然是个list，但是里面最少0条，最多1条，前段需要判别是否为空等对应处理
		request.setAttribute("list",list);
		//最后的跳转语句
		 request.getRequestDispatcher("/Web/list.jsp").forward(request,response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
