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
	<form action="employee">
	<input type="submit" value ="getAllEmployee">
	</form>
	<c:forEach items="${empList}" var="emp">
		${emp.empId } &nbsp&nbsp&nbsp&nbsp ${emp.empName}&nbsp&nbsp&nbsp&nbsp ${emp.empSal }<br>
	</c:forEach>
</body>
</html>