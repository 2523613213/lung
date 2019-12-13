package lung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Blob;
import java.util.List;
import java.util.ArrayList;
//数据库操作
public class PathlogyDao {
	//连接数据库
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
	
	//删除操作
	public void del(String pathlogy) {
		Connection conn = getConnection();
		String sql = "delete from pathlogy where pathology = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pathlogy);
	    	ps.executeUpdate();
	    	conn.close();
		}catch (SQLException e) {
            e.printStackTrace();
        }
	}
	//添加新数据
	public void add(Pathlogy pathlogy) {
		Connection conn = getConnection();
	    String sql = "insert into pathlogy values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    try {
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, pathlogy.getPathlogy());
	    	ps.setString(2, pathlogy.getImage());
	    	ps.setString(3, pathlogy.getHospitalID());
	    	ps.setString(4, pathlogy.getName());
	    	ps.setInt(5, pathlogy.getAge());
	    	ps.setInt(6, pathlogy.getSex());
	    	ps.setString(7, pathlogy.getDiagnosis());
	    	ps.setString(8, pathlogy.getBig());
	    	ps.setString(9, pathlogy.getDescribe());
	    	ps.setString(10, pathlogy.getDepartment());
	    	ps.setString(11, pathlogy.getAdate());
	    	ps.setString(12, pathlogy.getBdate());
	    	ps.setString(13, pathlogy.getBed());
	    	ps.setBlob(14, pathlogy.getPic());
	    	ps.executeUpdate();
	    	conn.close();
	    }catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//更新数据
	public void update(Pathlogy pathlogy) {
		Connection conn = getConnection();
	    String sql ="update pathlogy set image = ?,hospitalID = ?,"
	    		+ "name = ?,age = ?,sex = ?,diagnosis = ?,big = ?,`describe` = ?,"
	    		+ "department = ?,adate = ?,bdate = ?,beg = ?,picture = ?"
	    		+ " where pathology = ?";
	    try {
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, pathlogy.getImage());
	    	ps.setString(2, pathlogy.getHospitalID());
	    	ps.setString(3, pathlogy.getName());
	    	ps.setInt(4, pathlogy.getAge());
	    	ps.setInt(5, pathlogy.getSex());
	    	ps.setString(6, pathlogy.getDiagnosis());
	    	ps.setString(7, pathlogy.getBig());
	    	ps.setString(8, pathlogy.getDescribe());
	    	ps.setString(9, pathlogy.getDepartment());
	    	ps.setString(10, pathlogy.getAdate());
	    	ps.setString(11, pathlogy.getBdate());
	    	ps.setString(12, pathlogy.getBed());
	    	ps.setBlob(13, pathlogy.getPic());
	    	ps.setString(14, pathlogy.getPathlogy());
	    	ps.executeUpdate();
	    	conn.close();
	    }catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	//查找数据
	public List<Pathlogy> find(String sql){
		Connection conn = getConnection();
		List<Pathlogy> list = new ArrayList<Pathlogy>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String pathlogy = rs.getString(1);
				String image = rs.getString(2);
				String hospitalID = rs.getString(3);
				String name = rs.getString(4);
				int age = rs.getInt(5);
				int sex = rs.getInt(6);
				String diagnosis = rs.getString(7);
				String big = rs.getString(8);
				String describe = rs.getString(9);
				String department = rs.getString(10);
				String adate = rs.getString(11);
				String bdate = rs.getString(12);
				String beg = rs.getString(13);
				Blob pic = rs.getBlob("picture");
				if(pic==null) {
					Pathlogy p = new Pathlogy(pathlogy,image,hospitalID,name,age,sex,diagnosis,big,describe,department,adate,bdate,beg);
					list.add(p);
				}
				else {
					Pathlogy p = new Pathlogy(pathlogy,image,hospitalID,name,age,sex,diagnosis,big,describe,department,adate,bdate,beg,pic.getBinaryStream());
					list.add(p);
				}
				
	    	}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
