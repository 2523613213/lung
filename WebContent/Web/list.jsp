<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="lung.Pathlogy" import="java.util.List"%>
<%@ page import="lung.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>test.html</title>
</head>
<body>
	<a href="/lung/Web/add.jsp">add</a>
	<form action="/lung/PathlogyFindAllServlet" method="post">
		<input type="hidden" name="a" value="0">
		<input type="hidden" name="b" value="10">
		<input type="submit" value="find">
	</form>
	
	<form action="/lung/PathlogyFindOneServlet" method="post">
		<input type="text" name="pathlogy">
		<input type="submit" value="find">
	</form>
	
	<form action="/lung/PathlogyFindTypeServlet" method="post">
		<input type="text" name="type">
		<input type="hidden" name="a" value="0">
		<input type="hidden" name="b" value="10">
		<input type="submit" value="find">
	</form>
	
	<form action="/lung/PathlogyDelServlet" method="post">
		<input type="text" name="del">
		<input type="submit" value="del">
	</form>
	
	<a href = "/lung/Web/update.jsp">update</a>
	<c:forEach items="${list}" var="it">
        <div>
            pathlogy:<c:out value="${it.getPathlogy()}" ></c:out><br>
            image:<c:out value="${it.getImage()}" ></c:out><br><br>
        </div>
    </c:forEach>
	
	
	
	
</body>
</html>