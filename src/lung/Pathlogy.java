package lung;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
//病理实体类
public class Pathlogy {
	public Pathlogy(String pathlogy, String image, String hospitalID, String name, int age, int sex, String diagnosis,
			String big, String describe, String department, String adate, String bdate, String bed, InputStream pic) {
		super();
		this.pathlogy = pathlogy;
		this.image = image;
		this.hospitalID = hospitalID;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.diagnosis = diagnosis;
		this.big = big;
		this.describe = describe;
		this.department = department;
		this.adate = adate;
		this.bdate = bdate;
		this.bed = bed;
		this.pic = pic;
	}
	public Pathlogy(String pathlogy, String image, String hospitalID, String name, int age, int sex, String diagnosis,
			String big, String describe, String department, String adate, String bdate, String bed, Blob pic) throws SQLException {
		super();
		this.pathlogy = pathlogy;
		this.image = image;
		this.hospitalID = hospitalID;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.diagnosis = diagnosis;
		this.big = big;
		this.describe = describe;
		this.department = department;
		this.adate = adate;
		this.bdate = bdate;
		this.bed = bed;
		this.pic = pic.getBinaryStream();
	}
	public Pathlogy(String pathlogy, String image, String hospitalID, String name, int age, int sex, String diagnosis,
			String big, String describe, String department, String adate, String bdate, String bed) {
		this.pathlogy = pathlogy;
		this.image = image;
		this.hospitalID = hospitalID;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.diagnosis = diagnosis;
		this.big = big;
		this.describe = describe;
		this.department = department;
		this.adate = adate;
		this.bdate = bdate;
		this.bed = bed;
	}
	//病理号
	private String pathlogy;
	//图片号
	private String image;
	//住院号
	private String hospitalID;
	//姓名
	private String name;
	//年龄
	private int age;
	//性别
	private int sex;
	//病理诊断
	private String diagnosis;
	//癌症大小
	private String big;
	//癌症描述
	private String describe;
	//送检科室
	private String department;
	//接受日期
	private String adate;
	//报告日期
	private String bdate;
	//床号
	private String bed;
	//图片
	private InputStream pic;
	
	public String getPathlogy() {
		return pathlogy;
	}
	public void setPathlogy(String pathlogy) {
		this.pathlogy = pathlogy;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(String hospitalID) {
		this.hospitalID = hospitalID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getBig() {
		return big;
	}
	public void setBig(String big) {
		this.big = big;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public InputStream getPic() {
		return pic;
	}
	public void setPic(InputStream pic) {
		this.pic = pic;
	}
}
