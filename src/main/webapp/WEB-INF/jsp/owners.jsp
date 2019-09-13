<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
			<thead>
				<tr>
					<td>Id</td>
					<td>Ad</td>
					<td>Soyad</td>
				</tr>
			</thead>			
			<tbody>
			<c:forEach items="${owners}" var="ls">
				<tr>					
					<td>${ls.id}</td>
					<td>${ls.firtName}</td>
					<td>${ls.lastName}</td>					
				</tr>
			</c:forEach>
				
			</tbody>
	</table>
</body>
</html>