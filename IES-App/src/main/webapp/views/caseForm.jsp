<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div align="center">
		${failMsg}
		<form action="/getApplicant" method="get">
			<br> <br> Application No : <input type="text"
				name="applicationNo" >
			<button class="btn btn-info">
				<i class="fa fa-search" aria-hidden="true"></i>
			</button>
		</form>
	</div>
</body>
</html>