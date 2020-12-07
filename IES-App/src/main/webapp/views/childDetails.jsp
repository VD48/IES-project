<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Child Details</title>
<link
	href='https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/ui-lightness/jquery-ui.css'
	rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="styles.css" />
<link rel="stylesheet" type="text/css" href="radio.css" />
<link rel="stylesheet" type="text/css" href="table.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
	
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js">
	
</script>
<script>
	$(document).ready(function() {

		$(function() {
			$("#datepicker").datepicker();
		});
	})
</script>

</head>
<body>
	<div align="center">
		${succMsg}
		<h3>
			<font color="red">Child Details</font>
		</h3>
		<form:form action="/childPlan" modelAttribute="childDetails"
			method="post">
			<table>
			    
				<tr>
					<th>Case No</th>
				</tr>
				<tr>
					<td><form:input path="caseNo" readonly="true" /></td>
				</tr>
				<tr>
					<th>Individual's Name</th>
				</tr>
				<tr>
					<td><form:input path="firstName" required="required"
							readonly="true" /></td>
				</tr>
				<tr>
					<th>Child's Name</th>
				</tr>
				<tr>
					<td><form:input path="childName" required="required" /></td>
				</tr>
				<tr>
					<th>Child Gender</th>
				</tr>
				<tr>
					<td>Male<form:radiobutton path="childGender" value="Male"
							cssClass="container" /></td>
					<td>Female<form:radiobutton path="childGender" value="Female"
							cssClass="container" /></td>
				</tr>
				<tr>
					<th>Date of Birth</th>
				</tr>
				<tr>
					<td><form:input path="ChildDob" id="datepicker" /></td>
				</tr>


				<tr>
					<th>SSN no</th>
				</tr>
				<tr>
					<td><form:input path="childSSN" maxlength="12"
							required="required" /></td>
				</tr>
				<tr>

					<td><input type="submit" value="Add" id="sumbitbtn"></td>
				</tr>


			</table>

		</form:form>
		<a href="/viewChilds">view Childs</a>
	</div>
	
</body>
</html>