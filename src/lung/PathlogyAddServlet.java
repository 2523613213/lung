package lung;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//增加数据库条目操作
@WebServlet("/PathlogyAddServlet")
public class PathlogyAddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 //因为需要接受文件，因此采用二进制处理，因此对应提交表单需要增加enctype="multipart/form-data"
		 //接受包括图片在内总共14个数据，具体查看数据库
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		 ServletFileUpload sfu = new ServletFileUpload(factory); 
		 sfu.setHeaderEncoding("UTF-8");
		 try {
			List<FileItem> items = sfu.parseRequest(request);
			Pathlogy pathlogy = new Pathlogy(items.get(0).getString("utf-8"),
					items.get(1).getString("utf-8"),
					items.get(2).getString("utf-8"),
					items.get(3).getString("utf-8"),
					Integer.parseInt(items.get(4).getString("utf-8")),
					Integer.parseInt(items.get(5).getString("utf-8")),
					items.get(6).getString("utf-8"),
					items.get(7).getString("utf-8"),
					items.get(8).getString("utf-8"),
					items.get(9).getString("utf-8"),
					items.get(10).getString("utf-8"),
					items.get(11).getString("utf-8"),
					items.get(12).getString("utf-8"),
					items.get(13).getInputStream());
			PathlogyDao pd = new PathlogyDao();
			pd.add(pathlogy);
			
			//添加完毕之后的跳转页面
			response.sendRedirect(request.getContextPath()+"/Web/list.jsp");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	 }
	 
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}
}