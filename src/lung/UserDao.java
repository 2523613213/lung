package lung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//登录相关数据库操作类
public class UserDao {

	public Connection getConnection() {
		Connection conn = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
          //这里需要根据自己电脑数据库进行相应修改
            String url = "jdbc:mysql://127.0.0.1:3306/lung?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
            String username = "root";
            String password = "jiu999999";
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
	}
	
	public boolean finduser(User user) {
		Connection conn = getConnection();
	    String sql = "select * from user where name = ?";
	    try {
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, user.getname());
	    	//System.out.println("getname = "+user.getname());
	    	ResultSet rs = ps.executeQuery();
	    	while(rs.next()) {
	    		//System.out.println(rs.getString("password"));
	    		//System.out.println(user.getpassword());
	    		if(user.getpassword().equals(rs.getString("password"))) {
	    			conn.close();
	    			return true;
	    		}
    			conn.close();
	    		return false;
	    	}
	    }catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
	/*public static void main(String[] args) {
		//System.out.println("hello");
		User user = new User("root","123");
		UserDao userdao = new UserDao();
		System.out.println(userdao.finduser(user));
	}*/
	
}
