<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/lung/PathlogyUpdateServlet" method="post" enctype="multipart/form-data">
		病理号:<input type="text" name="pathlogy"><br />
		图片号:<input type="text" name="image"><br />
		住院号:<input type="text" name="hospitalID"><br />
		姓名:<input type="text" name="name"><br />
		年龄:<input type="text" name="age" oninput="value=value.replace(/[^\d]/g,'')" maxlength="3"><br />
		性别:<input type="text" name="sex"  oninput="this.value=this.value.replace(/[^0-1]/g, '')"  maxlength="1"><br />
		病理诊断:<input type="text" name="diagnosis"><br />
		癌症大小:<input type="text" name="big"><br />
		癌症描述:<input type="text" name="describe"><br />
		送检科室:<input type="text" name="department"><br />
		接受日期:<input type="text" name="adate"><br />
		报告日期:<input type="text" name="bdate"><br />
		床号:<input type="text" name="beg"><br />
		图片:<input type="file" name="file"><br />
		<input type="submit" value="Add"><br />
	</form>
</body>
</html>