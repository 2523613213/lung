<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="lung.*"%>
<!DOCTYPE html>
<html>
<head>
<title>login.html</title>
</head>
<body>
	<form action="/lung/UserServlet" method="post">
		Username:<input type="text" name="user"><br />
		Password:<input type="password" name="password"><br />
		<input type="submit" value="Login"><br />
	</form>
	<script> 
	  //取出传回来的参数error并与yes比较
	  var errori ='<%=request.getParameter("error")%>';
	  if(errori=='yes'){
	   alert("登录失败!");
	  }
	</script>
</body>
</html>
