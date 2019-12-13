package lung;
//登录用户实体类
public class User {
	private String name;
	private String password;
	
	public User(String n,String p) {
		name = n;
		password = p;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String n) {
		name = n;
	}
	
	public String getpassword() {
		return password;
	}
	
	public void setpassword(String p) {
		password = p;
	}
}
