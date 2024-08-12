<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome user</h3>
	<form action="customer">
	<input type="submit" value ="getAll">
	</form>
	<c:forEach items="${custList}" var="cust">
		${cust.id } &nbsp&nbsp&nbsp&nbsp ${cust.name}&nbsp&nbsp&nbsp&nbsp ${cust.email }<br>
	</c:forEach>
</body>
</html>