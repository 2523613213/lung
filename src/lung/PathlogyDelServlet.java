package lung;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//删除操作
@WebServlet("/PathlogyDelServlet")
public class PathlogyDelServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 PathlogyDao pd = new PathlogyDao();
		 //接受待删除的条目对应的主键pathlogy病理号
		 String willdel = request.getParameter("del");
		 pd.del(willdel);
		 //没有写删除完毕后的跳转语句，可以参照Add操作中的类似语句自行添加
	 }
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
